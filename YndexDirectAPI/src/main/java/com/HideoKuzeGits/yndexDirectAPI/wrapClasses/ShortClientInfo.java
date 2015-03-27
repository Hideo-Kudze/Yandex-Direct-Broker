package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ShortClientInfo extends AbstractWrap{

    @SerializedName("Login")
    @Expose
    private String login;
    @SerializedName("FIO")
    @Expose
    private String fIO;
    @SerializedName("Role")
    @Expose
    private String role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFIO() {
        return fIO;
    }

    public void setFIO(String fIO) {
        this.fIO = fIO;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}