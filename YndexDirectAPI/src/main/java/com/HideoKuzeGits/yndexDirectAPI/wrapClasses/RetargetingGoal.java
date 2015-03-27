package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class RetargetingGoal extends AbstractWrap {

    @SerializedName("GoalID")
    @Expose
    private Long goalID;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("GoalDomain")
    @Expose
    private String goalDomain;
    @SerializedName("Login")
    @Expose
    private String login;

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

    public String getGoalDomain() {
        return goalDomain;
    }

    public void setGoalDomain(String goalDomain) {
        this.goalDomain = goalDomain;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}