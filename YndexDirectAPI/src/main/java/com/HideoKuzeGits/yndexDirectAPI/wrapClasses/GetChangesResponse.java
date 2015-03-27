package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 08.07.14.
 */
public class GetChangesResponse extends AbstractWrap{

    @SerializedName("Campaigns")
    @Expose
    private GetChangesIntData campaigns;

    @SerializedName("Banners")
    @Expose
    private GetChangesIntData banners;

    @SerializedName("CampaignsStatChange")
    @Expose
    private List<CampaignStatChangeItem> campaignsStatChange = new ArrayList<CampaignStatChangeItem>();

    @SerializedName("Timestamp")
    @Expose
    private String timestamp;

    @SerializedName("RubricsChanged")
    @Expose
    private String rubricsChanged;

    @SerializedName("TimeZonesChanged")
    @Expose
    private String timeZonesChanged;

    @SerializedName("RegionsChanged")
    @Expose
    private String regionsChanged;

    public GetChangesIntData getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(GetChangesIntData campaigns) {
        this.campaigns = campaigns;
    }

    public GetChangesIntData getBanners() {
        return banners;
    }

    public void setBanners(GetChangesIntData banners) {
        this.banners = banners;
    }

    public List<CampaignStatChangeItem> getCampaignsStatChange() {
        return campaignsStatChange;
    }

    public void setCampaignsStatChange(List<CampaignStatChangeItem> campaignsStatChange) {
        this.campaignsStatChange = campaignsStatChange;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getRubricsChanged() {
        return rubricsChanged;
    }

    public void setRubricsChanged(String rubricsChanged) {
        this.rubricsChanged = rubricsChanged;
    }

    public String getTimeZonesChanged() {
        return timeZonesChanged;
    }

    public void setTimeZonesChanged(String timeZonesChanged) {
        this.timeZonesChanged = timeZonesChanged;
    }

    public String getRegionsChanged() {
        return regionsChanged;
    }

    public void setRegionsChanged(String regionsChanged) {
        this.regionsChanged = regionsChanged;
    }
}
