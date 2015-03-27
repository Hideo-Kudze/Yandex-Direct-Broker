package com.HideoKuzeGits.YndexDirectAutobroker.strategies.conversion.ANYStrategy;

import com.HideoKuzeGits.YndexDirectAutobroker.SessionAttributeWrap;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.strategies.ANYStrategy;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.CampaignWithUTM;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.GoogleAnalytics.AnalyticsGoal;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.strategies.Strategy;
import com.HideoKuzeGits.YndexDirectAutobroker.strategies.WrongStrategyException;
import com.HideoKuzeGits.YndexDirectAutobroker.utm.CampaignsWithUtmDao;
import com.google.common.collect.ArrayListMultimap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by root on 20.08.14.
 */

@Controller
public class ANYStrategiesController {

    @Autowired
    private SessionAttributeWrap sessionWrap;

    @Autowired
    private ANYStrategiesDao anyStrategiesDao;

    @Autowired
    private CampaignsWithUtmDao campaignsWithUtmDao;

    @RequestMapping(value = "/ANY_strategies", method = RequestMethod.GET)
    public String showUTMCampaigns(ModelMap modelMap){

        if (sessionWrap.isEmpty())
            return "redirect:/directAccounts";

        String userName = sessionWrap.getAccount().getNormalized_user_name();
        List<CampaignWithUTM> campaignsList = campaignsWithUtmDao.getCampaigns(userName);
        ArrayListMultimap<Object, Strategy> strategiesMap = anyStrategiesDao.getCampaignsStrategy(userName);
        modelMap.put("campaignsList", campaignsList);
        modelMap.put("strategiesMap", strategiesMap);
        return "ANYStrategies";
    }

    @RequestMapping(value = "/add_ANY_tactic", method = RequestMethod.POST)
    @ResponseBody
    public String saveStrategy(@RequestBody ANYStrategy strategy,
                               BindingResult bindingResult) {

        List<AnalyticsGoal> goalsList = campaignsWithUtmDao.getGoalsList(strategy.getGoalsId());
        HashSet<AnalyticsGoal> goalsSet = new HashSet<AnalyticsGoal>(goalsList);
        strategy.setGoals(goalsSet);

        if (sessionWrap.isEmpty())
            return "redirect:/accounts";

        if (strategy.getId() == null)
            throw new WrongStrategyException("CampaignID not set");

        if (strategy.getGoals() == null)
            if (strategy.getGoals().isEmpty())
                throw new WrongStrategyException("There is no goals in strategy.");

        Double cmax = strategy.getCmax();
        if (cmax == null)
            if (cmax > 0 && cmax < 5)
                throw new WrongStrategyException("There is no goals in strategy.");


        strategy.setYndexDirectAccount(sessionWrap.getAccount());
        anyStrategiesDao.saveStrategy(strategy);

        return "f";
    }

    @RequestMapping(value = "/removeAnyStrategy", method = RequestMethod.POST)
    @ResponseBody
    public String removeAnyStrategy(@RequestParam(value = "id") Long id) {


        if (sessionWrap.isEmpty())
            return "redirect:/accounts";

        anyStrategiesDao.removeStrategy(id);


        return "";
    }


}
