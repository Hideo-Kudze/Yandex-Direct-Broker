package com.HideoKuzeGits.YndexDirectAutobroker.domain.GoogleAnalytics;

import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.AbstractWrap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by root on 14.08.14.
 */

@Entity
public class AnalyticsAccount extends AbstractWrap {

    @Id
    private String accountId;

    private String name;

    public AnalyticsAccount() {
    }

    public AnalyticsAccount(String accountId, String name) {
        this.accountId = accountId;
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String account_id) {
        this.accountId = account_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
