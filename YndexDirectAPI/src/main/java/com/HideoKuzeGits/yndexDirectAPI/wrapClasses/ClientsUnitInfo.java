package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ClientsUnitInfo extends AbstractWrap{

    @SerializedName("Login")
    @Expose
    private String login;
    @SerializedName("UnitsRest")
    @Expose
    private Long unitsRest;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getUnitsRest() {
        return unitsRest;
    }

    public void setUnitsRest(Long unitsRest) {
        this.unitsRest = unitsRest;
    }

}