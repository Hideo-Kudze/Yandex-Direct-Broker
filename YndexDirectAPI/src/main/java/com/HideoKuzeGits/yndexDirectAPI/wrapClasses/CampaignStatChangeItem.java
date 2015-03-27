package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 08.07.14.
 */
public class CampaignStatChangeItem extends AbstractWrap{

    @SerializedName("CampaignID")
    @Expose
    private Long campaignID;

    @SerializedName("BorderDate")
    @Expose
    private String borderDate;

    public Long getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(Long campaignID) {
        this.campaignID = campaignID;
    }

    public String getBorderDate() {
        return borderDate;
    }

    public void setBorderDate(String borderDate) {
        this.borderDate = borderDate;
    }
}
