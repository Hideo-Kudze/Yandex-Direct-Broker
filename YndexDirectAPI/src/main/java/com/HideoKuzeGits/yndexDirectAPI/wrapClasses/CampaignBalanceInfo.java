package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class CampaignBalanceInfo extends AbstractWrap{

    @SerializedName("Sum")
    @Expose
    private Long sum;
    @SerializedName("Rest")
    @Expose
    private Double rest;
    @SerializedName("SumAvailableForTransfer")
    @Expose
    private Double sumAvailableForTransfer;
    @SerializedName("CampaignID")
    @Expose
    private Long campaignID;

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public Double getRest() {
        return rest;
    }

    public void setRest(Double rest) {
        this.rest = rest;
    }

    public Double getSumAvailableForTransfer() {
        return sumAvailableForTransfer;
    }

    public void setSumAvailableForTransfer(Double sumAvailableForTransfer) {
        this.sumAvailableForTransfer = sumAvailableForTransfer;
    }

    public Long getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(Long campaignID) {
        this.campaignID = campaignID;
    }

}