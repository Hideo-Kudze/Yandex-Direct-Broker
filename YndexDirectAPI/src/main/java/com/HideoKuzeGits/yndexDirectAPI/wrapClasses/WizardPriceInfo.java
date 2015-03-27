package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.*;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 28.06.14.
 */

public class WizardPriceInfo extends AbstractWrap{

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

    @SerializedName("PhrasesType")
    @Expose
    String phrasesType;

    @SerializedName("UpdatePhrases")
    @Expose
    String updatePhrases;

    @SerializedName("UpdateCategories")
    @Expose
    String updateCategories;

    @SerializedName("MaxPrice")
    @Expose
    Float maxPrice;

    @SerializedName("PriceBase")
    @Expose
    String priceBase;


    @SerializedName("Proc")
    @Expose
    Long proc;

    @SerializedName("ProcBase")
    @Expose
    String procBase;

    @SerializedName("Scope")
    @Expose
    Long scope;

    @SerializedName("DontWaitForPriceUpdate")
    @Expose
    String dontWaitForPriceUpdate;

    @SerializedName("Currency")
    @Expose
    String currency;


    public WizardPriceInfo() {
    }

    public WizardPriceInfo(Long campaignID) {
        this.campaignID = campaignID;
    }



    public String getPhrasesType() {
        return phrasesType;
    }

    public void setPhrasesType(String phrasesType) {
        this.phrasesType = phrasesType;
    }

    public String getUpdatePhrases() {
        return updatePhrases;
    }

    public void setUpdatePhrases(String updatePhrases) {
        this.updatePhrases = updatePhrases;
    }

    public String getUpdateCategories() {
        return updateCategories;
    }

    public void setUpdateCategories(String updateCategories) {
        this.updateCategories = updateCategories;
    }

    public Float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getPriceBase() {
        return priceBase;
    }

    public void setPriceBase(String priceBase) {
        this.priceBase = priceBase;
    }

    public Long getProc() {
        return proc;
    }

    public void setProc(Long proc) {
        this.proc = proc;
    }

    public String getProcBase() {
        return procBase;
    }

    public void setProcBase(String procBase) {
        this.procBase = procBase;
    }

    public Long getScope() {
        return scope;
    }

    public void setScope(Long scope) {
        this.scope = scope;
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
