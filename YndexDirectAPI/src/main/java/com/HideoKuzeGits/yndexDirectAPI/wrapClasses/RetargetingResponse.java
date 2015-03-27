package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class RetargetingResponse {

    @SerializedName("ActionsResult")
    @Expose
    private List<RetargetingActionResult> actionsResult = new ArrayList<RetargetingActionResult>();
    @SerializedName("Retargetings")
    @Expose
    private List<Retargeting> retargetings = new ArrayList<Retargeting>();

    public List<RetargetingActionResult> getActionsResult() {
        return actionsResult;
    }

    public void setActionsResult(List<RetargetingActionResult> actionsResult) {
        this.actionsResult = actionsResult;
    }

    public List<Retargeting> getRetargetings() {
        return retargetings;
    }

    public void setRetargetings(List<Retargeting> retargetings) {
        this.retargetings = retargetings;
    }

}