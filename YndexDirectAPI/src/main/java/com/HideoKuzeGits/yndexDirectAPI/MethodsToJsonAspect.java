package com.HideoKuzeGits.yndexDirectAPI;

import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.AbstractWrap;
import com.google.gson.*;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by root on 22.06.14.
 */

@Aspect
public class MethodsToJsonAspect {

    public static enum Locale{ru, ua, en};

    private Gson gson;
    private CloseableHttpClient httpclient;
    private String token;
    private Locale locale;
    private AuthorizationErrorHandler authorizationErrorHandler;


    {
        gson = new Gson();
    }

    private YndexDirectAPI yndexDirectAPI;

    @Pointcut("execution(* com.HideoKuzeGits.yndexDirectAPI.YndexDirectAPI..*(..))")
    public void yndexDirectAPIMethod() {
    }

    @Pointcut("@annotation(com.HideoKuzeGits.yndexDirectAPI.ApiMethod)")
    public void apiMathod() {
    }

    @Around("(yndexDirectAPIMethod()) && apiMathod() &&target(yndexDirectAPI)")
    public Object apiMethodAspect(ProceedingJoinPoint thisJoinPoint, YndexDirectAPI yndexDirectAPI) {
        this.yndexDirectAPI = yndexDirectAPI;
        token = yndexDirectAPI.token;
        locale = yndexDirectAPI.getLocale();
        httpclient = yndexDirectAPI.getHttpClient();
        authorizationErrorHandler = yndexDirectAPI.getAuthorizationErrorHandler();

        //Преобразования метода в json обект для запроса
        String jsonString = generateJSON(thisJoinPoint);

        //Отправляем запром и получаем ответ
        String resultJson = sendRequest(jsonString, httpclient, yndexDirectAPI.getDirectApiUrl());
        //Преобразуем json обект в java обект и возвращаем
        Object resultObject = getResultObject(resultJson, thisJoinPoint);
        return resultObject;
    }

    public String sendRequest(String jsonString, CloseableHttpClient httpclient, String directApiUrl) {
        HttpPost httpPost = new HttpPost(directApiUrl);

        StringEntity params = new StringEntity(jsonString, "UTF-8");

        httpPost.setEntity(params);
        CloseableHttpResponse response = null;
        String resultJson = null;
        try {
            response = httpclient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
            }

            InputStream inputStream = response.getEntity().getContent();
            resultJson = new String(IOUtils.toByteArray(inputStream));

            if (resultJson.contains("Authorization error") && (authorizationErrorHandler != null))
                authorizationErrorHandler.handleAuthorizationError(token);

            if (resultJson.contains("error_code"))
                throw new WrongRequestException(jsonString, resultJson);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultJson;
    }

