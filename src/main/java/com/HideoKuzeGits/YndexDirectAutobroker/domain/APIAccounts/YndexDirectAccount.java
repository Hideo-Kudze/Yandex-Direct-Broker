package com.HideoKuzeGits.YndexDirectAutobroker.domain.APIAccounts;

import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.AbstractWrap;
import org.hibernate.annotations.Cascade;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by root on 21.07.14.
 */

@Entity
public class YndexDirectAccount extends AbstractWrap  {

    @Id
    private String normalized_user_name;

    private String token;

    private String user_name;

    private String masterToken;


    public YndexDirectAccount() {
    }

    public YndexDirectAccount(String token, String normalized_user_name, String userName, String FIO) {
        this.token = token;
        this.normalized_user_name = normalized_user_name;
        this.user_name = userName;
    }

    public String getMasterToken() {
        return masterToken;
    }

    public void setMasterToken(String masterToken) {
        this.masterToken = masterToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNormalized_user_name() {
        return normalized_user_name;
    }

    public void setNormalized_user_name(String normalized_user_name) {
        this.normalized_user_name = normalized_user_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
