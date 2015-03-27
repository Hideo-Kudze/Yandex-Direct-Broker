package com.HideoKuzeGits.YndexDirectAutobroker.DirectAccount;

import com.HideoKuzeGits.YndexDirectAutobroker.SavedMoney.StatisticsDao;
import com.HideoKuzeGits.YndexDirectAutobroker.SessionAttributeWrap;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.Statistic;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.APIAccounts.YndexDirectAccount;
import com.HideoKuzeGits.yndexDirectAPI.YndexDirectAPI;
import com.HideoKuzeGits.yndexDirectAPI.YndexDirectApiFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

/**
 * Created by root on 28.07.14.
*/

@Controller
public class DirectAccountsController  {

    @Autowired
    private SessionAttributeWrap sessionWrap;


    @Autowired
    private YndexDirectApiFactory yndexDirectApiFactory;

    @Autowired
    private DirectAccountsService directAccountsService;

    @Autowired
    private StatisticsDao statisticsDAO;


    @RequestMapping(value = "/directAccounts", method = RequestMethod.GET)
    public String showAccounts(ModelMap modelMap) {
        List<YndexDirectAccount> directAccounts = directAccountsService.getAccounts();
        modelMap.addAttribute("directAccounts", directAccounts);
        Statistic statistic = statisticsDAO.getStatistic();
        modelMap.put("statistic",statistic);
        return "directAccounts";
    }

    @RequestMapping(value = "/directAccount", method = RequestMethod.GET)
    public String showAccount(@RequestParam(value = "user_name") String userName, ModelMap modelMap) {
        YndexDirectAccount yndexDirectAccount = directAccountsService.getAccount(userName);
        sessionWrap.setAccount(yndexDirectAccount);
        String token = yndexDirectAccount.getToken();
        String masterToken = yndexDirectAccount.getMasterToken();
        YndexDirectAPI yndexDirectApi = yndexDirectApiFactory.createYndexDirectApi(token, masterToken);
        sessionWrap.setApi(yndexDirectApi);
        return "redirect:/campaigns";
    }


    @RequestMapping(value = "/saveUser", method = RequestMethod.GET)
    public String saveAccount(@RequestParam(value = "code") String code,
                              @RequestParam(value = "state") String userName) {
        try {
            YndexDirectAccount yndexDirectAccount = directAccountsService.saveAccount(code, userName);
            sessionWrap.setAccount(yndexDirectAccount);
            String token = yndexDirectAccount.getToken();
            YndexDirectAPI yndexDirectApi = yndexDirectApiFactory.createYndexDirectApi(token);
            sessionWrap.setApi(yndexDirectApi);
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:/campaigns";
    }
}
