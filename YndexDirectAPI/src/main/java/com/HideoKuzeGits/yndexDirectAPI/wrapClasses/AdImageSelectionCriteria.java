package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 08.07.14.
 */
public class AdImageSelectionCriteria {

    @Expose
    private List<String> Logins = new ArrayList<String>();

    @Expose
    private List<String> AdImageHashes = new ArrayList<String>();

    @Expose
    private List<Long> AdImageUploadTaskIDS = new ArrayList<Long>();

    @Expose
    private List<String> Assigned = new ArrayList<String>();

    @Expose
    private Long Limit;

    @Expose
    private Long Offset;

    public List<String> getLogins() {
        return Logins;
    }

    public void setLogins(List<String> logins) {
        Logins = logins;
    }

    public List<String> getAdImageHashes() {
        return AdImageHashes;
    }

    public void setAdImageHashes(List<String> adImageHashes) {
        AdImageHashes = adImageHashes;
    }

    public List<Long> getAdImageUploadTaskIDS() {
        return AdImageUploadTaskIDS;
    }

    public void setAdImageUploadTaskIDS(List<Long> adImageUploadTaskIDS) {
        AdImageUploadTaskIDS = adImageUploadTaskIDS;
    }

    public List<String> getAssigned() {
        return Assigned;
    }

    public void setAssigned(List<String> assigned) {
        Assigned = assigned;
    }

    public Long getLimit() {
        return Limit;
    }

    public void setLimit(Long limit) {
        Limit = limit;
    }

    public Long getOffset() {
        return Offset;
    }

    public void setOffset(Long offset) {
        Offset = offset;
    }
}
