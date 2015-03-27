package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class TransferMoneyInfo {

    @SerializedName("FromCampaigns")
    @Expose
    private List<PayCampElement> fromCampaigns = new ArrayList<PayCampElement>();
    @SerializedName("ToCampaigns")
    @Expose
    private List<PayCampElement> toCampaigns = new ArrayList<PayCampElement>();

    public TransferMoneyInfo(List<PayCampElement> fromCampaigns, List<PayCampElement> toCampaigns) {
        this.fromCampaigns = fromCampaigns;
        this.toCampaigns = toCampaigns;
    }

    public List<PayCampElement> getFromCampaigns() {
        return fromCampaigns;
    }

    public void setFromCampaigns(List<PayCampElement> fromCampaigns) {
        this.fromCampaigns = fromCampaigns;
    }

    public List<PayCampElement> getToCampaigns() {
        return toCampaigns;
    }

    public void setToCampaigns(List<PayCampElement> toCampaigns) {
        this.toCampaigns = toCampaigns;
    }

}
