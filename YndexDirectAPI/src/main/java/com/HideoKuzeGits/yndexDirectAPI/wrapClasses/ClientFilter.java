package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ClientFilter {

    public ClientFilter() {
    }

    public ClientFilter(String statusArch) {
        this.statusArch = statusArch;
    }

    @SerializedName("StatusArch")
    @Expose
    private String statusArch;

    public String getStatusArch() {
        return statusArch;
    }

    public void setStatusArch(String statusArch) {
        this.statusArch = statusArch;
    }

}