package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class AccountActionResult extends AbstractWrap{

    @SerializedName("AccountID")
    @Expose
    private Long accountID;
    @SerializedName("Login")
    @Expose
    private String login;
    @SerializedName("URL")
    @Expose
    private String uRL;
    @SerializedName("Errors")
    @Expose
    private List<Error> errors = new ArrayList<Error>();

    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getURL() {
        return uRL;
    }

    public void setURL(String uRL) {
        this.uRL = uRL;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

}