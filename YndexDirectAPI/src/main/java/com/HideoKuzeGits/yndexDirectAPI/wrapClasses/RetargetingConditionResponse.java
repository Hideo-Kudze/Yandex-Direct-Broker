package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class RetargetingConditionResponse extends AbstractWrap{

    @SerializedName("ActionsResult")
    @Expose
    private List<RetargetingConditionActionResult> actionsResult = new ArrayList<RetargetingConditionActionResult>();
    @SerializedName("RetargetingConditions")
    @Expose
    private List<RetargetingCondition> retargetingConditions = new ArrayList<RetargetingCondition>();

    public List<RetargetingConditionActionResult> getActionsResult() {
        return actionsResult;
    }

    public void setActionsResult(List<RetargetingConditionActionResult> actionsResult) {
        this.actionsResult = actionsResult;
    }

    public List<RetargetingCondition> getRetargetingConditions() {
        return retargetingConditions;
    }

    public void setRetargetingConditions(List<RetargetingCondition> retargetingConditions) {
        this.retargetingConditions = retargetingConditions;
    }

}