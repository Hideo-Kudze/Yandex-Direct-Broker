package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ClientInfo extends AbstractWrap{

    public ClientInfo() {
    }

    public ClientInfo(String login, String phone, String fIO, String email) {
        this.login = login;
        this.phone = phone;
        this.fIO = fIO;
        this.email = email;
    }

    @SerializedName("Login")
    @Expose
    private String login;
    @SerializedName("DateCreate")
    @Expose
    private String dateCreate;
    @SerializedName("Phone")
    @Expose
    private String phone;
    @SerializedName("FIO")
    @Expose
    private String fIO;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("StatusArch")
    @Expose
    private String statusArch;
    @SerializedName("SharedAccountEnabled")
    @Expose
    private String sharedAccountEnabled;
    @SerializedName("Discount")
    @Expose
    private Double discount;
    @SerializedName("OverdraftSumAvailable")
    @Expose
    private Double overdraftSumAvailable;
    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("ClientCurrencies")
    @Expose
    private List<String> clientCurrencies = new ArrayList<String>();
    @SerializedName("VATRate")
    @Expose
    private Double vATRate;
    @SerializedName("SmsPhone")
    @Expose
    private String smsPhone;
    @SerializedName("CampaignEmails")
    @Expose
    private List<String> campaignEmails = new ArrayList<String>();
    @SerializedName("ClientRights")
    @Expose
    private List<ClientRight> clientRights = new ArrayList<ClientRight>();
    @SerializedName("Role")
    @Expose
    private String role;
    @SerializedName("NonResident")
    @Expose
    private String nonResident;
    @SerializedName("SendNews")
    @Expose
    private String sendNews;
    @SerializedName("SendAccNews")
    @Expose
    private String sendAccNews;
    @SerializedName("SendWarn")
    @Expose
    private String sendWarn;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFIO() {
        return fIO;
    }

    public void setFIO(String fIO) {
        this.fIO = fIO;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatusArch() {
        return statusArch;
    }

    public void setStatusArch(String statusArch) {
        this.statusArch = statusArch;
    }

    public String getSharedAccountEnabled() {
        return sharedAccountEnabled;
    }

    public void setSharedAccountEnabled(String sharedAccountEnabled) {
        this.sharedAccountEnabled = sharedAccountEnabled;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getOverdraftSumAvailable() {
        return overdraftSumAvailable;
    }

    public void setOverdraftSumAvailable(Double overdraftSumAvailable) {
        this.overdraftSumAvailable = overdraftSumAvailable;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<String> getClientCurrencies() {
        return clientCurrencies;
    }

    public void setClientCurrencies(List<String> clientCurrencies) {
        this.clientCurrencies = clientCurrencies;
    }

    public Double getVATRate() {
        return vATRate;
    }

    public void setVATRate(Double vATRate) {
        this.vATRate = vATRate;
    }

    public String getSmsPhone() {
        return smsPhone;
    }

    public void setSmsPhone(String smsPhone) {
        this.smsPhone = smsPhone;
    }

    public List<String> getCampaignEmails() {
        return campaignEmails;
    }

    public void setCampaignEmails(List<String> campaignEmails) {
        this.campaignEmails = campaignEmails;
    }

    public List<ClientRight> getClientRights() {
        return clientRights;
    }

    public void setClientRights(List<ClientRight> clientRights) {
        this.clientRights = clientRights;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNonResident() {
        return nonResident;
    }

    public void setNonResident(String nonResident) {
        this.nonResident = nonResident;
    }

    public String getSendNews() {
        return sendNews;
    }

    public void setSendNews(String sendNews) {
        this.sendNews = sendNews;
    }

    public String getSendAccNews() {
        return sendAccNews;
    }

    public void setSendAccNews(String sendAccNews) {
        this.sendAccNews = sendAccNews;
    }

    public String getSendWarn() {
        return sendWarn;
    }

    public void setSendWarn(String sendWarn) {
        this.sendWarn = sendWarn;
    }

}