
package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Tag extends AbstractWrap{

    @SerializedName("TagID")
    @Expose
    private Long tagID;
    @SerializedName("Tag")
    @Expose
    private String tag;

    public Tag() {
    }

    public Tag(String tag, Long tagID) {
        this.tagID = tagID;
        this.tag = tag;
    }

    public Long getTagID() {
        return tagID;
    }

    public void setTagID(Long tagID) {
        this.tagID = tagID;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
