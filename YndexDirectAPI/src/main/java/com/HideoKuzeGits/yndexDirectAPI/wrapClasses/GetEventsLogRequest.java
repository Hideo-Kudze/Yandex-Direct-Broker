package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 08.07.14.
 */
public class GetEventsLogRequest extends  AbstractWrap{

    @SerializedName("TimestampFrom")
    @Expose
    private String timestampFrom;

    @SerializedName("TimestampTo")
    @Expose
    private String timestampTo;

    @SerializedName("LastEventOnly")
    @Expose
    private String lastEventOnly;

    @SerializedName("WithTextDescription")
    @Expose
    private String withTextDescription;

    @SerializedName("Currency")
    @Expose
    private String currency;

    @SerializedName("Logins")
    @Expose
    private List<String> logins = new ArrayList<String>();

    @SerializedName("Filter")
    @Expose
    private GetEventsLogFilter filter;

    public GetEventsLogRequest(String timestampFrom) {
        this.timestampFrom = timestampFrom;
    }

    public String getTimestampFrom() {
        return timestampFrom;
    }

    public void setTimestampFrom(String timestampFrom) {
        this.timestampFrom = timestampFrom;
    }

    public String getTimestampTo() {
        return timestampTo;
    }

    public void setTimestampTo(String timestampTo) {
        this.timestampTo = timestampTo;
    }

    public String getLastEventOnly() {
        return lastEventOnly;
    }

    public void setLastEventOnly(String lastEventOnly) {
        this.lastEventOnly = lastEventOnly;
    }

    public String getWithTextDescription() {
        return withTextDescription;
    }

    public void setWithTextDescription(String withTextDescription) {
        this.withTextDescription = withTextDescription;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<String> getLogins() {
        return logins;
    }

    public void setLogins(List<String> logins) {
        this.logins = logins;
    }

    public GetEventsLogFilter getFilter() {
        return filter;
    }

    public void setFilter(GetEventsLogFilter filter) {
        this.filter = filter;
    }
}
