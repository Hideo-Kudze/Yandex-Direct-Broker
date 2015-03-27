package com.HideoKuzeGits.YndexDirectAutobroker.domain.GoogleAnalytics;

import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.AbstractWrap;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by root on 14.08.14.
 */
@Entity
public class AnalyticsWebproperty extends AbstractWrap {

    @Id
    private String webpropertyId;

    private String name;
    private String host;

    public AnalyticsWebproperty() {
    }

    public AnalyticsWebproperty(String webpropertyId, String name, String host) {
        this.webpropertyId = webpropertyId;
        this.name = name;
        this.host = host;
    }

    public String getWebpropertyId() {
        return webpropertyId;
    }

    public void setWebpropertyId(String webpropertyId) {
        this.webpropertyId = webpropertyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
