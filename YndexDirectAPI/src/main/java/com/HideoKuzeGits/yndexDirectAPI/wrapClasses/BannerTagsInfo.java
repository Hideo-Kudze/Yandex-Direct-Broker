
package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class BannerTagsInfo extends AbstractWrap{

    @SerializedName("BannerID")
    @Expose
    private Long bannerID;
    @SerializedName("TagIDS")
    @Expose
    private List<Long> tagIDS = new ArrayList<Long>();

    public Long getBannerID() {
        return bannerID;
    }

    public void setBannerID(Long bannerID) {
        this.bannerID = bannerID;
    }

    public List<Long> getTags() {
        return tagIDS;
    }

    public void setTags(List<Long> tags) {
        this.tagIDS = tags;
    }

}
