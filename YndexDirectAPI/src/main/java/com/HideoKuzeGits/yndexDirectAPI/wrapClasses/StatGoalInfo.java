package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 08.07.14.
 */
public class StatGoalInfo extends AbstractWrap{

    @SerializedName("GoalID")
    @Expose
    private Long goalID;

    @SerializedName("Name")
    @Expose
    private String name;

    public Long getGoalID() {
        return goalID;
    }

    public void setGoalID(Long goalID) {
        this.goalID = goalID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
