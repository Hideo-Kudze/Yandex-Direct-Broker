package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by root on 08.07.14.
 */
public class KeywordResponse extends AbstractWrap {

    @Expose
    private List<KeywordActionResult> ActionsResult;

    public List<KeywordActionResult> getActionsResult() {
        return ActionsResult;
    }

    public void setActionsResult(List<KeywordActionResult> actionsResult) {
        ActionsResult = actionsResult;
    }
}
