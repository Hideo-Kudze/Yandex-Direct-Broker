package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.Gson;

/**
 * Created by root on 25.06.14.
 */
public abstract class AbstractWrap {
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
