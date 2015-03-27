package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class CampaignsFilterInfo {

    @SerializedName("StatusModerate")
    @Expose
    private List<String> statusModerate ;
    @SerializedName("IsActive")
    @Expose
    private List<String> isActive;
    @SerializedName("StatusArchive")
    @Expose
    private List<String> statusArchive;
    @SerializedName("StatusActivating")
    @Expose
    private List<String> statusActivating;
    @SerializedName("StatusShow")
    @Expose
    private List<String> statusShow;

    public List<String> getStatusModerate() {
        return statusModerate;
    }

    public void setStatusModerate(List<String> statusModerate) {
        this.statusModerate = statusModerate;
    }

    public List<String> getIsActive() {
        return isActive;
    }

    public void setIsActive(List<String> isActive) {
        this.isActive = isActive;
    }

    public List<String> getStatusArchive() {
        return statusArchive;
    }

    public void setStatusArchive(List<String> statusArchive) {
        this.statusArchive = statusArchive;
    }

    public List<String> getStatusActivating() {
        return statusActivating;
    }

    public void setStatusActivating(List<String> statusActivating) {
        this.statusActivating = statusActivating;
    }

    public List<String> getStatusShow() {
        return statusShow;
    }

    public void setStatusShow(List<String> statusShow) {
        this.statusShow = statusShow;
    }

}