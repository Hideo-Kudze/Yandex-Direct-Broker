package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class RubricInfo extends AbstractWrap{

    @Expose
    private String RubricName;
    @Expose
    private Long RubricID;
    @Expose
    private String RubricFullName;
    @Expose
    private Object ParentID;
    @Expose
    private String Checkable;
    @Expose
    private String Url;

    public String getRubricName() {
        return RubricName;
    }

    public void setRubricName(String RubricName) {
        this.RubricName = RubricName;
    }

    public Long getRubricID() {
        return RubricID;
    }

    public void setRubricID(Long RubricID) {
        this.RubricID = RubricID;
    }

    public String getRubricFullName() {
        return RubricFullName;
    }

    public void setRubricFullName(String RubricFullName) {
        this.RubricFullName = RubricFullName;
    }

    public Object getParentID() {
        return ParentID;
    }

    public void setParentID(Object ParentID) {
        this.ParentID = ParentID;
    }

    public String getCheckable() {
        return Checkable;
    }

    public void setCheckable(String Checkable) {
        this.Checkable = Checkable;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

}