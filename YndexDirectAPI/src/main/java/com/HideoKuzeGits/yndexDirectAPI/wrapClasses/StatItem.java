package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class StatItem extends AbstractWrap{

    @SerializedName("ClicksSearch")
    @Expose
    private Long clicksSearch;
    @SerializedName("SumSearch")
    @Expose
    private Double sumSearch;
    @SerializedName("SessionDepthSearch")
    @Expose
    private Object sessionDepthSearch;
    @SerializedName("SessionDepthContext")
    @Expose
    private Object sessionDepthContext;
    @SerializedName("ClicksContext")
    @Expose
    private Long clicksContext;
    @SerializedName("GoalCostContext")
    @Expose
    private Object goalCostContext;
    @SerializedName("GoalCostSearch")
    @Expose
    private Object goalCostSearch;
    @SerializedName("GoalConversionSearch")
    @Expose
    private Object goalConversionSearch;
    @SerializedName("SumContext")
    @Expose
    private Double sumContext;
    @SerializedName("GoalConversionContext")
    @Expose
    private Object goalConversionContext;
    @SerializedName("StatDate")
    @Expose
    private String statDate;
    @SerializedName("ShowsSearch")
    @Expose
    private Long showsSearch;
    @SerializedName("CampaignID")
    @Expose
    private Long campaignID;
    @SerializedName("ShowsContext")
    @Expose
    private Long showsContext;

    public Long getClicksSearch() {
        return clicksSearch;
    }

    public void setClicksSearch(Long clicksSearch) {
        this.clicksSearch = clicksSearch;
    }

    public Double getSumSearch() {
        return sumSearch;
    }

    public void setSumSearch(Double sumSearch) {
        this.sumSearch = sumSearch;
    }

    public Object getSessionDepthSearch() {
        return sessionDepthSearch;
    }

    public void setSessionDepthSearch(Object sessionDepthSearch) {
        this.sessionDepthSearch = sessionDepthSearch;
    }

    public Object getSessionDepthContext() {
        return sessionDepthContext;
    }

    public void setSessionDepthContext(Object sessionDepthContext) {
        this.sessionDepthContext = sessionDepthContext;
    }

    public Long getClicksContext() {
        return clicksContext;
    }

    public void setClicksContext(Long clicksContext) {
        this.clicksContext = clicksContext;
    }

    public Object getGoalCostContext() {
        return goalCostContext;
    }

    public void setGoalCostContext(Object goalCostContext) {
        this.goalCostContext = goalCostContext;
    }

    public Object getGoalCostSearch() {
        return goalCostSearch;
    }

    public void setGoalCostSearch(Object goalCostSearch) {
        this.goalCostSearch = goalCostSearch;
    }

    public Object getGoalConversionSearch() {
        return goalConversionSearch;
    }

    public void setGoalConversionSearch(Object goalConversionSearch) {
        this.goalConversionSearch = goalConversionSearch;
    }

    public Double getSumContext() {
        return sumContext;
    }

    public void setSumContext(Double sumContext) {
        this.sumContext = sumContext;
    }

    public Object getGoalConversionContext() {
        return goalConversionContext;
    }

    public void setGoalConversionContext(Object goalConversionContext) {
        this.goalConversionContext = goalConversionContext;
    }

    public String getStatDate() {
        return statDate;
    }

    public void setStatDate(String statDate) {
        this.statDate = statDate;
    }

    public Long getShowsSearch() {
        return showsSearch;
    }

    public void setShowsSearch(Long showsSearch) {
        this.showsSearch = showsSearch;
    }

    public Long getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(Long campaignID) {
        this.campaignID = campaignID;
    }

    public Long getShowsContext() {
        return showsContext;
    }

    public void setShowsContext(Long showsContext) {
        this.showsContext = showsContext;
    }

}