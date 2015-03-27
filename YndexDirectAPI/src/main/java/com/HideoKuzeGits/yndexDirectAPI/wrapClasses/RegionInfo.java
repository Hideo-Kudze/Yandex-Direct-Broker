package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class RegionInfo extends AbstractWrap{

    @Expose
    private String RegionType;
    @Expose
    private Long ParentID;
    @Expose
    private Long RegionID;
    @Expose
    private String RegionName;

    public String getRegionType() {
        return RegionType;
    }

    public void setRegionType(String RegionType) {
        this.RegionType = RegionType;
    }

    public Long getParentID() {
        return ParentID;
    }

    public void setParentID(Long ParentID) {
        this.ParentID = ParentID;
    }

    public Long getRegionID() {
        return RegionID;
    }

    public void setRegionID(Long RegionID) {
        this.RegionID = RegionID;
    }

    public String getRegionName() {
        return RegionName;
    }

    public void setRegionName(String RegionName) {
        this.RegionName = RegionName;
    }

}