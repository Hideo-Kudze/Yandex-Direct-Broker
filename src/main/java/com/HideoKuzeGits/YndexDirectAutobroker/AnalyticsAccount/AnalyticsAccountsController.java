package com.HideoKuzeGits.YndexDirectAutobroker.AnalyticsAccount;


import com.HideoKuzeGits.YndexDirectAutobroker.domain.APIAccounts.GoogleAnalyticsAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;


/**
 * Created by root on 07.08.14.
 */

@Controller
public class AnalyticsAccountsController  {

    @Autowired
    private AnalyticsAccountsDao analyticsAccountsDao;



    @RequestMapping(value = "/analyticsAccounts", method = RequestMethod.GET)
    public String showAccounts(ModelMap modelMap) {
        List<GoogleAnalyticsAccount> analyticsAccounts = analyticsAccountsDao.getAccounts();
        modelMap.put("analyticsAccounts", analyticsAccounts);
        modelMap.put("authorizationUrl", AnalyticsAccountsDao.AUTHORIZATION_URL);
        return "analyticsAccounts";
    }

    @RequestMapping(value = "/addAnalyticsAccount", method = RequestMethod.GET)
    public String saveAccount(@RequestParam(value = "code") String code) {
        try {
            analyticsAccountsDao.saveAccount(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/analyticsAccounts";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(String code) {
        return "";
    }

}
