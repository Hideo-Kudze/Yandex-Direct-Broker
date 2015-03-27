
package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Warning {

    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("WarningString")
    @Expose
    private String warningString;
    @SerializedName("WarningCode")
    @Expose
    private Long warningCode;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWarningString() {
        return warningString;
    }

    public void setWarningString(String warningString) {
        this.warningString = warningString;
    }

    public Long getWarningCode() {
        return warningCode;
    }

    public void setWarningCode(Long warningCode) {
        this.warningCode = warningCode;
    }

}
