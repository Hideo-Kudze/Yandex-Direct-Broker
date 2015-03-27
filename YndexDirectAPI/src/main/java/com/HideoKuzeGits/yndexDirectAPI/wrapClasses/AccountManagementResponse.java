package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class AccountManagementResponse {

    @SerializedName("ActionsResult")
    @Expose
    private List<AccountActionResult> actionsResult = new ArrayList<AccountActionResult>();
    @SerializedName("APIAccounts")
    @Expose
    private List<Account> accounts = new ArrayList<Account>();

    public List<AccountActionResult> getActionsResult() {
        return actionsResult;
    }

    public void setActionsResult(List<AccountActionResult> actionsResult) {
        this.actionsResult = actionsResult;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

}