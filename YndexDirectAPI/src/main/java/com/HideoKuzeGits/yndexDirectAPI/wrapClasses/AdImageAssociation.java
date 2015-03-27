package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class AdImageAssociation extends AbstractWrap{

    @SerializedName("AdID")
    @Expose
    private Long adID;
    @SerializedName("AdImageHash")
    @Expose
    private String adImageHash;
    @SerializedName("Login")
    @Expose
    private String login;
    @SerializedName("CampaignID")
    @Expose
    private Long campaignID;
    @SerializedName("StatusAdImageModerate")
    @Expose
    private String statusAdImageModerate;
    @SerializedName("ModerateRejectionReasons")
    @Expose
    private List<ModerateRejectionReason> moderateRejectionReasons = new ArrayList<ModerateRejectionReason>();

    public AdImageAssociation() {
    }

    public AdImageAssociation(Long bannerID, String adImageHash) {
        this.adID = bannerID;
        this.adImageHash = adImageHash;
    }

    public Long getAdID() {
        return adID;
    }

    public void setAdID(Long adID) {
        this.adID = adID;
    }

    public String getAdImageHash() {
        return adImageHash;
    }

    public void setAdImageHash(String adImageHash) {
        this.adImageHash = adImageHash;
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

    public String getStatusAdImageModerate() {
        return statusAdImageModerate;
    }

    public void setStatusAdImageModerate(String statusAdImageModerate) {
        this.statusAdImageModerate = statusAdImageModerate;
    }

    public List<ModerateRejectionReason> getModerateRejectionReasons() {
        return moderateRejectionReasons;
    }

    public void setModerateRejectionReasons(List<ModerateRejectionReason> moderateRejectionReasons) {
        this.moderateRejectionReasons = moderateRejectionReasons;
    }

}