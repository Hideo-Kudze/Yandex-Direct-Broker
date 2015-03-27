
package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class AdImageLimit extends AbstractWrap{

    @SerializedName("Login")
    @Expose
    private String login;
    @SerializedName("Capacity")
    @Expose
    private Long capacity;
    @SerializedName("Utilized")
    @Expose
    private Long utilized;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public Long getUtilized() {
        return utilized;
    }

    public void setUtilized(Long utilized) {
        this.utilized = utilized;
    }

}
