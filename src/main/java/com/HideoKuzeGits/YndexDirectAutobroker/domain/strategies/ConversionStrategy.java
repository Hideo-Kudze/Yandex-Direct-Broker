package com.HideoKuzeGits.YndexDirectAutobroker.domain.strategies;

import com.HideoKuzeGits.YndexDirectAutobroker.domain.GoogleAnalytics.AnalyticsGoal;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by root on 18.08.14.
 */
@Entity
public class ConversionStrategy extends ServiceStrategy{



    @OneToMany(fetch = FetchType.EAGER)
    private Set<AnalyticsGoal> goals;

    @NotNull
    @Range(min = 0, max = 15)
    private Double cmax;

    @Transient
    private Set<Long> goalsId;

    public Double getCmax() {
        return cmax;
    }

    public void setCmax(Double cmax) {
        this.cmax = cmax;
    }

    public Set<AnalyticsGoal> getGoals() {
        return goals;
    }

    public void setGoals(Set<AnalyticsGoal> goals) {
        this.goals = goals;
    }

    @Override
    public void setCampaignId(Long campaignID) {
        setId(campaignID);
        super.setCampaignId(campaignID);
    }

    public Set<Long> getGoalsId() {
        return goalsId;
    }

    public void setGoalsId(Set<Long> goalsId) {
        this.goalsId = goalsId;
    }
}
