package com.HideoKuzeGits.YndexDirectAutobroker.domain.strategies;

import com.HideoKuzeGits.YndexDirectAutobroker.domain.APIAccounts.YndexDirectAccount;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.GoogleAnalytics.AnalyticsGoal;


import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
public class ANYStrategy extends Strategy {



    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AnalyticsGoal> goals;

    @NotNull
    @Range(min = 0, max = 15)
    private Double cmax;

    @Transient
    private Set<Long> goalsId;

    public Set<AnalyticsGoal> getGoals() {
        return goals;
    }

    public void setGoals(Set<AnalyticsGoal> goals) {
        this.goals = goals;
    }

    public Double getCmax() {
        return cmax;
    }

    public void setCmax(Double cmax) {
        this.cmax = cmax;
    }

    public Set<Long> getGoalsId() {
        return goalsId;
    }

    public void setGoalsId(Set<Long> goalsId) {
        this.goalsId = goalsId;
    }


}
