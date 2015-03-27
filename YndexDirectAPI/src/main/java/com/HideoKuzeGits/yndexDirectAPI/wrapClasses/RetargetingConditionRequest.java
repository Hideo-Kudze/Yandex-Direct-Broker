package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class RetargetingConditionRequest {

    public RetargetingConditionRequest(String action, RetargetingConditionSelectionCriteria selectionCriteria) {
        this.action = action;
        this.selectionCriteria = selectionCriteria;
    }

    public RetargetingConditionRequest(String action, List<RetargetingCondition> retargetingConditions) {
        this.action = action;
        this.retargetingConditions = retargetingConditions;
    }

    @SerializedName("Action")
    @Expose
    private String action;
    @SerializedName("RetargetingConditions")
    @Expose
    private List<RetargetingCondition> retargetingConditions = new ArrayList<RetargetingCondition>();

    @SerializedName("SelectionCriteria")
    @Expose
    private RetargetingConditionSelectionCriteria selectionCriteria;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<RetargetingCondition> getRetargetingConditions() {
        return retargetingConditions;
    }

    public void setRetargetingConditions(List<RetargetingCondition> retargetingConditions) {
        this.retargetingConditions = retargetingConditions;
    }

    public RetargetingConditionSelectionCriteria getSelectionCriteria() {
        return selectionCriteria;
    }

    public void setSelectionCriteria(RetargetingConditionSelectionCriteria selectionCriteria) {
        this.selectionCriteria = selectionCriteria;
    }
}