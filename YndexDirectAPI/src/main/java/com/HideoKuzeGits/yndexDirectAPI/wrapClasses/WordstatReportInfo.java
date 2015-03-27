package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 07.07.14.
 */
public class WordstatReportInfo extends AbstractWrap{

    @SerializedName("Phrase")
    @Expose
    private String phrase;

    @SerializedName("GeoID")
    @Expose
    private List<Long> geoID = new ArrayList<Long>();

    @SerializedName("SearchedWith")
    @Expose
    private List<WordstatItem> searchedWith = new ArrayList<WordstatItem>();

    @SerializedName("SearchedAlso")
    @Expose
    private List<WordstatItem> searchedAlso = new ArrayList<WordstatItem>();


    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public List<Long> getGeoID() {
        return geoID;
    }

    public void setGeoID(List<Long> geoID) {
        this.geoID = geoID;
    }

    public List<WordstatItem> getSearchedWith() {
        return searchedWith;
    }

    public void setSearchedWith(List<WordstatItem> searchedWith) {
        this.searchedWith = searchedWith;
    }

    public List<WordstatItem> getSearchedAlso() {
        return searchedAlso;
    }

    public void setSearchedAlso(List<WordstatItem> searchedAlso) {
        this.searchedAlso = searchedAlso;
    }
}
