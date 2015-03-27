package com.HideoKuzeGits.YndexDirectAutobroker.strategies.conversion.ConversionStrategy;

import com.HideoKuzeGits.YndexDirectAutobroker.domain.strategies.Strategy;
import com.HideoKuzeGits.YndexDirectAutobroker.strategies.WrongStrategyException;
import com.HideoKuzeGits.YndexDirectAutobroker.utm.CampaignsWithUtmDao;
import com.HideoKuzeGits.YndexDirectAutobroker.strategies.StrategiesDao;
import com.HideoKuzeGits.YndexDirectAutobroker.SessionAttributeWrap;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.CampaignWithUTM;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.strategies.ConversionStrategy;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.GoogleAnalytics.AnalyticsGoal;
import com.google.common.collect.ArrayListMultimap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by root on 20.08.14.
 */

@Controller
public class ConversionStrategiesController {

    @Autowired
    private SessionAttributeWrap sessionWrap;

    @Autowired
    private StrategiesDao strategiesDao;

    @Autowired
    private CampaignsWithUtmDao campaignsWithUtmDao;

    @RequestMapping(value = "/campaigns_with_utm", method = RequestMethod.GET)
    public String showUTMCampaigns(ModelMap modelMap){

        if (sessionWrap.isEmpty())
            return "redirect:/directAccounts";

        String userName = sessionWrap.getAccount().getNormalized_user_name();
        List<CampaignWithUTM> campaignsList = campaignsWithUtmDao.getCampaigns(userName);
        ArrayListMultimap<Object, Strategy> strategiesMap
                = strategiesDao.getCampaignsStrategy(userName);
        modelMap.put("campaignsList", campaignsList);
        modelMap.put("strategiesMap", strategiesMap);
        return "campaignsWithUtm";
    }

    @RequestMapping(value = "/add_conversion_tactic", method = RequestMethod.POST)
    @ResponseBody
    public String saveStrategy(@Valid @RequestBody ConversionStrategy strategy,
                               BindingResult bindingResult) {

        List<AnalyticsGoal> goalsList = campaignsWithUtmDao.getGoalsList(strategy.getGoalsId());
        HashSet<AnalyticsGoal> goalsSet = new HashSet<AnalyticsGoal>(goalsList);
        strategy.setGoals(goalsSet);


        if (sessionWrap.isEmpty())
            return "redirect:/accounts";

        if (bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            throw new WrongStrategyException(allErrors.toString());
        }

        if (strategy.getCampaignId() == null)
            throw new WrongStrategyException("CampaignID not set");

        if (strategy.getGoals() == null)
            if (strategy.getGoals().isEmpty())
                throw new WrongStrategyException("There is no goals in strategy.");


        strategy.setYndexDirectAccount(sessionWrap.getAccount());
        strategiesDao.saveStrategy(strategy);

        return "f";
    }


}
