package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class CampaignContextStrategy {

    @SerializedName("StrategyName")
    @Expose
    private String strategyName;
    @SerializedName("ContextLimit")
    @Expose
    private String contextLimit;
    @SerializedName("ContextLimitSum")
    @Expose
    private Long contextLimitSum;
    @SerializedName("ContextPricePercent")
    @Expose
    private Long contextPricePercent;
    @SerializedName("MaxPrice")
    @Expose
    private Double maxPrice;
    @SerializedName("AveragePrice")
    @Expose
    private Double averagePrice;
    @SerializedName("AverageCPA")
    @Expose
    private Double averageCPA;
    @SerializedName("WeeklySumLimit")
    @Expose
    private Double weeklySumLimit;
    @SerializedName("ClicksPerWeek")
    @Expose
    private Long clicksPerWeek;
    @SerializedName("GoalID")
    @Expose
    private Long goalID;

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    public String getContextLimit() {
        return contextLimit;
    }

    public void setContextLimit(String contextLimit) {
        this.contextLimit = contextLimit;
    }

    public Long getContextLimitSum() {
        return contextLimitSum;
    }

    public void setContextLimitSum(Long contextLimitSum) {
        this.contextLimitSum = contextLimitSum;
    }

    public Long getContextPricePercent() {
        return contextPricePercent;
    }

    public void setContextPricePercent(Long contextPricePercent) {
        this.contextPricePercent = contextPricePercent;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Double getAverageCPA() {
        return averageCPA;
    }

    public void setAverageCPA(Double averageCPA) {
        this.averageCPA = averageCPA;
    }

    public Double getWeeklySumLimit() {
        return weeklySumLimit;
    }

    public void setWeeklySumLimit(Double weeklySumLimit) {
        this.weeklySumLimit = weeklySumLimit;
    }

    public Long getClicksPerWeek() {
        return clicksPerWeek;
    }

    public void setClicksPerWeek(Long clicksPerWeek) {
        this.clicksPerWeek = clicksPerWeek;
    }

    public Long getGoalID() {
        return goalID;
    }

    public void setGoalID(Long goalID) {
        this.goalID = goalID;
    }

}