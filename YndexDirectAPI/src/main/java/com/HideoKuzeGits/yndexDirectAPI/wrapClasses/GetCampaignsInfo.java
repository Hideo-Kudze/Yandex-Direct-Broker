package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class GetCampaignsInfo {

    public GetCampaignsInfo() {
    }

    public GetCampaignsInfo(CampaignsFilterInfo filter) {
        this.filter = filter;
    }

    @SerializedName("Logins")
    @Expose
    private List<String> logins = new ArrayList<String>();
    @SerializedName("Filter")
    @Expose
    private CampaignsFilterInfo filter;
    @SerializedName("Limit")
    @Expose
    private Long limit;
    @SerializedName("Offset")
    @Expose
    private Long offset;
    @SerializedName("CurrencySupported")
    @Expose
    private String currencySupported;

    public List<String> getLogins() {
        return logins;
    }

    public void setLogins(List<String> logins) {
        this.logins = logins;
    }

    public CampaignsFilterInfo getFilter() {
        return filter;
    }

    public void setFilter(CampaignsFilterInfo filter) {
        this.filter = filter;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public String getCurrencySupported() {
        return currencySupported;
    }

    public void setCurrencySupported(String currencySupported) {
        this.currencySupported = currencySupported;
    }

}