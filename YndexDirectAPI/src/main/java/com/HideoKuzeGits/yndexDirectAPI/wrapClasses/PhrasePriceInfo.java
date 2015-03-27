package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class PhrasePriceInfo {

    @SerializedName("CampaignID")
    @Expose
    private Long campaignID;
    @SerializedName("PhraseID")
    @Expose
    private Long phraseID;
    @SerializedName("Price")
    @Expose
    private Double price;
    @SerializedName("ContextPrice")
    @Expose
    private Double contextPrice;
    @SerializedName("AutoBroker")
    @Expose
    private String autoBroker;
    @SerializedName("AutoBudgetPriority")
    @Expose
    private String autoBudgetPriority;
    @SerializedName("Currency")
    @Expose
    private String currency;

    public Long getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(Long campaignID) {
        this.campaignID = campaignID;
    }

    public Long getPhraseID() {
        return phraseID;
    }

    public void setPhraseID(Long phraseID) {
        this.phraseID = phraseID;
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

    public String getAutoBroker() {
        return autoBroker;
    }

    public void setAutoBroker(String autoBroker) {
        this.autoBroker = autoBroker;
    }

    public String getAutoBudgetPriority() {
        return autoBudgetPriority;
    }

    public void setAutoBudgetPriority(String autoBudgetPriority) {
        this.autoBudgetPriority = autoBudgetPriority;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}