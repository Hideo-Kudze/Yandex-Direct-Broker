package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Account extends AbstractWrap{

    @SerializedName("AccountID")
    @Expose
    private Long accountID;
    @SerializedName("Amount")
    @Expose
    private Double amount;
    @SerializedName("AmountAvailableForTransfer")
    @Expose
    private Double amountAvailableForTransfer;
    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("Login")
    @Expose
    private String login;
    @SerializedName("Discount")
    @Expose
    private Double discount;
    @SerializedName("AgencyName")
    @Expose
    private String agencyName;
    @SerializedName("SmsNotification")
    @Expose
    private SmsNotification smsNotification;
    @SerializedName("EmailNotification")
    @Expose
    private EmailNotification emailNotification;

    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmountAvailableForTransfer() {
        return amountAvailableForTransfer;
    }

    public void setAmountAvailableForTransfer(Double amountAvailableForTransfer) {
        this.amountAvailableForTransfer = amountAvailableForTransfer;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public SmsNotification getSmsNotification() {
        return smsNotification;
    }

    public void setSmsNotification(SmsNotification smsNotification) {
        this.smsNotification = smsNotification;
    }

    public EmailNotification getEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(EmailNotification emailNotification) {
        this.emailNotification = emailNotification;
    }

}