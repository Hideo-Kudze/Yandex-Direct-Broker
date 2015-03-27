package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class BannersFilterInfo {

    @SerializedName("StatusPhoneModerate")
    @Expose
    private List<String> statusPhoneModerate = new ArrayList<String>();
    @SerializedName("StatusBannerModerate")
    @Expose
    private List<String> statusBannerModerate = new ArrayList<String>();
    @SerializedName("StatusPhrasesModerate")
    @Expose
    private List<String> statusPhrasesModerate = new ArrayList<String>();
    @SerializedName("StatusActivating")
    @Expose
    private List<String> statusActivating = new ArrayList<String>();
    @SerializedName("StatusShow")
    @Expose
    private List<String> statusShow = new ArrayList<String>();
    @SerializedName("IsActive")
    @Expose
    private List<String> isActive = new ArrayList<String>();
    @SerializedName("StatusArchive")
    @Expose
    private List<String> statusArchive = new ArrayList<String>();

    public List<String> getStatusPhoneModerate() {
        return statusPhoneModerate;
    }

    public void setStatusPhoneModerate(List<String> statusPhoneModerate) {
        this.statusPhoneModerate = statusPhoneModerate;
    }

    public List<String> getStatusBannerModerate() {
        return statusBannerModerate;
    }

    public void setStatusBannerModerate(List<String> statusBannerModerate) {
        this.statusBannerModerate = statusBannerModerate;
    }

    public List<String> getStatusPhrasesModerate() {
        return statusPhrasesModerate;
    }

    public void setStatusPhrasesModerate(List<String> statusPhrasesModerate) {
        this.statusPhrasesModerate = statusPhrasesModerate;
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

}