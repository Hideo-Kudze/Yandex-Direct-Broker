package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by root on 08.07.14.
 */
public class AdImageURL {

    @Expose
    private String Login;

    @Expose
    private String URL;

    @Expose
    private String Name;

    public AdImageURL(String name, String URL) {
        this.URL = URL;
        Name = name;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).
                append(URL).
                append(Login).
                toHashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof AdImageURL))
            return false;
        if (obj == this)
            return true;

        AdImageURL rhs = (AdImageURL) obj;
        return new EqualsBuilder().
                append(URL, rhs.URL).
                append(Login, rhs.Login).
                isEquals();
    }
}
