package com.HideoKuzeGits.YndexDirectAutobroker.domain.APIAccounts;

import com.HideoKuzeGits.YndexDirectAutobroker.UsefulStaticMethods;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.analytics.Analytics;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.IOException;

import static com.HideoKuzeGits.YndexDirectAutobroker.AnalyticsAccount.AnalyticsAccountsDao.CLIENT_ID;
import static com.HideoKuzeGits.YndexDirectAutobroker.AnalyticsAccount.AnalyticsAccountsDao.CLIENT_SECRET;

/**
 * Created by root on 08.08.14.
 */

@Entity
public class GoogleAnalyticsAccount {

    @Id
    private String userName;

    private String refreshToken;

    @Transient
    private Analytics analytic;
    @Transient
    private GoogleCredential googleCredential;


    public GoogleAnalyticsAccount() {
    }

    public GoogleAnalyticsAccount(String refreshToken) throws IOException {
        this.refreshToken = refreshToken;
        initUserName();
    }


    private void initUserName()  throws IOException {
        if (userName == null) {
            NetHttpTransport httpTransport = new NetHttpTransport();
            String userinfoUrl = "https://www.googleapis.com/userinfo/v2/me?" + "access_token="
                    + getGoogleCredential().getAccessToken();

            HttpResponse httpResponse = httpTransport
                    .createRequestFactory()
                    .buildGetRequest(new GenericUrl(userinfoUrl))
                    .execute();

            String responseString = httpResponse.parseAsString();
            userName = UsefulStaticMethods.getStringBetween(responseString, "\"email\": \"", "@");
        }
    }


    public String getUserName(){

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Analytics getAnalytics() throws IOException {

        if (analytic == null) {
            GoogleCredential credential = getGoogleCredential();
            analytic = new Analytics.Builder(
                    new NetHttpTransport()
                    , JacksonFactory.getDefaultInstance()
                    , credential).build();

        }

        return analytic;
    }

    public GoogleCredential getGoogleCredential() throws IOException {

        if (googleCredential == null) {
            googleCredential = new GoogleCredential.Builder()
                    .setTransport(new NetHttpTransport())
                    .setJsonFactory(JacksonFactory.getDefaultInstance())
                    .setClientSecrets(CLIENT_ID, CLIENT_SECRET)
                    .build();

            googleCredential.setRefreshToken(refreshToken);
            googleCredential.refreshToken();
        }

        return googleCredential;
    }


    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof GoogleAnalyticsAccount))
            return false;
        if (obj == this)
            return true;

        GoogleAnalyticsAccount account = (GoogleAnalyticsAccount) obj;

        return account.getUserName().equals(userName);
    }

    @Override
    public int hashCode() {
        return userName.hashCode();
    }
}


