package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class RetargetingCondition extends AbstractWrap{

    @SerializedName("RetargetingConditionName")
    @Expose
    private String retargetingConditionName;
    @SerializedName("RetargetingConditionDescription")
    @Expose
    private String retargetingConditionDescription;
    @SerializedName("RetargetingConditionID")
    @Expose
    private Long retargetingConditionID;
    @SerializedName("Login")
    @Expose
    private String login;
    @SerializedName("IsAccessible")
    @Expose
    private String isAccessible;
    @SerializedName("Fields")
    @Expose
    private List<String> fields = new ArrayList<String>();

    @SerializedName("RetargetingCondition")
    @Expose
    private List<RetargetingConditionItem> retargetingCondition = new ArrayList<RetargetingConditionItem>();

    public RetargetingCondition() {
    }



    public RetargetingCondition(String retargetingConditionName, String login, List<RetargetingConditionItem> retargetingCondition) {
        this.retargetingConditionName = retargetingConditionName;
        this.login = login;
        this.retargetingCondition = retargetingCondition;
    }

    public RetargetingCondition(Long retargetingConditionID) {
        this.retargetingConditionID = retargetingConditionID;
    }

    public String getIsAccessible() {
        return isAccessible;
    }

    public void setIsAccessible(String isAccessible) {
        this.isAccessible = isAccessible;
    }

    public String getRetargetingConditionName() {
        return retargetingConditionName;
    }

    public void setRetargetingConditionName(String retargetingConditionName) {
        this.retargetingConditionName = retargetingConditionName;
    }

    public String getRetargetingConditionDescription() {
        return retargetingConditionDescription;
    }

    public void setRetargetingConditionDescription(String retargetingConditionDescription) {
        this.retargetingConditionDescription = retargetingConditionDescription;
    }

    public Long getRetargetingConditionID() {
        return retargetingConditionID;
    }

    public void setRetargetingConditionID(Long retargetingConditionID) {
        this.retargetingConditionID = retargetingConditionID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public List<RetargetingConditionItem> getRetargetingCondition() {
        return retargetingCondition;
    }

    public void setRetargetingCondition(List<RetargetingConditionItem> retargetingCondition) {
        this.retargetingCondition = retargetingCondition;
    }

}