package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class TimeZoneInfo extends AbstractWrap{

    @Expose
    private Long GMTOffset;
    @Expose
    private String TimeZone;
    @Expose
    private String Name;

    public Long getGMTOffset() {
        return GMTOffset;
    }

    public void setGMTOffset(Long GMTOffset) {
        this.GMTOffset = GMTOffset;
    }

    public String getTimeZone() {
        return TimeZone;
    }

    public void setTimeZone(String TimeZone) {
        this.TimeZone = TimeZone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

}