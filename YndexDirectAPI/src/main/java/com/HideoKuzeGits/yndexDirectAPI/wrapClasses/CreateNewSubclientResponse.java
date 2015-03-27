package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class CreateNewSubclientResponse {

    @SerializedName("Login")
    @Expose
    private String login;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("FIO")
    @Expose
    private String fIO;
    @SerializedName("Email")
    @Expose
    private String email;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFIO() {
        return fIO;
    }

    public void setFIO(String fIO) {
        this.fIO = fIO;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}