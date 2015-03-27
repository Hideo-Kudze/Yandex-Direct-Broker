package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class AdImageAssociationSelectionCriteria {

    @SerializedName("Logins")
    @Expose
    private List<String> logins = new ArrayList<String>();
    @SerializedName("AdImageHashes")
    @Expose
    private List<String> adImageHashes = new ArrayList<String>();
    @SerializedName("StatusAdImageModerate")
    @Expose
    private List<String> statusAdImageModerate = new ArrayList<String>();
    @SerializedName("AdIDS")
    @Expose
    private List<Long> adIDS = new ArrayList<Long>();
    @SerializedName("CampaignIDS")
    @Expose
    private List<Long> campaignIDS = new ArrayList<Long>();
    @SerializedName("Limit")
    @Expose
    private Long limit;
    @SerializedName("Offset")
    @Expose
    private Long offset;



    public List<String> getLogins() {
        return logins;
    }

    public void setLogins(List<String> logins) {
        this.logins = logins;
    }

    public List<String> getAdImageHashes() {
        return adImageHashes;
    }

    public void setAdImageHashes(List<String> adImageHashes) {
        this.adImageHashes = adImageHashes;
    }

    public List<String> getStatusAdImageModerate() {
        return statusAdImageModerate;
    }

    public void setStatusAdImageModerate(List<String> statusAdImageModerate) {
        this.statusAdImageModerate = statusAdImageModerate;
    }

    public List<Long> getAdIDS() {
        return adIDS;
    }

    public void setAdIDS(List<Long> adIDS) {
        this.adIDS = adIDS;
    }

    public List<Long> getCampaignIDS() {
        return campaignIDS;
    }

    public void setCampaignIDS(List<Long> campaignIDS) {
        this.campaignIDS = campaignIDS;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

}