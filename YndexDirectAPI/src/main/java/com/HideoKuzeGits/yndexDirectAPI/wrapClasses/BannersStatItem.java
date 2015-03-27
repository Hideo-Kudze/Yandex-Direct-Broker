package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class BannersStatItem {

    @SerializedName("StatDate")
    @Expose
    private String statDate;
    @SerializedName("BannerID")
    @Expose
    private Long bannerID;
    @SerializedName("PhraseID")
    @Expose
    private Long phraseID;
    @SerializedName("RubricID")
    @Expose
    private Long rubricID;
    @SerializedName("RetargetingID")
    @Expose
    private Long retargetingID;
    @SerializedName("Phrase")
    @Expose
    private String phrase;
    @SerializedName("Sum")
    @Expose
    private Double sum;
    @SerializedName("SumSearch")
    @Expose
    private Double sumSearch;
    @SerializedName("SumContext")
    @Expose
    private Double sumContext;
    @SerializedName("Clicks")
    @Expose
    private Long clicks;
    @SerializedName("ClicksSearch")
    @Expose
    private Long clicksSearch;
    @SerializedName("ClicksContext")
    @Expose
    private Long clicksContext;
    @SerializedName("Shows")
    @Expose
    private Long shows;
    @SerializedName("ShowsSearch")
    @Expose
    private Long showsSearch;
    @SerializedName("ShowsContext")
    @Expose
    private Long showsContext;
    @SerializedName("StatType")
    @Expose
    private String statType;

    public String getStatDate() {
        return statDate;
    }

    public void setStatDate(String statDate) {
        this.statDate = statDate;
    }

    public Long getBannerID() {
        return bannerID;
    }

    public void setBannerID(Long bannerID) {
        this.bannerID = bannerID;
    }

    public Long getPhraseID() {
        return phraseID;
    }

    public void setPhraseID(Long phraseID) {
        this.phraseID = phraseID;
    }

    public Long getRubricID() {
        return rubricID;
    }

    public void setRubricID(Long rubricID) {
        this.rubricID = rubricID;
    }

    public Long getRetargetingID() {
        return retargetingID;
    }

    public void setRetargetingID(Long retargetingID) {
        this.retargetingID = retargetingID;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Double getSumSearch() {
        return sumSearch;
    }

    public void setSumSearch(Double sumSearch) {
        this.sumSearch = sumSearch;
    }

    public Double getSumContext() {
        return sumContext;
    }

    public void setSumContext(Double sumContext) {
        this.sumContext = sumContext;
    }

    public Long getClicks() {
        return clicks;
    }

    public void setClicks(Long clicks) {
        this.clicks = clicks;
    }

    public Long getClicksSearch() {
        return clicksSearch;
    }

    public void setClicksSearch(Long clicksSearch) {
        this.clicksSearch = clicksSearch;
    }

    public Long getClicksContext() {
        return clicksContext;
    }

    public void setClicksContext(Long clicksContext) {
        this.clicksContext = clicksContext;
    }

    public Long getShows() {
        return shows;
    }

    public void setShows(Long shows) {
        this.shows = shows;
    }

    public Long getShowsSearch() {
        return showsSearch;
    }

    public void setShowsSearch(Long showsSearch) {
        this.showsSearch = showsSearch;
    }

    public Long getShowsContext() {
        return showsContext;
    }

    public void setShowsContext(Long showsContext) {
        this.showsContext = showsContext;
    }

    public String getStatType() {
        return statType;
    }

    public void setStatType(String statType) {
        this.statType = statType;
    }

}