package com.HideoKuzeGits.YndexDirectAutobroker.strategies.conversion.SimpleStrategy;

import com.HideoKuzeGits.YndexDirectAutobroker.AnalyticsAccount.AnalyticsAccountsDao;
import com.HideoKuzeGits.YndexDirectAutobroker.SessionAttributeWrap;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.strategies.ServiceStrategy;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.strategies.Strategy;
import com.HideoKuzeGits.YndexDirectAutobroker.strategies.WrongStrategyException;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.BannerInfo;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.ShortCampaignInfo;
import com.google.common.collect.ArrayListMultimap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 18.04.14.
 */
//@Component


@Controller
public class ServiceStrategiesController {


    @Autowired
    private SessionAttributeWrap sessionWrap;


    @Autowired
    private AnalyticsAccountsDao directAccountsService;

    @Autowired
    private ServiceStrategiesDao serviceStrategiesDao;

    @RequestMapping(value = "/campaigns", method = RequestMethod.GET)
    public String directAccountCampaigns(ModelMap modelMap) {

        if (sessionWrap.isEmpty())
            return "redirect:/directAccounts";

        ShortCampaignInfo[] campaignsArray = sessionWrap.getApi().getCampaignsList();
        List<ShortCampaignInfo> campaigns = Arrays.asList(campaignsArray);
        ArrayList<ShortCampaignInfo> notActivatedCampaigns = new ArrayList<ShortCampaignInfo>();
        for (ShortCampaignInfo campaign : campaigns) {
            if (campaign.getStatusArchive().equals("No"))
                notActivatedCampaigns.add(campaign);
        }
        modelMap.addAttribute("campaignsList", notActivatedCampaigns);
        String userName = sessionWrap.getAccount().getNormalized_user_name();
        ArrayListMultimap<Object, Strategy> strategiesMap
                = serviceStrategiesDao.getCampaignsStrategy(userName);
        modelMap.addAttribute("strategiesMap", strategiesMap);
        return "campaigns";
    }

    @RequestMapping(value = "/banners", method = RequestMethod.GET)
    public String directAccountBanners(@RequestParam(value = "campaignID") Long campaignID, ModelMap modelMap) {

        if (sessionWrap.isEmpty())
            return "redirect:/directAccounts";

        BannerInfo[] bannersArray = sessionWrap.getApi().getCampaignBanners(new Long[]{campaignID});

        modelMap.addAttribute("banners", bannersArray);
        Map<Long, ServiceStrategy> strategiesMap = serviceStrategiesDao.getBannersStrategy(campaignID);
        modelMap.addAttribute("strategiesMap", strategiesMap);

        return "banners";
    }


    @RequestMapping(value = "/add_tactic", method = RequestMethod.POST)
    @ResponseBody
    public String saveStrategy(@Valid @RequestBody ServiceStrategy strategy,
                               BindingResult bindingResult) {


        if (sessionWrap.isEmpty())
            return "redirect:/accounts";

        if (bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            throw new WrongStrategyException(allErrors.toString());
        }

        if ((strategy.getCampaignId() == null) && (strategy.getBannerId() == null))
            throw new WrongStrategyException("Id not set");

        if ((strategy.getCampaignId() != null) && (strategy.getBannerId() != null))
            throw new WrongStrategyException("Can`t apply strategy on banner and on campaign.");

        strategy.setYndexDirectAccount(sessionWrap.getAccount());
        serviceStrategiesDao.saveStrategy(strategy);

       return "f";
    }


    @RequestMapping(value = "/remove_tactics", method = RequestMethod.POST)
    @ResponseBody
    public String removeTactics(@RequestParam(value = "id") Long id,
                                @RequestParam(value = "type") String type) {


        if (sessionWrap.isEmpty())
            return "redirect:/accounts";


        if (type.equals("campaignBanners"))
            serviceStrategiesDao.removeCampaignBannersStrategy(id);
        else
            serviceStrategiesDao.removeStrategy(id);


        return "";
    }


}
