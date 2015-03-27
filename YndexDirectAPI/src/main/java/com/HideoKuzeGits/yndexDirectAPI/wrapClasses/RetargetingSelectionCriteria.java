package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class RetargetingSelectionCriteria {

    @SerializedName("RetargetingConditionIDS")
    @Expose
    private List<Long> retargetingConditionIDS = new ArrayList<Long>();
    @SerializedName("RetargetingIDS")
    @Expose
    private List<Long> retargetingIDS = new ArrayList<Long>();
    @SerializedName("AdIDS")
    @Expose
    private List<Long> adIDS = new ArrayList<Long>();


    public List<Long> getRetargetingConditionIDS() {
        return retargetingConditionIDS;
    }

    public void setRetargetingConditionIDS(List<Long> retargetingConditionIDS) {
        this.retargetingConditionIDS = retargetingConditionIDS;
    }

    public List<Long> getRetargetingIDS() {
        return retargetingIDS;
    }

    public void setRetargetingIDS(List<Long> retargetingIDS) {
        this.retargetingIDS = retargetingIDS;
    }

    public List<Long> getAdIDS() {
        return adIDS;
    }

    public void setAdIDS(List<Long> adIDS) {
        this.adIDS = adIDS;
    }

}