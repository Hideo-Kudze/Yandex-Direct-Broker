package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 05.07.14.
 */
public class NewReportFilterInfo extends AbstractWrap{

    @SerializedName("PageType")
    @Expose
    private String pageType;

    @SerializedName("PositionType")
    @Expose
    private String positionType;

    @SerializedName("Banner")
    @Expose
    private Long[] banner;

    @SerializedName("Geo")
    @Expose
    private Long[] geo;

    @SerializedName("Phrase")
    @Expose
    private String[] phrase;

    @SerializedName("PageName")
    @Expose
    private String[] pageName;

    @SerializedName("StatGoals")
    @Expose
    private Long[] statGoals;

    @SerializedName("WithImage")
    @Expose
    private String withImage;



    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public Long[] getBanner() {
        return banner;
    }

    public void setBanner(Long[] banner) {
        this.banner = banner;
    }

    public Long[] getGeo() {
        return geo;
    }

    public void setGeo(Long[] geo) {
        this.geo = geo;
    }

    public String[] getPhrase() {
        return phrase;
    }

    public void setPhrase(String[] phrase) {
        this.phrase = phrase;
    }

    public String[] getPageName() {
        return pageName;
    }

    public void setPageName(String[] pageName) {
        this.pageName = pageName;
    }

    public Long[] getStatGoals() {
        return statGoals;
    }

    public void setStatGoals(Long[] statGoals) {
        this.statGoals = statGoals;
    }

    public String getWithImage() {
        return withImage;
    }

    public void setWithImage(String withImage) {
        this.withImage = withImage;
    }
}
