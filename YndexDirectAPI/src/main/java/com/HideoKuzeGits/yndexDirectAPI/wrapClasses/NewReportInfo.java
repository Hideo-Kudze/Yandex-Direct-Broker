package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



/**
 * Created by root on 05.07.14.
 */
public class NewReportInfo extends AbstractWrap {

    @SerializedName("CampaignID")
    @Expose
    private Long campaignID;

    @SerializedName("StartDate")
    @Expose
    private String startDate;

    @SerializedName("EndDate")
    @Expose
    private String endDate;

    @SerializedName("GroupByColumns")
    @Expose
    private String[] groupByColumns;

    @SerializedName("Limit")
    @Expose
    private Long limit;

    @SerializedName("Offset")
    @Expose
    private Long offset;

    @SerializedName("GroupByDate")
    @Expose
    private String groupByDate;

    @SerializedName("OrderBy")
    @Expose
    private String[] orderBy;

    @SerializedName("TypeResultReport")
    @Expose
    private String typeResultReport;


    @SerializedName("CompressReport")
    @Expose
    private Long compressReport;


    @SerializedName("Filter")
    @Expose
    private NewReportFilterInfo filter;


    @SerializedName("Currency")
    @Expose
    private String currency;


    @SerializedName("includeVAT")
    @Expose
    private String includeVAT;


    @SerializedName("IncludeDiscount")
    @Expose
    private String includeDiscount;


    public NewReportInfo(Long campaignID, String startDate, String endDate) {
        this.campaignID = campaignID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public NewReportInfo(Long campaignID, String startDate, String endDate, Long limit, String typeResultReport) {
        this.campaignID = campaignID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.limit = limit;
        this.typeResultReport = typeResultReport;
    }

    public Long getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(Long campaignID) {
        this.campaignID = campaignID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String[] getGroupByColumns() {
        return groupByColumns;
    }

    public void setGroupByColumns(String[] groupByColumns) {
        this.groupByColumns = groupByColumns;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public String getGroupByDate() {
        return groupByDate;
    }

    public void setGroupByDate(String groupByDate) {
        this.groupByDate = groupByDate;
    }

    public String[] getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String[] orderBy) {
        this.orderBy = orderBy;
    }

    public String getTypeResultReport() {
        return typeResultReport;
    }

    public void setTypeResultReport(String typeResultReport) {
        this.typeResultReport = typeResultReport;
    }

    public Long getCompressReport() {
        return compressReport;
    }

    public void setCompressReport(Long compressReport) {
        this.compressReport = compressReport;
    }

    public NewReportFilterInfo getFilter() {
        return filter;
    }

    public void setFilter(NewReportFilterInfo filter) {
        this.filter = filter;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getIncludeVAT() {
        return includeVAT;
    }

    public void setIncludeVAT(String includeVAT) {
        this.includeVAT = includeVAT;
    }

    public String getIncludeDiscount() {
        return includeDiscount;
    }

    public void setIncludeDiscount(String includeDiscount) {
        this.includeDiscount = includeDiscount;
    }
}
