package com.HideoKuzeGits.YndexDirectAutobroker.domain;

import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.AbstractWrap;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by root on 13.08.14.
 */
@Entity
public class Statistic extends AbstractWrap implements Serializable {

    @Id
    private String accountName = "testUniqueAccount";

    private String beginDate;

    private Double moneySavedAllTime = 0d;
    private Long updateRatesAllTime = 0l;

    private Double moneySavedYesterday;
    private Long updateRatesYesterday;


    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public Double getMoneySavedAllTime() {
        return moneySavedAllTime;
    }

    public void setMoneySavedAllTime(Double moneySavedAllTime) {
        this.moneySavedAllTime = moneySavedAllTime;
    }

    public Long getUpdateRatesAllTime() {
        return updateRatesAllTime;
    }

    public void setUpdateRatesAllTime(Long updateRatesAllTime) {
        this.updateRatesAllTime = updateRatesAllTime;
    }

    public Double getMoneySavedYesterday() {
        return moneySavedYesterday;
    }

    public void setMoneySavedYesterday(Double moneySavedYesterday) {
        this.moneySavedYesterday = moneySavedYesterday;
    }

    public Long getUpdateRatesYesterday() {
        return updateRatesYesterday;
    }

    public void setUpdateRatesYesterday(Long updateRatesYesterday) {
        this.updateRatesYesterday = updateRatesYesterday;
    }
}
