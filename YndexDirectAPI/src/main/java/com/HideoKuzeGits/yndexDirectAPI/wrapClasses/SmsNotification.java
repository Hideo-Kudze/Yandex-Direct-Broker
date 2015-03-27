package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class SmsNotification {

    @SerializedName("MetricaSms")
    @Expose
    private String metricaSms;
    @SerializedName("ModerateResultSms")
    @Expose
    private String moderateResultSms;
    @SerializedName("MoneyInSms")
    @Expose
    private String moneyInSms;
    @SerializedName("MoneyOutSms")
    @Expose
    private String moneyOutSms;
    @SerializedName("SmsTimeFrom")
    @Expose
    private String smsTimeFrom;
    @SerializedName("SmsTimeTo")
    @Expose
    private String smsTimeTo;

    public String getMetricaSms() {
        return metricaSms;
    }

    public void setMetricaSms(String metricaSms) {
        this.metricaSms = metricaSms;
    }

    public String getModerateResultSms() {
        return moderateResultSms;
    }

    public void setModerateResultSms(String moderateResultSms) {
        this.moderateResultSms = moderateResultSms;
    }

    public String getMoneyInSms() {
        return moneyInSms;
    }

    public void setMoneyInSms(String moneyInSms) {
        this.moneyInSms = moneyInSms;
    }

    public String getMoneyOutSms() {
        return moneyOutSms;
    }

    public void setMoneyOutSms(String moneyOutSms) {
        this.moneyOutSms = moneyOutSms;
    }

    public String getSmsTimeFrom() {
        return smsTimeFrom;
    }

    public void setSmsTimeFrom(String smsTimeFrom) {
        this.smsTimeFrom = smsTimeFrom;
    }

    public String getSmsTimeTo() {
        return smsTimeTo;
    }

    public void setSmsTimeTo(String smsTimeTo) {
        this.smsTimeTo = smsTimeTo;
    }

}