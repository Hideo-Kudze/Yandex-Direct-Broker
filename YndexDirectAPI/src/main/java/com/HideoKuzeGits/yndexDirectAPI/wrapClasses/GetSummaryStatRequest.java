package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 06.07.14.
 */
public class GetSummaryStatRequest extends AbstractWrap {

    @SerializedName("CampaignIDS")
    @Expose
    public Long[] campaignIDS;

    @SerializedName("StartDate")
    @Expose
    private String startDate;

    @SerializedName("EndDate")
    @Expose
    private String endDate;

    @SerializedName("Currency")
    @Expose
    private String currency;


    @SerializedName("includeVAT")
    @Expose
    private String includeVAT;


    @SerializedName("IncludeDiscount")
    @Expose
    private String includeDiscount;


    public Long[] getCampaignIDS() {
        return campaignIDS;
    }

    public GetSummaryStatRequest(Long[] campaignIDS, String startDate, String endDate) {
        this.campaignIDS = campaignIDS;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setCampaignIDS(Long[] campaignIDS) {
        this.campaignIDS = campaignIDS;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getIncludeVAT() {
        return includeVAT;
    }

    public void setIncludeVAT(String includeVAT) {
        this.includeVAT = includeVAT;
    }

    public String getIncludeDiscount() {
        return includeDiscount;
    }

    public void setIncludeDiscount(String includeDiscount) {
        this.includeDiscount = includeDiscount;
    }
}
