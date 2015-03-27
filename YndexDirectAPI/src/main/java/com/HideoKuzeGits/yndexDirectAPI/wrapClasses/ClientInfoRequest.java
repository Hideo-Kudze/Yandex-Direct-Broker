package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ClientInfoRequest {

    public ClientInfoRequest() {
    }

    public ClientInfoRequest(ClientFilter filter) {
        this.filter = filter;
    }

    @SerializedName("Filter")
    @Expose
    private ClientFilter filter;

    public ClientFilter getFilter() {
        return filter;
    }

    public void setFilter(ClientFilter filter) {
        this.filter = filter;
    }

}