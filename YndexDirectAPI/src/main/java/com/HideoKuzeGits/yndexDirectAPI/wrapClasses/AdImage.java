
package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class AdImage extends AbstractWrap{

    @SerializedName("Login")
    @Expose
    private String login;
    @SerializedName("AdImageHash")
    @Expose
    private String adImageHash;
    @SerializedName("AdImageURL")
    @Expose
    private String adImageURL;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Assigned")
    @Expose
    private String assigned;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

}
