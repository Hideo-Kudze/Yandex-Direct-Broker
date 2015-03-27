package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class CampaignStrategy {

    @SerializedName("StrategyName")
    @Expose
    private String strategyName;
    @SerializedName("MaxPrice")
    @Expose
    private Double maxPrice;
    @SerializedName("AveragePrice")
    @Expose
    private Double averagePrice;
    @SerializedName("WeeklySumLimit")
    @Expose
    private Double weeklySumLimit;
    @SerializedName("AverageCPA")
    @Expose
    private Double averageCPA;
    @SerializedName("ClicksPerWeek")
    @Expose
    private Long clicksPerWeek;
    @SerializedName("GoalID")
    @Expose
    private Long goalID;

    public CampaignStrategy() {
    }

    public CampaignStrategy(String strategyName) {
        this.strategyName = strategyName;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
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

    public Double getWeeklySumLimit() {
        return weeklySumLimit;
    }

    public void setWeeklySumLimit(Double weeklySumLimit) {
        this.weeklySumLimit = weeklySumLimit;
    }

    public Double getAverageCPA() {
        return averageCPA;
    }

    public void setAverageCPA(Double averageCPA) {
        this.averageCPA = averageCPA;
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