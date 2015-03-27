package com.HideoKuzeGits.YndexDirectAutobroker.DirectAccount;

import com.HideoKuzeGits.YndexDirectAutobroker.domain.APIAccounts.YndexDirectAccount;
import com.HideoKuzeGits.yndexDirectAPI.YndexDirectAPI;
import com.HideoKuzeGits.yndexDirectAPI.YndexDirectApiFactory;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.ClientInfo;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by root on 16.07.14.
 */

@Service
public class DirectAccountsService  {


    @PersistenceContext EntityManager em;

    @Autowired
    private YndexDirectApiFactory yndexDirectApiFactory;

    @Transactional
    public YndexDirectAccount saveAccount(String code, String userName) throws IOException {
        String token = getToken(code);
        YndexDirectAPI yndexDirectApi = yndexDirectApiFactory.createYndexDirectApi(token);
        ClientInfo clientInfo = yndexDirectApi.getClientInfo();
        String login = clientInfo.getLogin();
        String FIO = clientInfo.getFIO();
        YndexDirectAccount yndexDirectAccount = new YndexDirectAccount(token, login, userName, FIO);
        em.merge(yndexDirectAccount);
        return yndexDirectAccount;
    }

    
    private String getToken(String code) throws IOException {
        String url = "https://oauth.yandex.ru/token";
        String requestBody = "grant_type=authorization_code&code=" + code +
                "&client_id=" + "7f237c1382cd4224938b923f1d4b1419" +
                "&client_secret=" + "99e6d68a6585461c8be3514f2d9c7a43";

        String responseString = sendPost(url, requestBody);
        String token = getTokenFromRespone(responseString);
        return token;

    }

    
    private  String getTokenFromRespone(String s) {
        String beginStr = "\"access_token\": \"";
        int begin = s.lastIndexOf(beginStr);
        int end = s.indexOf("\", \"expires_in\":");
        return s.substring(begin + beginStr.length(), end);
    }

    public YndexDirectAccount getAccount(String userName){
        YndexDirectAccount yndexDirectAccount = em.find(YndexDirectAccount.class, userName);
        return yndexDirectAccount;
    }

    public List<YndexDirectAccount> getAccounts(){
        Query query = em.createQuery("SELECT e FROM YndexDirectAccount e");
        List<YndexDirectAccount> resultList = (List<YndexDirectAccount>) query.getResultList();
        return resultList;
    }

    private String sendPost(String url, String requestBody) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type","application/x-www-form-urlencoded");
        StringEntity stringEntity = new StringEntity(requestBody, "UTF-8");
        httpPost.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        InputStream inputStream = response.getEntity().getContent();
        String responseString = new String(IOUtils.toByteArray(inputStream));

        return responseString;
    }

}
