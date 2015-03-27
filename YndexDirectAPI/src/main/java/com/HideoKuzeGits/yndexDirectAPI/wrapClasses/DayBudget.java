package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

        import javax.annotation.Generated;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class DayBudget {

    @SerializedName("Amount")
    @Expose
    private Double amount;
    @SerializedName("SpendMode")
    @Expose
    private String spendMode;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSpendMode() {
        return spendMode;
    }

    public void setSpendMode(String spendMode) {
        this.spendMode = spendMode;
    }

}