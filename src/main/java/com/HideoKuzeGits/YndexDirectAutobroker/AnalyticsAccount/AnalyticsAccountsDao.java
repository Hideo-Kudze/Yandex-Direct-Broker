package com.HideoKuzeGits.YndexDirectAutobroker.AnalyticsAccount;

import com.HideoKuzeGits.YndexDirectAutobroker.domain.GoogleAnalytics.AnalyticsWebproperty;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.APIAccounts.GoogleAnalyticsAccount;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.analytics.AnalyticsScopes;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;

/**
 * Created by root on 16.07.14.
 */

@Service
public class AnalyticsAccountsDao {

    public static final String CLIENT_ID = "335612892061-4mh3ug5fsorb3sab72qceekhip8otuvu.apps.googleusercontent.com";
    public static final String CLIENT_SECRET = "CBWgwa8FYHZkHnEJem39GPtC";
    private static final String REDIRECT_URI = "http://localhost:8080/addAnalyticsAccount";
    public static final String AUTHORIZATION_URL;
    private static final GoogleAuthorizationCodeFlow googleAuthorizationCodeFlow;



    static {
        googleAuthorizationCodeFlow = new GoogleAuthorizationCodeFlow.Builder(
                new NetHttpTransport(),
                JacksonFactory.getDefaultInstance(),
                CLIENT_ID,
                CLIENT_SECRET,
                Arrays.<String>asList(AnalyticsScopes.ANALYTICS_READONLY, "https://www.googleapis.com/auth/userinfo.email")
        ).setAccessType("offline").build();

        GoogleAuthorizationCodeRequestUrl authorizationCodeRequestUrl
                = googleAuthorizationCodeFlow
                .newAuthorizationUrl()
                .setRedirectUri(REDIRECT_URI)
                .setApprovalPrompt("force");


        AUTHORIZATION_URL = authorizationCodeRequestUrl.toString();

    }


    @PersistenceContext
    EntityManager em;


    @Transactional
    public GoogleAnalyticsAccount saveAccount(String code) throws IOException {
        GoogleTokenResponse tokenResponse = googleAuthorizationCodeFlow
                .newTokenRequest(code)
                .setRedirectUri(REDIRECT_URI)
                .execute();

        String refreshToken = tokenResponse.getRefreshToken();
        GoogleAnalyticsAccount googleAnalyticsAccount
                = new GoogleAnalyticsAccount(refreshToken);



        em.persist(googleAnalyticsAccount);
        return null;
    }


    public GoogleAnalyticsAccount getAccount(String userName) {

        return em.find(GoogleAnalyticsAccount.class, userName);

    }

    public List<GoogleAnalyticsAccount> getAccounts() {
        Query query = em.createQuery("SELECT p FROM GoogleAnalyticsAccount p");
        return query.getResultList();
    }




    public List<AnalyticsWebproperty> getWebproperties() {
        Query query = em.createQuery("SELECT p FROM AnalyticsWebproperty p", AnalyticsWebproperty.class);
        return query.getResultList();
    }




    private String getRepairUrl(String login) {
        GoogleAuthorizationCodeRequestUrl authorizationCodeRequestUrl
                = googleAuthorizationCodeFlow
                .newAuthorizationUrl()
                .setRedirectUri(REDIRECT_URI)
                .setApprovalPrompt("force");
        return authorizationCodeRequestUrl.toString();
    }


}
