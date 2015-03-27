package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class GetBannersStatResponse extends AbstractWrap {

    @SerializedName("EndDate")
    @Expose
    private String endDate;
    @SerializedName("Stat")
    @Expose
    private List<BannersStatItem> stat = new ArrayList<BannersStatItem>();
    @SerializedName("CampaignID")
    @Expose
    private Long campaignID;
    @SerializedName("StartDate")
    @Expose
    private String startDate;

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<BannersStatItem> getStat() {
        return stat;
    }

    public void setStat(List<BannersStatItem> stat) {
        this.stat = stat;
    }

    public Long getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(Long campaignID) {
        this.campaignID = campaignID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

}