package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class AdImageAssociationRequest {

    @SerializedName("Action")
    @Expose
    private String action;
    @SerializedName("SelectionCriteria")
    @Expose
    private AdImageAssociationSelectionCriteria SelectionCriteria;
    @SerializedName("AdImageAssociations")
    @Expose
    private List<AdImageAssociation> adImageAssociations = new ArrayList<AdImageAssociation>();

    public AdImageAssociationRequest(String action, List<AdImageAssociation> adImageAssociations) {
        this.adImageAssociations = adImageAssociations;
        this.action = action;
    }

    public AdImageAssociationRequest(String action, AdImageAssociationSelectionCriteria adImageAssociationSelectionCriteria) {
        this.action = action;
        SelectionCriteria = adImageAssociationSelectionCriteria;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public AdImageAssociationSelectionCriteria getSelectionCriteria() {
        return SelectionCriteria;
    }

    public void setSelectionCriteria(AdImageAssociationSelectionCriteria AdImageAssociationSelectionCriteria) {
        this.SelectionCriteria = AdImageAssociationSelectionCriteria;
    }

    public List<AdImageAssociation> getAdImageAssociations() {
        return adImageAssociations;
    }

    public void setAdImageAssociations(List<AdImageAssociation> adImageAssociations) {
        this.adImageAssociations = adImageAssociations;
    }

}