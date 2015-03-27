package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Retargeting extends AbstractWrap{

    @SerializedName("Fields")
    @Expose
    private List<String> fields = new ArrayList<String>();
    @SerializedName("RetargetingID")
    @Expose
    private Long retargetingID;
    @SerializedName("AdID")
    @Expose
    private Long adID;
    @SerializedName("RetargetingConditionID")
    @Expose
    private Long retargetingConditionID;
    @SerializedName("ContextPrice")
    @Expose
    private Double contextPrice;
    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("AutoBudgetPriority")
    @Expose
    private String autoBudgetPriority;
    @SerializedName("StatusPaused")
    @Expose
    private String statusPaused;

    public Retargeting() {
    }

    public Retargeting(Long adID, Long retargetingConditionID) {
        this.adID = adID;
        this.retargetingConditionID = retargetingConditionID;
    }

    public Retargeting(Long retargetingID) {
        this.retargetingID = retargetingID;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public Long getRetargetingID() {
        return retargetingID;
    }

    public void setRetargetingID(Long retargetingID) {
        this.retargetingID = retargetingID;
    }

    public Long getAdID() {
        return adID;
    }

    public void setAdID(Long adID) {
        this.adID = adID;
    }

    public Long getRetargetingConditionID() {
        return retargetingConditionID;
    }

    public void setRetargetingConditionID(Long retargetingConditionID) {
        this.retargetingConditionID = retargetingConditionID;
    }

    public Double getContextPrice() {
        return contextPrice;
    }

    public void setContextPrice(Double contextPrice) {
        this.contextPrice = contextPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAutoBudgetPriority() {
        return autoBudgetPriority;
    }

    public void setAutoBudgetPriority(String autoBudgetPriority) {
        this.autoBudgetPriority = autoBudgetPriority;
    }

    public String getStatusPaused() {
        return statusPaused;
    }

    public void setStatusPaused(String statusPaused) {
        this.statusPaused = statusPaused;
    }

}