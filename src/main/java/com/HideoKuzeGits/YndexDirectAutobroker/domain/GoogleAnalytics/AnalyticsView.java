package com.HideoKuzeGits.YndexDirectAutobroker.domain.GoogleAnalytics;

import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.AbstractWrap;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by root on 26.08.14.
 */

@Entity
public class AnalyticsView extends AbstractWrap{

    @Id
    private String viewId;
    private String name;

    public AnalyticsView() {
    }

    public AnalyticsView(String viewId, String name) {
        this.viewId = viewId;
        this.name = name;
    }

    public String getViewId() {
        return viewId;
    }

    public void setViewId(String viewId) {
        this.viewId = viewId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
