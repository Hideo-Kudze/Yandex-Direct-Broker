package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ShortCampaignInfo extends AbstractWrap{

    @SerializedName("CampaignID")
    @Expose
    private Long campaignID;
    @SerializedName("Login")
    @Expose
    private String login;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("StartDate")
    @Expose
    private String startDate;
    @SerializedName("StrategyName")
    @Expose
    private String strategyName;
    @SerializedName("ContextStrategyName")
    @Expose
    private String contextStrategyName;
    @SerializedName("Sum")
    @Expose
    private Double sum;
    @SerializedName("Rest")
    @Expose
    private Double rest;
    @SerializedName("BonusDiscount")
    @Expose
    private Double bonusDiscount;
    @SerializedName("SumAvailableForTransfer")
    @Expose
    private Double sumAvailableForTransfer;
    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("Shows")
    @Expose
    private Long shows;
    @SerializedName("Clicks")
    @Expose
    private Long clicks;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("StatusShow")
    @Expose
    private String statusShow;
    @SerializedName("StatusArchive")
    @Expose
    private String statusArchive;
    @SerializedName("StatusActivating")
    @Expose
    private String statusActivating;
    @SerializedName("StatusModerate")
    @Expose
    private String statusModerate;
    @SerializedName("IsActive")
    @Expose
    private String isActive;
    @SerializedName("ManagerName")
    @Expose
    private String managerName;
    @SerializedName("AgencyName")
    @Expose
    private String agencyName;
    @SerializedName("CampaignCurrency")
    @Expose
    private String campaignCurrency;
    @SerializedName("SourceCampaignID")
    @Expose
    private Long sourceCampaignID;
    @SerializedName("DayBudgetEnabled")
    @Expose
    private String dayBudgetEnabled;

    public Long getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(Long campaignID) {
        this.campaignID = campaignID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    public String getContextStrategyName() {
        return contextStrategyName;
    }

    public void setContextStrategyName(String contextStrategyName) {
        this.contextStrategyName = contextStrategyName;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Double getRest() {
        return rest;
    }

    public void setRest(Double rest) {
        this.rest = rest;
    }

    public Double getBonusDiscount() {
        return bonusDiscount;
    }

    public void setBonusDiscount(Double bonusDiscount) {
        this.bonusDiscount = bonusDiscount;
    }

    public Double getSumAvailableForTransfer() {
        return sumAvailableForTransfer;
    }

    public void setSumAvailableForTransfer(Double sumAvailableForTransfer) {
        this.sumAvailableForTransfer = sumAvailableForTransfer;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getShows() {
        return shows;
    }

    public void setShows(Long shows) {
        this.shows = shows;
    }

    public Long getClicks() {
        return clicks;
    }

    public void setClicks(Long clicks) {
        this.clicks = clicks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusShow() {
        return statusShow;
    }

    public void setStatusShow(String statusShow) {
        this.statusShow = statusShow;
    }

    public String getStatusArchive() {
        return statusArchive;
    }

    public void setStatusArchive(String statusArchive) {
        this.statusArchive = statusArchive;
    }

    public String getStatusActivating() {
        return statusActivating;
    }

    public void setStatusActivating(String statusActivating) {
        this.statusActivating = statusActivating;
    }

    public String getStatusModerate() {
        return statusModerate;
    }

    public void setStatusModerate(String statusModerate) {
        this.statusModerate = statusModerate;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getCampaignCurrency() {
        return campaignCurrency;
    }

    public void setCampaignCurrency(String campaignCurrency) {
        this.campaignCurrency = campaignCurrency;
    }

    public Long getSourceCampaignID() {
        return sourceCampaignID;
    }

    public void setSourceCampaignID(Long sourceCampaignID) {
        this.sourceCampaignID = sourceCampaignID;
    }

    public String getDayBudgetEnabled() {
        return dayBudgetEnabled;
    }

    public void setDayBudgetEnabled(String dayBudgetEnabled) {
        this.dayBudgetEnabled = dayBudgetEnabled;
    }

}