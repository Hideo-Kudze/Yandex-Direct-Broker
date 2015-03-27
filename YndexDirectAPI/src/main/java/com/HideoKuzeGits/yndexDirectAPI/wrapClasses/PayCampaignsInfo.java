package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class PayCampaignsInfo {

    @SerializedName("Payments")
    @Expose
    private List<PayCampElement> payments = new ArrayList<PayCampElement>();
    @SerializedName("ContractID")
    @Expose
    private String contractID;
    @SerializedName("PayMethod")
    @Expose
    private String payMethod;


    public PayCampaignsInfo(List<PayCampElement> payments, String contractID, String payMethod) {
        this.payments = payments;
        this.contractID = contractID;
        this.payMethod = payMethod;
    }

    public PayCampaignsInfo(List<PayCampElement> payments, String payMethod) {
        this.payments = payments;
        this.payMethod = payMethod;
    }

    public List<PayCampElement> getPayments() {
        return payments;
    }

    public void setPayments(List<PayCampElement> payments) {
        this.payments = payments;
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

}