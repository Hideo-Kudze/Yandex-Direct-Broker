package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class TimeTarget {

    @SerializedName("ShowOnHolidays")
    @Expose
    private String showOnHolidays;
    @SerializedName("HolidayShowFrom")
    @Expose
    private Long holidayShowFrom;
    @SerializedName("HolidayShowTo")
    @Expose
    private Long holidayShowTo;
    @SerializedName("DaysHours")
    @Expose
    private List<DaysHour> daysHours = new ArrayList<DaysHour>();
    @SerializedName("TimeZone")
    @Expose
    private String timeZone;
    @SerializedName("WorkingHolidays")
    @Expose
    private String workingHolidays;

    public String getShowOnHolidays() {
        return showOnHolidays;
    }

    public void setShowOnHolidays(String showOnHolidays) {
        this.showOnHolidays = showOnHolidays;
    }

    public Long getHolidayShowFrom() {
        return holidayShowFrom;
    }

    public void setHolidayShowFrom(Long holidayShowFrom) {
        this.holidayShowFrom = holidayShowFrom;
    }

    public Long getHolidayShowTo() {
        return holidayShowTo;
    }

    public void setHolidayShowTo(Long holidayShowTo) {
        this.holidayShowTo = holidayShowTo;
    }

    public List<DaysHour> getDaysHours() {
        return daysHours;
    }

    public void setDaysHours(List<DaysHour> daysHours) {
        this.daysHours = daysHours;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getWorkingHolidays() {
        return workingHolidays;
    }

    public void setWorkingHolidays(String workingHolidays) {
        this.workingHolidays = workingHolidays;
    }

}