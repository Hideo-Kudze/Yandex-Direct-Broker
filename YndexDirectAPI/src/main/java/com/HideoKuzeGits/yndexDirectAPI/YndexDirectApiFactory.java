package com.HideoKuzeGits.yndexDirectAPI;


import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


/**
 * Created by root on 09.08.14.
 */
public class YndexDirectApiFactory {

    public static final String SANDBOX_TOKEN = "774be0bbb4864bfb93cc85a86a269501";
    public static final String SANDBOX_MASTER_TOKEN = "QPBmVgDctnFOAJka";
    private CloseableHttpClient httpClient;
    private AuthorizationErrorHandler authorizationErrorHandler;
    private MethodsToJsonAspect.Locale locale;

    public YndexDirectApiFactory() {}

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public AuthorizationErrorHandler getAuthorizationErrorHandler() {
        return authorizationErrorHandler;
    }

    public void setAuthorizationErrorHandler(AuthorizationErrorHandler authorizationErrorHandler) {
        this.authorizationErrorHandler = authorizationErrorHandler;
    }

    public YndexDirectAPI createYndexDirectApi(String token) {

        //For tests.
        boolean isSandboxAccount = token.endsWith("Sandbox");
        if (isSandboxAccount)
            token = token.replaceAll("Sandbox","");


        YndexDirectAPI yndexDirectAPI = new YndexDirectAPI(token);

        //For tests.
        if (isSandboxAccount)
            yndexDirectAPI.directApiUrl = YndexDirectAPI.DIRECT_API_SANDBOX_URL;


        if (httpClient != null)
            yndexDirectAPI.setHttpClient(httpClient);
        else
            yndexDirectAPI.setHttpClient(HttpClients.createDefault());



        yndexDirectAPI.setAuthorizationErrorHandler(authorizationErrorHandler);
        yndexDirectAPI.setLocale(locale);

        return yndexDirectAPI;
    }

    public YndexDirectAPI createYndexDirectApi(String token, String masterToken) {

        YndexDirectAPI yndexDirectApi = createYndexDirectApi(token);
        yndexDirectApi.setMasterToken(masterToken);

        return yndexDirectApi;
    }

    public YndexDirectAPI createContextrelcomSandboxApi() {
        YndexDirectAPI yndexDirectAPI
                =  createYndexDirectApi("2e02af49416a44eb8c9801c387cf7f0b", "yzHQvsthS8QMKTk4");
        yndexDirectAPI.directApiUrl = YndexDirectAPI.DIRECT_API_SANDBOX_URL;
        return yndexDirectAPI;

    }


    public YndexDirectAPI createSandboxApi() {

        YndexDirectAPI yndexDirectAPI = createYndexDirectApi(SANDBOX_TOKEN, SANDBOX_MASTER_TOKEN);

        yndexDirectAPI.directApiUrl = YndexDirectAPI.DIRECT_API_SANDBOX_URL;
        return yndexDirectAPI;
    }

    public MethodsToJsonAspect.Locale getLocale() {
        return locale;
    }

    public void setLocale(MethodsToJsonAspect.Locale locale) {
        this.locale = locale;
    }
}
