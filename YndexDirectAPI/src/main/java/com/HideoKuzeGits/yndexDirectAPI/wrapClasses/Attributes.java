package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Attributes {

    @Expose
    private String ModerationResult;
    @Expose
    private String IsEditedByModerator;
    @Expose
    private Double MinPrice;
    @Expose
    private Double Rest;
    @Expose
    private Double Payed;
    @Expose
    private String FinishDate;
    @Expose
    private String OldPlace;
    @Expose
    private String StopTime;
    @Expose
    private String Currency;

    public Double getMinPrice() {
        return MinPrice;
    }

    public void setMinPrice(Double minPrice) {
        MinPrice = minPrice;
    }

    public Double getRest() {
        return Rest;
    }

    public void setRest(Double rest) {
        Rest = rest;
    }

    public Double getPayed() {
        return Payed;
    }

    public void setPayed(Double payed) {
        Payed = payed;
    }

    public String getFinishDate() {
        return FinishDate;
    }

    public void setFinishDate(String finishDate) {
        FinishDate = finishDate;
    }

    public String getOldPlace() {
        return OldPlace;
    }

    public void setOldPlace(String oldPlace) {
        OldPlace = oldPlace;
    }

    public String getStopTime() {
        return StopTime;
    }

    public void setStopTime(String stopTime) {
        StopTime = stopTime;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getModerationResult() {
        return ModerationResult;
    }

    public void setModerationResult(String ModerationResult) {
        this.ModerationResult = ModerationResult;
    }

    public String getIsEditedByModerator() {
        return IsEditedByModerator;
    }

    public void setIsEditedByModerator(String IsEditedByModerator) {
        this.IsEditedByModerator = IsEditedByModerator;
    }



}