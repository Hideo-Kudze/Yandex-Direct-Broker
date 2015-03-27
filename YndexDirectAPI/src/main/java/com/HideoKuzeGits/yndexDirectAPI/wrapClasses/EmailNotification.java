package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class EmailNotification {

    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("WarnPlaceInterval")
    @Expose
    private Long warnPlaceInterval;
    @SerializedName("MoneyWarningValue")
    @Expose
    private Long moneyWarningValue;
    @SerializedName("SendAccNews")
    @Expose
    private String sendAccNews;
    @SerializedName("SendWarn")
    @Expose
    private String sendWarn;

    public EmailNotification() {
    }

    public EmailNotification(String email, Long warnPlaceInterval, Long moneyWarningValue) {
        this.email = email;
        this.warnPlaceInterval = warnPlaceInterval;
        this.moneyWarningValue = moneyWarningValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getWarnPlaceInterval() {
        return warnPlaceInterval;
    }

    public void setWarnPlaceInterval(Long warnPlaceInterval) {
        this.warnPlaceInterval = warnPlaceInterval;
    }

    public Long getMoneyWarningValue() {
        return moneyWarningValue;
    }

    public void setMoneyWarningValue(Long moneyWarningValue) {
        this.moneyWarningValue = moneyWarningValue;
    }

    public String getSendAccNews() {
        return sendAccNews;
    }

    public void setSendAccNews(String sendAccNews) {
        this.sendAccNews = sendAccNews;
    }

    public String getSendWarn() {
        return sendWarn;
    }

    public void setSendWarn(String sendWarn) {
        this.sendWarn = sendWarn;
    }

}