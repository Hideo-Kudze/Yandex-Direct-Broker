package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class RetargetingConditionSelectionCriteria {

    @SerializedName("RetargetingConditionIDS")
    @Expose
    private List<Long> retargetingConditionIDS = new ArrayList<Long>();
    @SerializedName("Logins")
    @Expose
    private List<String> logins = new ArrayList<String>();

    public RetargetingConditionSelectionCriteria() {
    }

    public RetargetingConditionSelectionCriteria(List<Long> retargetingConditionIDS) {
        this.retargetingConditionIDS = retargetingConditionIDS;
    }

    public List<Long> getRetargetingConditionIDS() {
        return retargetingConditionIDS;
    }

    public void setRetargetingConditionIDS(List<Long> retargetingConditionIDS) {
        this.retargetingConditionIDS = retargetingConditionIDS;
    }

    public List<String> getLogins() {
        return logins;
    }

    public void setLogins(List<String> logins) {
        this.logins = logins;
    }

}