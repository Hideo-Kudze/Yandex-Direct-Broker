package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 07.07.14.
 */
public class WordstatItem extends AbstractWrap{

    @SerializedName("Phrase")
    @Expose
    private String phrase;

    @SerializedName("Shows")
    @Expose
    private String shows;

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getShows() {
        return shows;
    }

    public void setShows(String shows) {
        this.shows = shows;
    }
}
