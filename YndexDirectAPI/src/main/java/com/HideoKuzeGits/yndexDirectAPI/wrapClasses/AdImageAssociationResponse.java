package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class AdImageAssociationResponse {

    @SerializedName("AdImageAssociations")
    @Expose
    private List<AdImageAssociation> adImageAssociations = new ArrayList<AdImageAssociation>();
    @SerializedName("AdImageAssociationActionResult")
    @Expose
    private List<AdImageAssociationActionResult> AdImageAssociationActionResult = new ArrayList<AdImageAssociationActionResult>();
    @SerializedName("TotalObjectsCount")
    @Expose
    private Long totalObjectsCount;

    public List<AdImageAssociation> getAdImageAssociations() {
        return adImageAssociations;
    }

    public void setAdImageAssociations(List<AdImageAssociation> adImageAssociations) {
        this.adImageAssociations = adImageAssociations;
    }

    public List<AdImageAssociationActionResult> getAdImageAssociationActionResult() {
        return AdImageAssociationActionResult;
    }

    public void setAdImageAssociationActionResult(List<AdImageAssociationActionResult> AdImageAssociationActionResult) {
        this.AdImageAssociationActionResult = AdImageAssociationActionResult;
    }

    public Long getTotalObjectsCount() {
        return totalObjectsCount;
    }

    public void setTotalObjectsCount(Long totalObjectsCount) {
        this.totalObjectsCount = totalObjectsCount;
    }

}