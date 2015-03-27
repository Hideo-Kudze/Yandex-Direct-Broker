package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 05.07.14.
 */
public class ReportInfo extends AbstractWrap{

    @SerializedName("ReportID")
    @Expose
    private Long reportID;

    @SerializedName("Url")
    @Expose
    private String url;

    @SerializedName("StatusReport")
    @Expose
    private String statusReport;

    public Long getReportID() {
        return reportID;
    }

    public void setReportID(Long reportID) {
        this.reportID = reportID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatusReport() {
        return statusReport;
    }

    public void setStatusReport(String statusReport) {
        this.statusReport = statusReport;
    }
}
