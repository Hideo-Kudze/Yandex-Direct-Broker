package com.HideoKuzeGits.YndexDirectAutobroker.domain.strategies;

import com.HideoKuzeGits.YndexDirectAutobroker.domain.APIAccounts.YndexDirectAccount;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.GoogleAnalytics.AnalyticsGoal;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.AbstractWrap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.graph.GraphAdapterBuilder;

import javax.persistence.*;

/**
 * Created by root on 19.09.14.
 */

@MappedSuperclass
public class Strategy extends AbstractWrap{

    @Id
    private Long id;

    @ManyToOne
    private YndexDirectAccount yndexDirectAccount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public YndexDirectAccount getYndexDirectAccount() {
        return yndexDirectAccount;
    }

    public void setYndexDirectAccount(YndexDirectAccount yndexDirectAccount) {
        this.yndexDirectAccount = yndexDirectAccount;
    }

    @Override
    public String toString() {

        GsonBuilder gsonBuilder = new GsonBuilder();
        new GraphAdapterBuilder().
                addType(ANYStrategy.class).
                addType(AnalyticsGoal.class).
                addType(YndexDirectAccount.class)
                .registerOn(gsonBuilder);
        Gson gson = gsonBuilder.create();

        return gson.toJson(this);
    }
}
