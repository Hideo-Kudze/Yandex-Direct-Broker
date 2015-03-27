package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 08.07.14.
 */
public class GetEventsLogFilter extends AbstractWrap{

    @SerializedName("CampaignIDS")
    @Expose
    private List<Long> campaignIDS = new ArrayList<Long>();

    @SerializedName("BannerIDS")
    @Expose
    private List<Long> bannerIDS = new ArrayList<Long>();

    @SerializedName("PhraseIDS")
    @Expose
    private List<Long> phraseIDS = new ArrayList<Long>();

    @SerializedName("AccountIDS")
    @Expose
    private List<Long> accountIDS = new ArrayList<Long>();

    @SerializedName("EventType")
    @Expose
    private List<String> eventType = new ArrayList<String>();


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

    public List<Long> getPhraseIDS() {
        return phraseIDS;
    }

    public void setPhraseIDS(List<Long> phraseIDS) {
        this.phraseIDS = phraseIDS;
    }

    public List<Long> getAccountIDS() {
        return accountIDS;
    }

    public void setAccountIDS(List<Long> accountIDS) {
        this.accountIDS = accountIDS;
    }

    public List<String> getEventType() {
        return eventType;
    }

    public void setEventType(List<String> eventType) {
        this.eventType = eventType;
    }
}
