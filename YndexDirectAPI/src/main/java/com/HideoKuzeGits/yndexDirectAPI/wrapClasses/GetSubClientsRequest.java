
package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class GetSubClientsRequest {

    @SerializedName("Login")
    @Expose
    private String login;
    @SerializedName("Filter")
    @Expose
    private ClientFilter filter;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public ClientFilter getFilter() {
        return filter;
    }

    public void setFilter(ClientFilter filter) {
        this.filter = filter;
    }

}