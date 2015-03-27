package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class RetargetingRequest {

    @SerializedName("Action")
    @Expose
    private String action;
    @SerializedName("Login")
    @Expose
    private String login;
    @SerializedName("Retargetings")
    @Expose
    private List<Retargeting> retargetings = new ArrayList<Retargeting>();
    @SerializedName("SelectionCriteria")
    @Expose
    private RetargetingSelectionCriteria selectionCriteria;
    @SerializedName("RetargetingRequestOptions")
    @Expose
    private RetargetingRequestOptions retargetingRequestOptions;

    public RetargetingRequest(String action, List<Retargeting> retargetings) {
        this.action = action;
        this.retargetings = retargetings;
    }

    public RetargetingRequest(String action, RetargetingSelectionCriteria selectionCriteria) {
        this.action = action;
        this.selectionCriteria = selectionCriteria;
    }

    public RetargetingRequest(String action,
                              List<Retargeting> retargetings,
                              RetargetingSelectionCriteria selectionCriteria) {
        this.action = action;
        this.retargetings = retargetings;
        this.selectionCriteria = selectionCriteria;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Retargeting> getRetargetings() {
        return retargetings;
    }

    public void setRetargetings(List<Retargeting> retargetings) {
        this.retargetings = retargetings;
    }

    public RetargetingSelectionCriteria getSelectionCriteria() {
        return selectionCriteria;
    }

    public void setSelectionCriteria(RetargetingSelectionCriteria selectionCriteria) {
        this.selectionCriteria = selectionCriteria;
    }

    public RetargetingRequestOptions getRetargetingRequestOptions() {
        return retargetingRequestOptions;
    }

    public void setRetargetingRequestOptions(RetargetingRequestOptions retargetingRequestOptions) {
        this.retargetingRequestOptions = retargetingRequestOptions;
    }

}