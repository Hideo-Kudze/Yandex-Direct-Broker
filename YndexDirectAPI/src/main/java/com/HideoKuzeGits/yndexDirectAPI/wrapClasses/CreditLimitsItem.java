package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class CreditLimitsItem {

    @SerializedName("ContractID")
    @Expose
    private String contractID;
    @SerializedName("Limit")
    @Expose
    private Double limit;
    @SerializedName("LimitSpent")
    @Expose
    private Double limitSpent;

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public Double getLimitSpent() {
        return limitSpent;
    }

    public void setLimitSpent(Double limitSpent) {
        this.limitSpent = limitSpent;
    }

}