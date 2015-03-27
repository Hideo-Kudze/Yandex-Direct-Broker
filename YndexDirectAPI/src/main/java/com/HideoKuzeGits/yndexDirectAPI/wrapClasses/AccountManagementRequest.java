package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class AccountManagementRequest {

    @SerializedName("Action")
    @Expose
    private String action;
    @SerializedName("Payments")
    @Expose
    private List<Payment> payments = new ArrayList<Payment>();
    @SerializedName("Transfers")
    @Expose
    private List<Transfer> transfers = new ArrayList<Transfer>();
    @SerializedName("SelectionCriteria")
    @Expose
    private AccountSelectionCriteria selectionCriteria;
    @SerializedName("APIAccounts")
    @Expose
    private List<Account> accounts = new ArrayList<Account>();

    public AccountManagementRequest(String action, List paymentsOrTransfersOrAccaunts) {
        this.action = action;

        Class<? extends Payment> clazz = payments.get(0).getClass();
        if (clazz.equals(Payment.class))
            this.payments = paymentsOrTransfersOrAccaunts;
        else if (clazz.equals(Transfer.class))
            this.transfers = paymentsOrTransfersOrAccaunts;
        else
            this.accounts = paymentsOrTransfersOrAccaunts;
    }

    public AccountManagementRequest(String action, AccountSelectionCriteria selectionCriteria) {
        this.action = action;
        this.selectionCriteria = selectionCriteria;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    public AccountSelectionCriteria getSelectionCriteria() {
        return selectionCriteria;
    }

    public void setSelectionCriteria(AccountSelectionCriteria selectionCriteria) {
        this.selectionCriteria = selectionCriteria;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

}