package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ClientRight {

    public ClientRight() {
    }

    public ClientRight(String rightName, String value) {
        this.rightName = rightName;
        this.value = value;
    }

    @SerializedName("RightName")
    @Expose
    private String rightName;
    @SerializedName("Value")
    @Expose
    private String value;

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}