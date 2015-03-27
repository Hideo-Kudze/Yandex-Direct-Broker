package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class BannerInfo {

    @SerializedName("BannerID")
    @Expose
    private Long bannerID;
    @SerializedName("CampaignID")
    @Expose
    private Long campaignID;
    @SerializedName("AdGroupID")
    @Expose
    private Long adGroupID;
    @SerializedName("AdGroupName")
    @Expose
    private String adGroupName;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Text")
    @Expose
    private String text;
    @SerializedName("Href")
    @Expose
    private String href;
    @SerializedName("Domain")
    @Expose
    private String domain;
    @SerializedName("Geo")
    @Expose
    private String geo;
    @SerializedName("ContactInfo")
    @Expose
    private ContactInfo contactInfo;
    @SerializedName("Phrases")
    @Expose
    private List<BannerPhraseInfo> phrases = new ArrayList<BannerPhraseInfo>();
    @SerializedName("StatusActivating")
    @Expose
    private String statusActivating;
    @SerializedName("StatusArchive")
    @Expose
    private String statusArchive;
    @SerializedName("StatusBannerModerate")
    @Expose
    private String statusBannerModerate;
    @SerializedName("StatusPhrasesModerate")
    @Expose
    private String statusPhrasesModerate;
    @SerializedName("StatusPhoneModerate")
    @Expose
    private String statusPhoneModerate;
    @SerializedName("StatusAdImageModerate")
    @Expose
    private String statusAdImageModerate;
    @SerializedName("StatusShow")
    @Expose
    private String statusShow;
    @SerializedName("IsActive")
    @Expose
    private String isActive;
    @SerializedName("StatusSitelinksModerate")
    @Expose
    private String statusSitelinksModerate;
    @SerializedName("Sitelinks")
    @Expose
    private List<Sitelink> sitelinks = new ArrayList<Sitelink>();
    @SerializedName("AdWarnings")
    @Expose
    private List<String> adWarnings = new ArrayList<String>();
    @SerializedName("FixedOnModeration")
    @Expose
    private String fixedOnModeration;
    @SerializedName("ModerateRejectionReasons")
    @Expose
    private List<ModerateRejectionReason> moderateRejectionReasons = new ArrayList<ModerateRejectionReason>();
    @SerializedName("MinusKeywords")
    @Expose
    private List<String> minusKeywords = new ArrayList<String>();
    @SerializedName("AgeLabel")
    @Expose
    private String ageLabel;
    @SerializedName("AdImageHash")
    @Expose
    private String adImageHash;

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

    public String getAdGroupName() {
        return adGroupName;
    }

    public void setAdGroupName(String adGroupName) {
        this.adGroupName = adGroupName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<BannerPhraseInfo> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<BannerPhraseInfo> phrases) {
        this.phrases = phrases;
    }

    public String getStatusActivating() {
        return statusActivating;
    }

    public void setStatusActivating(String statusActivating) {
        this.statusActivating = statusActivating;
    }

    public String getStatusArchive() {
        return statusArchive;
    }

    public void setStatusArchive(String statusArchive) {
        this.statusArchive = statusArchive;
    }

    public String getStatusBannerModerate() {
        return statusBannerModerate;
    }

    public void setStatusBannerModerate(String statusBannerModerate) {
        this.statusBannerModerate = statusBannerModerate;
    }

    public String getStatusPhrasesModerate() {
        return statusPhrasesModerate;
    }

    public void setStatusPhrasesModerate(String statusPhrasesModerate) {
        this.statusPhrasesModerate = statusPhrasesModerate;
    }

    public String getStatusPhoneModerate() {
        return statusPhoneModerate;
    }

    public void setStatusPhoneModerate(String statusPhoneModerate) {
        this.statusPhoneModerate = statusPhoneModerate;
    }

    public String getStatusAdImageModerate() {
        return statusAdImageModerate;
    }

    public void setStatusAdImageModerate(String statusAdImageModerate) {
        this.statusAdImageModerate = statusAdImageModerate;
    }

    public String getStatusShow() {
        return statusShow;
    }

    public void setStatusShow(String statusShow) {
        this.statusShow = statusShow;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getStatusSitelinksModerate() {
        return statusSitelinksModerate;
    }

    public void setStatusSitelinksModerate(String statusSitelinksModerate) {
        this.statusSitelinksModerate = statusSitelinksModerate;
    }

    public List<Sitelink> getSitelinks() {
        return sitelinks;
    }

    public void setSitelinks(List<Sitelink> sitelinks) {
        this.sitelinks = sitelinks;
    }

    public List<String> getAdWarnings() {
        return adWarnings;
    }

    public void setAdWarnings(List<String> adWarnings) {
        this.adWarnings = adWarnings;
    }

    public String getFixedOnModeration() {
        return fixedOnModeration;
    }

    public void setFixedOnModeration(String fixedOnModeration) {
        this.fixedOnModeration = fixedOnModeration;
    }

    public List<ModerateRejectionReason> getModerateRejectionReasons() {
        return moderateRejectionReasons;
    }

    public void setModerateRejectionReasons(List<ModerateRejectionReason> moderateRejectionReasons) {
        this.moderateRejectionReasons = moderateRejectionReasons;
    }

    public List<String> getMinusKeywords() {
        return minusKeywords;
    }

    public void setMinusKeywords(List<String> minusKeywords) {
        this.minusKeywords = minusKeywords;
    }

    public String getAgeLabel() {
        return ageLabel;
    }

    public void setAgeLabel(String ageLabel) {
        this.ageLabel = ageLabel;
    }

    public String getAdImageHash() {
        return adImageHash;
    }

    public void setAdImageHash(String adImageHash) {
        this.adImageHash = adImageHash;
    }

}