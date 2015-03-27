package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class GetBannersInfo {

    @SerializedName("CampaignIDS")
    @Expose
    private List<Long> campaignIDS = new ArrayList<Long>();
    @SerializedName("BannerIDS")
    @Expose
    private List<Long> bannerIDS = new ArrayList<Long>();
    @SerializedName("FieldsNames")
    @Expose
    private List<String> fieldsNames = new ArrayList<String>();
    @SerializedName("GetPhrases")
    @Expose
    private String getPhrases;
    @SerializedName("Limit")
    @Expose
    private Long limit;
    @SerializedName("Offset")
    @Expose
    private Long offset;
    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("Filter")
    @Expose
    private BannersFilterInfo filter;

    public List<Long> getCampaignIDS() {
        return campaignIDS;
    }

    public void setCampaignIDS(List<Long> campaignIDS) {
        this.campaignIDS = campaignIDS;
    }

    public List<Long> getBannerIDS() {
        return bannerIDS;
    }

    public void setBannerIDS(List<Long> bannerIDS) {
        this.bannerIDS = bannerIDS;
    }

    public List<String> getFieldsNames() {
        return fieldsNames;
    }

    public void setFieldsNames(List<String> fieldsNames) {
        this.fieldsNames = fieldsNames;
    }

    public String getGetPhrases() {
        return getPhrases;
    }

    public void setGetPhrases(String getPhrases) {
        this.getPhrases = getPhrases;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BannersFilterInfo getFilter() {
        return filter;
    }

    public void setFilter(BannersFilterInfo filter) {
        this.filter = filter;
    }

}