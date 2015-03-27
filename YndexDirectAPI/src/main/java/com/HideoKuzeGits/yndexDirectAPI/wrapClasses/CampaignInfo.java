package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class CampaignInfo extends AbstractWrap{

    @SerializedName("Login")
    @Expose
    private String login;
    @SerializedName("CampaignID")
    @Expose
    private Long campaignID;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("FIO")
    @Expose
    private String fIO;
    @SerializedName("StartDate")
    @Expose
    private String startDate;
    @SerializedName("Sum")
    @Expose
    private Double sum;
    @SerializedName("Rest")
    @Expose
    private Double rest;
    @SerializedName("BonusDiscount")
    @Expose
    private Double bonusDiscount;
    @SerializedName("Shows")
    @Expose
    private Long shows;
    @SerializedName("Clicks")
    @Expose
    private Long clicks;
    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("CampaignCurrency")
    @Expose
    private String campaignCurrency;
    @SerializedName("SourceCampaignID")
    @Expose
    private Long sourceCampaignID;
    @SerializedName("Strategy")
    @Expose
    private CampaignStrategy strategy;
    @SerializedName("ContextStrategy")
    @Expose
    private CampaignContextStrategy contextStrategy;
    @SerializedName("AdditionalMetrikaCounters")
    @Expose
    private List<Long> additionalMetrikaCounters = new ArrayList<Long>();
    @SerializedName("ClickTrackingEnabled")
    @Expose
    private String clickTrackingEnabled;
    @SerializedName("SmsNotification")
    @Expose
    private SmsNotification smsNotification;
    @SerializedName("EmailNotification")
    @Expose
    private EmailNotification emailNotification;
    @SerializedName("StatusBehavior")
    @Expose
    private String statusBehavior;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("TimeTarget")
    @Expose
    private TimeTarget timeTarget;
    @SerializedName("StatusContextStop")
    @Expose
    private String statusContextStop;
    @SerializedName("ContextLimit")
    @Expose
    private String contextLimit;
    @SerializedName("ContextLimitSum")
    @Expose
    private Long contextLimitSum;
    @SerializedName("ContextPricePercent")
    @Expose
    private Long contextPricePercent;
    @SerializedName("AutoOptimization")
    @Expose
    private String autoOptimization;
    @SerializedName("StatusMetricaControl")
    @Expose
    private String statusMetricaControl;
    @SerializedName("DisabledDomains")
    @Expose
    private String disabledDomains;
    @SerializedName("DisabledIps")
    @Expose
    private String disabledIps;
    @SerializedName("StatusOpenStat")
    @Expose
    private String statusOpenStat;
    @SerializedName("ConsiderTimeTarget")
    @Expose
    private String considerTimeTarget;
    @SerializedName("ManagerName")
    @Expose
    private String managerName;
    @SerializedName("AgencyName")
    @Expose
    private String agencyName;
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
    @SerializedName("MinusKeywords")
    @Expose
    private List<String> minusKeywords = new ArrayList<String>();
    @SerializedName("AddRelevantPhrases")
    @Expose
    private String addRelevantPhrases;
    @SerializedName("RelevantPhrasesBudgetLimit")
    @Expose
    private Long relevantPhrasesBudgetLimit;
    @SerializedName("SumAvailableForTransfer")
    @Expose
    private Double sumAvailableForTransfer;
    @SerializedName("DayBudget")
    @Expose
    private DayBudget dayBudget;
    @SerializedName("DayBudgetEnabled")
    @Expose
    private String dayBudgetEnabled;

    public CampaignInfo() {
    }

    public CampaignInfo(String login, Long campaignID, String name, String fIO, EmailNotification emailNotification, CampaignStrategy strategy) {
        this.login = login;
        this.campaignID = campaignID;
        this.name = name;
        this.fIO = fIO;
        this.emailNotification = emailNotification;
        this.strategy = strategy;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(Long campaignID) {
        this.campaignID = campaignID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFIO() {
        return fIO;
    }

    public void setFIO(String fIO) {
        this.fIO = fIO;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public CampaignStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(CampaignStrategy strategy) {
        this.strategy = strategy;
    }

    public CampaignContextStrategy getContextStrategy() {
        return contextStrategy;
    }

    public void setContextStrategy(CampaignContextStrategy contextStrategy) {
        this.contextStrategy = contextStrategy;
    }

    public List<Long> getAdditionalMetrikaCounters() {
        return additionalMetrikaCounters;
    }

    public void setAdditionalMetrikaCounters(List<Long> additionalMetrikaCounters) {
        this.additionalMetrikaCounters = additionalMetrikaCounters;
    }

    public String getClickTrackingEnabled() {
        return clickTrackingEnabled;
    }

    public void setClickTrackingEnabled(String clickTrackingEnabled) {
        this.clickTrackingEnabled = clickTrackingEnabled;
    }

    public SmsNotification getSmsNotification() {
        return smsNotification;
    }

    public void setSmsNotification(SmsNotification smsNotification) {
        this.smsNotification = smsNotification;
    }

    public EmailNotification getEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(EmailNotification emailNotification) {
        this.emailNotification = emailNotification;
    }

    public String getStatusBehavior() {
        return statusBehavior;
    }

    public void setStatusBehavior(String statusBehavior) {
        this.statusBehavior = statusBehavior;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TimeTarget getTimeTarget() {
        return timeTarget;
    }

    public void setTimeTarget(TimeTarget timeTarget) {
        this.timeTarget = timeTarget;
    }

    public String getStatusContextStop() {
        return statusContextStop;
    }

    public void setStatusContextStop(String statusContextStop) {
        this.statusContextStop = statusContextStop;
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

    public String getAutoOptimization() {
        return autoOptimization;
    }

    public void setAutoOptimization(String autoOptimization) {
        this.autoOptimization = autoOptimization;
    }

    public String getStatusMetricaControl() {
        return statusMetricaControl;
    }

    public void setStatusMetricaControl(String statusMetricaControl) {
        this.statusMetricaControl = statusMetricaControl;
    }

    public String getDisabledDomains() {
        return disabledDomains;
    }

    public void setDisabledDomains(String disabledDomains) {
        this.disabledDomains = disabledDomains;
    }

    public String getDisabledIps() {
        return disabledIps;
    }

    public void setDisabledIps(String disabledIps) {
        this.disabledIps = disabledIps;
    }

    public String getStatusOpenStat() {
        return statusOpenStat;
    }

    public void setStatusOpenStat(String statusOpenStat) {
        this.statusOpenStat = statusOpenStat;
    }

    public String getConsiderTimeTarget() {
        return considerTimeTarget;
    }

    public void setConsiderTimeTarget(String considerTimeTarget) {
        this.considerTimeTarget = considerTimeTarget;
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

    public List<String> getMinusKeywords() {
        return minusKeywords;
    }

    public void setMinusKeywords(List<String> minusKeywords) {
        this.minusKeywords = minusKeywords;
    }

    public String getAddRelevantPhrases() {
        return addRelevantPhrases;
    }

    public void setAddRelevantPhrases(String addRelevantPhrases) {
        this.addRelevantPhrases = addRelevantPhrases;
    }

    public Long getRelevantPhrasesBudgetLimit() {
        return relevantPhrasesBudgetLimit;
    }

    public void setRelevantPhrasesBudgetLimit(Long relevantPhrasesBudgetLimit) {
        this.relevantPhrasesBudgetLimit = relevantPhrasesBudgetLimit;
    }

    public Double getSumAvailableForTransfer() {
        return sumAvailableForTransfer;
    }

    public void setSumAvailableForTransfer(Double sumAvailableForTransfer) {
        this.sumAvailableForTransfer = sumAvailableForTransfer;
    }

    public DayBudget getDayBudget() {
        return dayBudget;
    }

    public void setDayBudget(DayBudget dayBudget) {
        this.dayBudget = dayBudget;
    }

    public String getDayBudgetEnabled() {
        return dayBudgetEnabled;
    }

    public void setDayBudgetEnabled(String dayBudgetEnabled) {
        this.dayBudgetEnabled = dayBudgetEnabled;
    }

}