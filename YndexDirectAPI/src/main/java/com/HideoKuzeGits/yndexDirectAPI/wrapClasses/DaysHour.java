package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class DaysHour {

    @SerializedName("Hours")
    @Expose
    private List<Long> hours = new ArrayList<Long>();
    @SerializedName("Days")
    @Expose
    private List<Long> days = new ArrayList<Long>();
    @SerializedName("BidCoefs")
    @Expose
    private List<Long> bidCoefs = new ArrayList<Long>();

    public List<Long> getHours() {
        return hours;
    }

    public void setHours(List<Long> hours) {
        this.hours = hours;
    }

    public List<Long> getDays() {
        return days;
    }

    public void setDays(List<Long> days) {
        this.days = days;
    }

    public List<Long> getBidCoefs() {
        return bidCoefs;
    }

    public void setBidCoefs(List<Long> bidCoefs) {
        this.bidCoefs = bidCoefs;
    }

}