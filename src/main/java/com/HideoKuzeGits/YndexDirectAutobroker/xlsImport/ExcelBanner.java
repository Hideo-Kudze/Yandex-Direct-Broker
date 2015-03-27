package com.HideoKuzeGits.YndexDirectAutobroker.xlsImport;

import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.BannerInfo;

import java.util.List;

/**
 * Created by root on 01.09.14.
 */
public class ExcelBanner extends BannerInfo {

    private Boolean isAdditional;
    private Integer groupNum;
    private String imageUrl;
    private List<String> tagsNames;


    public ExcelBanner() {
    }

    public Boolean getIsAdditional() {
        return isAdditional;
    }

    public void setIsAdditional(Boolean isAdditional) {
        this.isAdditional = isAdditional;
    }

    public Integer getGroupNum() {
        return groupNum;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getTagsNames() {
        return tagsNames;
    }

    public void setTagsNames(List<String> tagsNames) {
        this.tagsNames = tagsNames;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
    }

}
