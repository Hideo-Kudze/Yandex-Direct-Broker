package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 08.07.14.
 */
public class GetChangesIntData extends AbstractWrap{

    @SerializedName("Updated")
    @Expose
    private List<Long> updated = new ArrayList<Long>();

    @SerializedName("NotUpdated")
    @Expose
    private List<Long> notUpdated = new ArrayList<Long>();

    @SerializedName("NotFound")
    @Expose
    private List<Long> notFound = new ArrayList<Long>();

    public List<Long> getUpdated() {
        return updated;
    }

    public void setUpdated(List<Long> updated) {
        this.updated = updated;
    }

    public List<Long> getNotUpdated() {
        return notUpdated;
    }

    public void setNotUpdated(List<Long> notUpdated) {
        this.notUpdated = notUpdated;
    }

    public List<Long> getNotFound() {
        return notFound;
    }

    public void setNotFound(List<Long> notFound) {
        this.notFound = notFound;
    }
}
