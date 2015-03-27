package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class RetargetingConditionGoalItem {

    @SerializedName("Time")
    @Expose
    private Long time;
    @SerializedName("GoalID")
    @Expose
    private Long goalID;

    public RetargetingConditionGoalItem(Long time, Long goalID) {
        this.time = time;
        this.goalID = goalID;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getGoalID() {
        return goalID;
    }

    public void setGoalID(Long goalID) {
        this.goalID = goalID;
    }

}