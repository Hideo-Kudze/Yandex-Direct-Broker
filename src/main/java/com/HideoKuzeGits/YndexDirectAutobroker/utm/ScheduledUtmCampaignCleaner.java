package com.HideoKuzeGits.YndexDirectAutobroker.utm;

import com.HideoKuzeGits.YndexDirectAutobroker.domain.APIAccounts.YndexDirectAccount;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.CampaignWithUTM;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.GoogleAnalytics.AnalyticsGoal;
import com.HideoKuzeGits.yndexDirectAPI.YndexDirectAPI;
import com.HideoKuzeGits.yndexDirectAPI.YndexDirectApiFactory;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.GetChangesResponse;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static com.HideoKuzeGits.YndexDirectAutobroker.UsefulStaticMethods.getYesterdayDateTimeString;
import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Collections2.transform;

/**
 * Created by root on 15.09.14.
 */

@Service
@EnableScheduling
public class ScheduledUtmCampaignCleaner {

    @Autowired
    private CampaignsWithUtmDao campaignsWithUtmDao;

    @Autowired
    private YndexDirectApiFactory yndexDirectApiFactory;

    @Scheduled(cron = "0 0 0 * * *", zone = "Europe/Moscow")
    public void removeDeletedCampaign() {

        removeGoalsWithoutUtaCampaign();
        List<CampaignWithUTM> campaignList = campaignsWithUtmDao.getAllCampaigns();

        Multimap<String, Long> tokenCampaignWithUtmMultimap = HashMultimap.create();

        for (CampaignWithUTM campaignWithUTM : campaignList) {

            YndexDirectAccount yndexDirectAccount = campaignWithUTM.getYndexDirectAccount();
            String token = yndexDirectAccount.getToken();
            Long campaignId = campaignWithUTM.getCampaignId();
            tokenCampaignWithUtmMultimap.put(token, campaignId);
        }

        for (String token : tokenCampaignWithUtmMultimap.keySet()) {

            YndexDirectAPI yndexDirectApi = yndexDirectApiFactory.createYndexDirectApi(token);

            Collection<Long> campaignIds = tokenCampaignWithUtmMultimap.get(token);
            Long[] campaignIDS = campaignIds.toArray(new Long[campaignIds.size()]);


            GetChangesResponse campaignsParams
                    = yndexDirectApi.getCampaignChanges(campaignIDS, getYesterdayDateTimeString());
            List<Long> notFound = campaignsParams.getCampaigns().getNotFound();
            campaignsWithUtmDao.removeCampaignsWithUtm(notFound);
        }
    }

    private void removeGoalsWithoutUtaCampaign() {

        List<AnalyticsGoal> allGoals = campaignsWithUtmDao.getAllGoals();

        Collection<AnalyticsGoal> analyticsGoalsWithoutCampaign = filter(allGoals, new Predicate<AnalyticsGoal>() {

            @Override
            public boolean apply(@Nullable AnalyticsGoal analyticsGoal) {
                Set<CampaignWithUTM> campaignWithUTMSet = analyticsGoal.getCampaignWithUTMSet();

                if (campaignWithUTMSet == null)
                    return true;

                if (campaignWithUTMSet.isEmpty())
                    return true;

                return false;
            }

        });

        Collection<Long> goalsIds = transform(analyticsGoalsWithoutCampaign, new Function<AnalyticsGoal, Long>() {

            @Nullable
            @Override
            public Long apply(@Nullable AnalyticsGoal goal) {
                return goal.getId();
            }

        });

        if (!goalsIds.isEmpty())
            campaignsWithUtmDao.removeGoals(goalsIds);

    }
}
