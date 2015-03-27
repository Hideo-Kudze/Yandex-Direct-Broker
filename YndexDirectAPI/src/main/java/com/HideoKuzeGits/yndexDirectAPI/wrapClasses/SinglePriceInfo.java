package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.*;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 28.06.14.
 */

public class SinglePriceInfo extends AbstractWrap{

    @SerializedName("Mode")
    @Expose
    String mode;

    @SerializedName("CampaignID")
    @Expose
    Long campaignID;

    @SerializedName("BannerIDS")
    @Expose
    Long[] bannerIDS;

    @SerializedName("PhraseIDS")
    @Expose
    Long[] phraseIDS;

    @SerializedName("BannersType")
    @Expose
    String bannersType;

    @SerializedName("SinglePrice")
    @Expose
    Double singlePrice;

    @SerializedName("Price")
    @Expose
    Double price;

    @SerializedName("ContextPrice")
    @Expose
    Double contextPrice;

    @SerializedName("DontWaitForPriceUpdate")
    @Expose
    String dontWaitForPriceUpdate;

    @SerializedName("Currency")
    @Expose
    String currency;

    public SinglePriceInfo() {
    }

    public SinglePriceInfo(Long campaignID, Double singlePrice) {
        this.campaignID = campaignID;
        this.singlePrice = singlePrice;
    }

    public SinglePriceInfo(Long campaignID, Double price, Double contextPrice) {
        this.campaignID = campaignID;
        this.price = price;
        this.contextPrice = contextPrice;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Long getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(Long campaignID) {
        this.campaignID = campaignID;
    }

    public Long[] getBannerIDS() {
        return bannerIDS;
    }

    public void setBannerIDS(Long[] bannerIDS) {
        this.bannerIDS = bannerIDS;
    }

    public Long[] getPhraseIDS() {
        return phraseIDS;
    }

    public void setPhraseIDS(Long[] phraseIDS) {
        this.phraseIDS = phraseIDS;
    }

    public String getBannersType() {
        return bannersType;
    }

    public void setBannersType(String bannersType) {
        this.bannersType = bannersType;
    }

    public Double getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(Double singlePrice) {
        this.singlePrice = singlePrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getContextPrice() {
        return contextPrice;
    }

    public void setContextPrice(Double contextPrice) {
        this.contextPrice = contextPrice;
    }

    public String getDontWaitForPriceUpdate() {
        return dontWaitForPriceUpdate;
    }

    public void setDontWaitForPriceUpdate(String dontWaitForPriceUpdate) {
        this.dontWaitForPriceUpdate = dontWaitForPriceUpdate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
