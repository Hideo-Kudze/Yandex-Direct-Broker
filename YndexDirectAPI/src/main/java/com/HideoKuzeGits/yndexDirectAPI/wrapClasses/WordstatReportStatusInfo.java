package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 07.07.14.
 */
public class WordstatReportStatusInfo extends AbstractWrap{

    @SerializedName("ReportID")
    @Expose
    private Long ReportID;

    @SerializedName("StatusReport")
    @Expose
    private String statusReport;

    public Long getReportID() {
        return ReportID;
    }

    public void setReportID(Long reportID) {
        ReportID = reportID;
    }

    public String getStatusReport() {
        return statusReport;
    }

    public void setStatusReport(String statusReport) {
        this.statusReport = statusReport;
    }
}
