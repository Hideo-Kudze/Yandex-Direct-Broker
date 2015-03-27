
package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class AccountSelectionCriteria {

    @SerializedName("Logins")
    @Expose
    private List<String> logins = new ArrayList<String>();
    @SerializedName("AccountIDS")
    @Expose
    private List<Long> accountIDS = new ArrayList<Long>();

    public List<String> getLogins() {
        return logins;
    }

    public void setLogins(List<String> logins) {
        this.logins = logins;
    }

    public List<Long> getAccountIDS() {
        return accountIDS;
    }

    public void setAccountIDS(List<Long> accountIDS) {
        this.accountIDS = accountIDS;
    }

}