
package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Error {

    @SerializedName("FaultDetail")
    @Expose
    private String faultDetail;
    @SerializedName("FaultString")
    @Expose
    private String faultString;
    @SerializedName("FaultCode")
    @Expose
    private Long faultCode;

    public String getFaultDetail() {
        return faultDetail;
    }

    public void setFaultDetail(String faultDetail) {
        this.faultDetail = faultDetail;
    }

    public String getFaultString() {
        return faultString;
    }

    public void setFaultString(String faultString) {
        this.faultString = faultString;
    }

    public Long getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(Long faultCode) {
        this.faultCode = faultCode;
    }

}
