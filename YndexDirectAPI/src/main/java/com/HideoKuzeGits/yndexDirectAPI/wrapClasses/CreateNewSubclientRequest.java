
package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class CreateNewSubclientRequest {

    @SerializedName("Login")
    @Expose
    private String login;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Surname")
    @Expose
    private String surname;
    @SerializedName("Currency")
    @Expose
    private String currency;

    public CreateNewSubclientRequest(String login, String name, String surname) {
        this.login = login;
        this.name = name;
        this.surname = surname;
    }

    public CreateNewSubclientRequest(String login, String name, String surname, String currency) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.currency = currency;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}