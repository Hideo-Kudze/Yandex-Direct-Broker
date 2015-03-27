package com.HideoKuzeGits.YndexDirectAutobroker.domain.GoogleAnalytics;

import com.HideoKuzeGits.YndexDirectAutobroker.domain.APIAccounts.GoogleAnalyticsAccount;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.CampaignWithUTM;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.AbstractWrap;
import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by root on 14.08.14.
 */

@Entity

public class AnalyticsGoal extends AbstractWrap {


    @Id
    private Long id;

    @ManyToOne
    private GoogleAnalyticsAccount googleAnalyticsAccount;

    @ManyToOne(cascade = CascadeType.ALL)
    private AnalyticsAccount account;

    @ManyToOne(cascade = CascadeType.ALL)
    private AnalyticsWebproperty webproperty;

    @ManyToOne(cascade = CascadeType.ALL)
    private AnalyticsView view;

    private String goalId;

    private String name;
    private String dateOfCreating;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "goalsSet")
    private Set<CampaignWithUTM> campaignWithUTMSet;

    public AnalyticsGoal() {
    }

    public AnalyticsGoal(String goalId, String name) {
        this.goalId = goalId;
        this.name = name;
    }


    public GoogleAnalyticsAccount getGoogleAnalyticsAccount() {
        return googleAnalyticsAccount;
    }

    public void setId() {
        if (view != null && goalId != null)
            id = Long.decode(view.getViewId() + goalId);
    }

    public void setWebproperty(AnalyticsWebproperty webproperty) {
        this.webproperty = webproperty;
    }

    public void setGoalId(String goalId) {
        this.goalId = goalId;
        setId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGoogleAnalyticsAccount(GoogleAnalyticsAccount googleAnalyticsAccount) {
        this.googleAnalyticsAccount = googleAnalyticsAccount;
    }

    public AnalyticsAccount getAccount() {
        return account;
    }

    public void setAccount(AnalyticsAccount account) {
        this.account = account;
    }

    public AnalyticsWebproperty getWebproperty() {
        return webproperty;
    }

    public String getGoalId() {
        return goalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnalyticsView getView() {
        return view;
    }

    public void setView(AnalyticsView view) {
        this.view = view;
        setId();
    }

    public void setDateOfCreating(String dateOfCreating) {
        this.dateOfCreating = dateOfCreating;
    }

    public String getDateOfCreating() {
        return dateOfCreating;
    }

    public Set<CampaignWithUTM> getCampaignWithUTMSet() {
        return campaignWithUTMSet;
    }

    public void setCampaignWithUTMSet(Set<CampaignWithUTM> campaignWithUTMSet) {
        this.campaignWithUTMSet = campaignWithUTMSet;
    }
}