    //Преобразования метода в json обект для запроса
    private String generateJSON(ProceedingJoinPoint thisJoinPoint) {
        JsonObject jsonObject = new JsonObject();
        MethodSignature methodSignature = (MethodSignature) thisJoinPoint.getSignature();

        String methodName = getMethodName(methodSignature);

        jsonObject.addProperty("method", methodName);
        jsonObject.addProperty("token", token);


        if (locale != null)
            jsonObject.addProperty("locale", locale.name());

        // if (methodSignature)
        Method method = methodSignature.getMethod();

        Annotation[] annotations = method.getAnnotations();

        //if method is finance add operation_num and finance_token
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(FinancialMethod.class)) {
                addFinanceMethodParameters(jsonObject, methodName);
            }
        }

        String[] parameterNames = methodSignature.getParameterNames();

        if (parameterNames.length == 0)
            return jsonObject.toString();


        JsonElement paramJsonObject = new JsonObject();
        Object[] args = thisJoinPoint.getArgs();

        boolean flag = true;

        for (Object arg : args) {
            if (arg != null)
                flag = false;
        }

        if (flag)
            return jsonObject.toString();

        if (getApiMethodAnnotation(methodSignature).withoutNane()) {
            jsonObject.add("param", gson.toJsonTree(args[0]));
            return jsonObject.toString();
        }


        for (int i = 0; i < parameterNames.length; i++) {
            String argName = firstLatterToUpperCase(parameterNames[i]);
            Object arg = args[i];
            //Если для параметров есть Оберточный обект и он используеться то убираем приставку
            // назваиня аргумента и добавляем его
            if (arg != null)
                if (!arg.getClass().isPrimitive() && !arg.getClass().isArray())
                    if (arg.getClass().getPackage().equals(AbstractWrap.class.getPackage()) || List.class.isAssignableFrom(arg.getClass()))
                        paramJsonObject = gson.toJsonTree(arg);
                    else
                        paramJsonObject.getAsJsonObject().add(argName, gson.toJsonTree(arg));
                else
                    paramJsonObject.getAsJsonObject().add(argName, gson.toJsonTree(arg));
        }

        jsonObject.add("param", paramJsonObject);


        return jsonObject.toString();
    }

    private void addFinanceMethodParameters(JsonObject jsonObject, String methodName) {
        long operationNum = System.currentTimeMillis();
        jsonObject.addProperty("operation_num", operationNum);
        String concatenateString = yndexDirectAPI.masterToken
                + operationNum;

        concatenateString = concatenateString + methodName;

        String login = yndexDirectAPI.getClientInfo().getLogin();
        concatenateString = concatenateString + login;

        try {
            String s = MethodsToJsonAspect.hash256(concatenateString);
            jsonObject.addProperty("finance_token", s);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    private String getMethodName(MethodSignature methodSignature) {
        ApiMethod apiMethodsAnnotation = getApiMethodAnnotation(methodSignature);
        String methodName = apiMethodsAnnotation.methodName();
        if (methodName.equals(""))
            methodName = methodSignature.getName();
        return firstLatterToUpperCase(methodName);
    }

    private ApiMethod getApiMethodAnnotation(MethodSignature methodSignature) {
        Method method = methodSignature.getMethod();
        Annotation[] annotations = method.getAnnotations();
        return (ApiMethod) annotations[0];
    }

    private Object getResultObject(String resultJson, JoinPoint thisJoinPoint) {
        //  System.out.println(resultJson);
        MethodSignature methodSignature = (MethodSignature) thisJoinPoint.getSignature();

        Class returnType = methodSignature.getReturnType();

        Object resultObject = null;

        //Получаем сами данные из оьекта
        JsonElement jsonElement = new JsonParser().parse(resultJson);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonElement jsonDataElement = jsonObject.get("data");


        JsonElement resultElement = null;

        if (jsonDataElement.isJsonPrimitive() || returnType.isArray() || !jsonDataElement.isJsonArray()) {
            // try catch для облегчение добавления нового метода выставляем в api класе void и запускаем в консоли получаем json ответ
            try {
                resultObject = gson.fromJson(jsonDataElement, returnType);
            } catch (IllegalArgumentException e) {
                System.out.println(jsonDataElement);
                e.printStackTrace();
            }
        } else {

            JsonArray jsonArray = jsonDataElement.getAsJsonArray();
            if (jsonArray.size() != 0)
                resultElement = jsonArray.get(0);

            // try catch для облегчение добавления нового метода выставляем в api класе void и запускаем в консоли получаем json ответ
            try {
                resultObject = gson.fromJson(resultElement, returnType);

            } catch (IllegalArgumentException e) {
                System.out.println(resultElement);
                e.printStackTrace();
            }

        }

        return resultObject;
    }

    private String firstLatterToUpperCase(String s) {

        String firstLatter = String.valueOf(s.charAt(0));
        String firstLatterUpperCase = firstLatter.toUpperCase();
        s = firstLatterUpperCase + s.substring(1);
        return s;
    }

    public static String hash256(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(data.getBytes());
        return bytesToHex(md.digest());
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte byt : bytes) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }

}
