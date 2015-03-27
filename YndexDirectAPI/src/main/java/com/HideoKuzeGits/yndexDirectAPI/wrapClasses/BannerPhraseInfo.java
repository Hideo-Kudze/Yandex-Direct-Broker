
package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class BannerPhraseInfo extends AbstractWrap{

    public BannerPhraseInfo() {
    }

    public BannerPhraseInfo(Long bannerID, String phrase, Double price) {
        this.bannerID = bannerID;
        this.price = price;
        this.phrase = phrase;
    }

    @SerializedName("BannerID")
    @Expose
    private Long bannerID;
    @SerializedName("CampaignID")
    @Expose
    private Long campaignID;
    @SerializedName("AdGroupID")
    @Expose
    private Long adGroupID;
    @SerializedName("PhraseID")
    @Expose
    private Long phraseID;
    @SerializedName("Phrase")
    @Expose
    private String phrase;
    @SerializedName("IsRubric")
    @Expose
    private String isRubric;
    @SerializedName("Price")
    @Expose
    private Double price;
    @SerializedName("ContextPrice")
    @Expose
    private Double contextPrice;
    @SerializedName("AutoBroker")
    @Expose
    private String autoBroker;
    @SerializedName("UserParams")
    @Expose
    private UserParams userParams;
    @SerializedName("StatusPhraseModerate")
    @Expose
    private String statusPhraseModerate;
    @SerializedName("AutoBudgetPriority")
    @Expose
    private String autoBudgetPriority;
    @SerializedName("Clicks")
    @Expose
    private Long clicks;
    @SerializedName("Shows")
    @Expose
    private Long shows;
    @SerializedName("ContextClicks")
    @Expose
    private Long contextClicks;
    @SerializedName("ContextShows")
    @Expose
    private Long contextShows;
    @SerializedName("Min")
    @Expose
    private Double min;
    @SerializedName("Max")
    @Expose
    private Double max;
    @SerializedName("PremiumMin")
    @Expose
    private Double premiumMin;
    @SerializedName("PremiumMax")
    @Expose
    private Double premiumMax;
    @SerializedName("LowCTRWarning")
    @Expose
    private String lowCTRWarning;
    @SerializedName("LowCTR")
    @Expose
    private String lowCTR;
    @SerializedName("ContextLowCTR")
    @Expose
    private String contextLowCTR;
    @SerializedName("Coverage")
    @Expose
    private List <Coverage> coverage = new ArrayList<Coverage>();
    @SerializedName("ContextCoverage")
    @Expose
    private List<ContextCoverage> contextCoverage = new ArrayList<ContextCoverage>();
    @SerializedName("Prices")
    @Expose
    private List<Double> prices = new ArrayList<Double>();
    @SerializedName("CurrentOnSearch")
    @Expose
    private Double currentOnSearch;
    @SerializedName("MinPrice")
    @Expose
    private Double minPrice;
    @SerializedName("StatusPaused")
    @Expose
    private String statusPaused;
    @SerializedName("Currency")
    @Expose
    private String currency;

    public Long getBannerID() {
        return bannerID;
    }

    public void setBannerID(Long bannerID) {
        this.bannerID = bannerID;
    }

    public Long getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(Long campaignID) {
        this.campaignID = campaignID;
    }

    public Long getAdGroupID() {
        return adGroupID;
    }

    public void setAdGroupID(Long adGroupID) {
        this.adGroupID = adGroupID;
    }

    public Long getPhraseID() {
        return phraseID;
    }

    public void setPhraseID(Long phraseID) {
        this.phraseID = phraseID;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getIsRubric() {
        return isRubric;
    }

    public void setIsRubric(String isRubric) {
        this.isRubric = isRubric;
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

    public UserParams getUserParams() {
        return userParams;
    }

    public void setUserParams(UserParams userParams) {
        this.userParams = userParams;
    }

    public String getStatusPhraseModerate() {
        return statusPhraseModerate;
    }

    public void setStatusPhraseModerate(String statusPhraseModerate) {
        this.statusPhraseModerate = statusPhraseModerate;
    }

    public String getAutoBudgetPriority() {
        return autoBudgetPriority;
    }

    public void setAutoBudgetPriority(String autoBudgetPriority) {
        this.autoBudgetPriority = autoBudgetPriority;
    }

    public Long getClicks() {
        return clicks;
    }

    public void setClicks(Long clicks) {
        this.clicks = clicks;
    }

    public Long getShows() {
        return shows;
    }

    public void setShows(Long shows) {
        this.shows = shows;
    }

    public Long getContextClicks() {
        return contextClicks;
    }

    public void setContextClicks(Long contextClicks) {
        this.contextClicks = contextClicks;
    }

    public Long getContextShows() {
        return contextShows;
    }

    public void setContextShows(Long contextShows) {
        this.contextShows = contextShows;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getPremiumMin() {
        return premiumMin;
    }

    public void setPremiumMin(Double premiumMin) {
        this.premiumMin = premiumMin;
    }

    public Double getPremiumMax() {
        return premiumMax;
    }

    public void setPremiumMax(Double premiumMax) {
        this.premiumMax = premiumMax;
    }

    public String getLowCTRWarning() {
        return lowCTRWarning;
    }

    public void setLowCTRWarning(String lowCTRWarning) {
        this.lowCTRWarning = lowCTRWarning;
    }

    public String getLowCTR() {
        return lowCTR;
    }

    public void setLowCTR(String lowCTR) {
        this.lowCTR = lowCTR;
    }

    public String getContextLowCTR() {
        return contextLowCTR;
    }

    public void setContextLowCTR(String contextLowCTR) {
        this.contextLowCTR = contextLowCTR;
    }

    public List<Coverage> getCoverage() {
        return coverage;
    }

    public void setCoverage(List<Coverage> coverage) {
        this.coverage = coverage;
    }

    public List<ContextCoverage> getContextCoverage() {
        return contextCoverage;
    }

    public void setContextCoverage(List<ContextCoverage> contextCoverage) {
        this.contextCoverage = contextCoverage;
    }

    public List<Double> getPrices() {
        return prices;
    }

    public void setPrices(List<Double> prices) {
        this.prices = prices;
    }

    public Double getCurrentOnSearch() {
        return currentOnSearch;
    }

    public void setCurrentOnSearch(Double currentOnSearch) {
        this.currentOnSearch = currentOnSearch;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public String getStatusPaused() {
        return statusPaused;
    }

    public void setStatusPaused(String statusPaused) {
        this.statusPaused = statusPaused;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


}
