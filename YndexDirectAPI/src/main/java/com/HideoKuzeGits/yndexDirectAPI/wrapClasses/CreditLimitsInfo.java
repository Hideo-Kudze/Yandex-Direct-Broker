package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class CreditLimitsInfo extends AbstractWrap{

    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("Limits")
    @Expose
    private List<CreditLimitsItem> limits = new ArrayList<CreditLimitsItem>();

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<CreditLimitsItem> getLimits() {
        return limits;
    }

    public void setLimits(List<CreditLimitsItem> limits) {
        this.limits = limits;
    }

}