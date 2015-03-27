
package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class AdImageActionResult extends AbstractWrap{

    @SerializedName("AdImageUploadTaskID")
    @Expose
    private Long adImageUploadTaskID;
    @SerializedName("AdImageHash")
    @Expose
    private String adImageHash;
    @SerializedName("Errors")
    @Expose
    private List<Error> errors = new ArrayList<Error>();

    public Long getAdImageUploadTaskID() {
        return adImageUploadTaskID;
    }

    public void setAdImageUploadTaskID(Long adImageUploadTaskID) {
        this.adImageUploadTaskID = adImageUploadTaskID;
    }

    public String getAdImageHash() {
        return adImageHash;
    }

    public void setAdImageHash(String adImageHash) {
        this.adImageHash = adImageHash;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

}
