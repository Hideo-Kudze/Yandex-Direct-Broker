package com.HideoKuzeGits.YndexDirectAutobroker;

import com.HideoKuzeGits.YndexDirectAutobroker.domain.APIAccounts.YndexDirectAccount;
import com.HideoKuzeGits.yndexDirectAPI.YndexDirectAPI;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Created by root on 28.07.14.
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionAttributeWrap {

    private YndexDirectAPI api;
    private YndexDirectAccount account;

    public YndexDirectAPI getApi() {
        return api;
    }

    public void setApi(YndexDirectAPI api) {
        this.api = api;
    }

    public YndexDirectAccount getAccount() {
        return account;
    }

    public void setAccount(YndexDirectAccount account) {
        this.account = account;
    }

    public boolean isEmpty() {
        return account == null;
    }
}
