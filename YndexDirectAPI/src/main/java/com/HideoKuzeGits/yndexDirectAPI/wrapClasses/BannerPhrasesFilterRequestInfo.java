package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class BannerPhrasesFilterRequestInfo {

    public BannerPhrasesFilterRequestInfo(List<Long> bannerIDS) {
        this.bannerIDS = bannerIDS;
    }

    @SerializedName("BannerIDS")
    @Expose
    private List<Long> bannerIDS = new ArrayList<Long>();
    @SerializedName("FieldsNames")
    @Expose
    private List<String> fieldsNames = new ArrayList<String>();
    @SerializedName("ConsiderTimeTarget")
    @Expose
    private String considerTimeTarget;
    @SerializedName("RequestPrices")
    @Expose
    private String requestPrices;
    @SerializedName("Currency")
    @Expose
    private String currency;



    public List<Long> getBannerIDS() {
        return bannerIDS;
    }

    public void setBannerIDS(List<Long> bannerIDS) {
        this.bannerIDS = bannerIDS;
    }

    public List<String> getFieldsNames() {
        return fieldsNames;
    }

    public void setFieldsNames(List<String> fieldsNames) {
        this.fieldsNames = fieldsNames;
    }

    public String getConsiderTimeTarget() {
        return considerTimeTarget;
    }

    public void setConsiderTimeTarget(String considerTimeTarget) {
        this.considerTimeTarget = considerTimeTarget;
    }

    public String getRequestPrices() {
        return requestPrices;
    }

    public void setRequestPrices(String requestPrices) {
        this.requestPrices = requestPrices;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}