package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class PayCampElement {

    public PayCampElement(Long campaignID, Double sum, String currency) {
        this.campaignID = campaignID;
        this.sum = sum;
        this.currency = currency;
    }

    public PayCampElement(Long campaignID, Double sum) {
        this.campaignID = campaignID;
        this.sum = sum;
    }

    @SerializedName("CampaignID")
    @Expose
    private Long campaignID;
    @SerializedName("Sum")
    @Expose
    private Double sum;
    @SerializedName("Currency")
    @Expose
    private String currency;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(Long campaignID) {
        this.campaignID = campaignID;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

}