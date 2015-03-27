package com.HideoKuzeGits.YndexDirectAutobroker;

import com.HideoKuzeGits.yndexDirectAPI.AuthorizationErrorHandler;
import org.springframework.stereotype.Component;

/**
 * Created by root on 09.08.14.
 */
//@Component
public class AuthorizationErrorHandlerImpl implements AuthorizationErrorHandler {

    @Override
    public void handleAuthorizationError(String token) {
        System.out.println("AAAAAAAAAAAAAAAA");
    }
}
