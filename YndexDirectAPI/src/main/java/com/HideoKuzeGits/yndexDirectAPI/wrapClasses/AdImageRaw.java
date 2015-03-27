package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;

/**
 * Created by root on 08.07.14.
 */
public class AdImageRaw {

    public AdImageRaw() {
    }

    public AdImageRaw(String name, String rawData) {
        Name = name;
        RawData = rawData;
    }

    @Expose
    private String Login;

    @Expose
    private String RawData;

    @Expose
    private String Name;

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getRawData() {
        return RawData;
    }

    public void setRawData(String rawData) {
        RawData = rawData;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
