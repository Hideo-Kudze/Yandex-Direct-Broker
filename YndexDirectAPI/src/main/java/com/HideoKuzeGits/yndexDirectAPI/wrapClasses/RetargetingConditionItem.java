package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class RetargetingConditionItem {

    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("Goals")
    @Expose
    private List<RetargetingConditionGoalItem> goals = new ArrayList<RetargetingConditionGoalItem>();

    public RetargetingConditionItem(String type, List<RetargetingConditionGoalItem> goals) {
        this.type = type;
        this.goals = goals;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<RetargetingConditionGoalItem> getGoals() {
        return goals;
    }

    public void setGoals(List<RetargetingConditionGoalItem> goals) {
        this.goals = goals;
    }

}