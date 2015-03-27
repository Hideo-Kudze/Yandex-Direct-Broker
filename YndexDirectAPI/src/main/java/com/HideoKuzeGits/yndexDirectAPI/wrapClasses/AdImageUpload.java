
package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class AdImageUpload extends AbstractWrap{

    @SerializedName("Login")
    @Expose
    private String login;
    @SerializedName("AdImageUploadTaskID")
    @Expose
    private Long adImageUploadTaskID;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("AdImageHash")
    @Expose
    private String adImageHash;
    @SerializedName("AdImageURL")
    @Expose
    private String adImageURL;
    @SerializedName("SourceURL")
    @Expose
    private String sourceURL;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Error")
    @Expose
    private Error error;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getAdImageUploadTaskID() {
        return adImageUploadTaskID;
    }

    public void setAdImageUploadTaskID(Long adImageUploadTaskID) {
        this.adImageUploadTaskID = adImageUploadTaskID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdImageHash() {
        return adImageHash;
    }

    public void setAdImageHash(String adImageHash) {
        this.adImageHash = adImageHash;
    }

    public String getAdImageURL() {
        return adImageURL;
    }

    public void setAdImageURL(String adImageURL) {
        this.adImageURL = adImageURL;
    }

    public String getSourceURL() {
        return sourceURL;
    }

    public void setSourceURL(String sourceURL) {
        this.sourceURL = sourceURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

}
