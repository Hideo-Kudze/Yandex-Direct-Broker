package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by root on 08.07.14.
 */
public class AdImageRequest extends AbstractWrap {


    public AdImageRequest(String action, AdImageSelectionCriteria selectionCriteria) {
        Action = action;
        SelectionCriteria = selectionCriteria;
    }


    public AdImageRequest(String action, List adImages) {

        Action = action;
        AdImageURLData = adImages;
    }

    @Expose
    private String Action;

    @Expose
    private List<AdImageURL> AdImageURLData;

    @Expose
    private List<AdImageRaw> AdImageRawData;

    @Expose
    private AdImageSelectionCriteria SelectionCriteria;


    public List<AdImageRaw> getAdImageRawData() {
        return AdImageRawData;
    }

    public void setAdImageRawData(List<AdImageRaw> adImageRawData) {
        AdImageRawData = adImageRawData;
    }

    public AdImageSelectionCriteria getSelectionCriteria() {
        return SelectionCriteria;
    }

    public void setSelectionCriteria(AdImageSelectionCriteria selectionCriteria) {
        SelectionCriteria = selectionCriteria;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }

    public List<AdImageURL> getAdImageURLData() {
        return AdImageURLData;
    }

    public void setAdImageURLData(List<AdImageURL> adImageURLData) {
        AdImageURLData = adImageURLData;
    }
}
