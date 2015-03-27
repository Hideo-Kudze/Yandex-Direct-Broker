package com.HideoKuzeGits.YndexDirectAutobroker.domain;

import com.HideoKuzeGits.YndexDirectAutobroker.domain.APIAccounts.YndexDirectAccount;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.GoogleAnalytics.AnalyticsGoal;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.AbstractWrap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.graph.GraphAdapterBuilder;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by root on 30.07.14.
 */
@Entity
public class CampaignWithUTM {

    @Id
    private Long campaignId;
    private String name;

    @ManyToOne
    private YndexDirectAccount yndexDirectAccount;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<AnalyticsGoal> goalsSet;

    public CampaignWithUTM() {
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public String getName() {
        return name;
    }

    public void setName(String campaignName) {
        this.name = campaignName;
    }

    public YndexDirectAccount getYndexDirectAccount() {
        return yndexDirectAccount;
    }

    public void setYndexDirectAccount(YndexDirectAccount account) {
        this.yndexDirectAccount = account;
    }

    public Set<AnalyticsGoal> getGoalsSet() {
        return goalsSet;
    }

    public void setGoalsSet(Set<AnalyticsGoal> goalsSet) {
        this.goalsSet = goalsSet;
    }

    @Override
    public String toString() {

        GsonBuilder gsonBuilder = new GsonBuilder();
        new GraphAdapterBuilder().registerOn(gsonBuilder);
        Gson gson = gsonBuilder.create();

        return gson.toJson(this);
    }
}
