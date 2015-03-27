package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 07.07.14.
 */
public class NewWordstatReportInfo {

    @SerializedName("Phrases")
    @Expose
    private List<String> phrases = new ArrayList<String>();

    @SerializedName("GeoID")
    @Expose
    private List<Long> geoID = new ArrayList<Long>();

    public NewWordstatReportInfo(List<String> phrases) {
        this.phrases = phrases;
    }

    public List<String> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<String> phrases) {
        this.phrases = phrases;
    }

    public List<Long> getGeoID() {
        return geoID;
    }

    public void setGeoID(List<Long> geoID) {
        this.geoID = geoID;
    }
}
