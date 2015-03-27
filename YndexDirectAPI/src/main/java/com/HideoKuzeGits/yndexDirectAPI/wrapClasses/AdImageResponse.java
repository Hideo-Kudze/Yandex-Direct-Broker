
package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class AdImageResponse {

    @SerializedName("ActionsResult")
    @Expose
    private List<AdImageActionResult> actionsResult = new ArrayList<AdImageActionResult>();
    @SerializedName("AdImageUploads")
    @Expose
    private List<AdImageUpload> adImageUploads = new ArrayList<AdImageUpload>();
    @SerializedName("TotalObjectsCount")
    @Expose
    private Long totalObjectsCount;
    @SerializedName("AdImages")
    @Expose
    private List<AdImage> adImages = new ArrayList<AdImage>();
    @SerializedName("AdImageLimits")
    @Expose
    private List<AdImageLimit> adImageLimits = new ArrayList<AdImageLimit>();

    public List<AdImageActionResult> getActionsResult() {
        return actionsResult;
    }

    public void setActionsResult(List<AdImageActionResult> actionsResult) {
        this.actionsResult = actionsResult;
    }

    public List<AdImageUpload> getAdImageUploads() {
        return adImageUploads;
    }

    public void setAdImageUploads(List<AdImageUpload> adImageUploads) {
        this.adImageUploads = adImageUploads;
    }

    public Long getTotalObjectsCount() {
        return totalObjectsCount;
    }

    public void setTotalObjectsCount(Long totalObjectsCount) {
        this.totalObjectsCount = totalObjectsCount;
    }

    public List<AdImage> getAdImages() {
        return adImages;
    }

    public void setAdImages(List<AdImage> adImages) {
        this.adImages = adImages;
    }

    public List<AdImageLimit> getAdImageLimits() {
        return adImageLimits;
    }

    public void setAdImageLimits(List<AdImageLimit> adImageLimits) {
        this.adImageLimits = adImageLimits;
    }

}
