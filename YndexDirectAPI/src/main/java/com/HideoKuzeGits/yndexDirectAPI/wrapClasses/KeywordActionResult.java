package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class KeywordActionResult extends AbstractWrap{

    @SerializedName("Warnings")
    @Expose
    private List<Warning> warnings = new ArrayList<Warning>();
    @SerializedName("Errors")
    @Expose
    private List<Error> errors = new ArrayList<Error>();
    @SerializedName("KeywordID")
    @Expose
    private Long keywordID;

    public List<Warning> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<Warning> warnings) {
        this.warnings = warnings;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public Long getKeywordID() {
        return keywordID;
    }

    public void setKeywordID(Long keywordID) {
        this.keywordID = keywordID;
    }

}