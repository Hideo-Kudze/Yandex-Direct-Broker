package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 30.07.14.
 */
public class Sitelink extends AbstractWrap {

    @SerializedName("Title")
    @Expose
    private String title;

    @SerializedName("Href")
    @Expose
    private String href;

    public Sitelink() {
    }

    public Sitelink(String title, String href) {
        this.title = title;
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
