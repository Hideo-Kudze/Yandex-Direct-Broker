package com.HideoKuzeGits.YndexDirectAutobroker.strategies.conversion;



import com.HideoKuzeGits.YndexDirectAutobroker.AnalyticsAccount.AnalyticsAccountsDao;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.GoogleAnalytics.AnalyticsView;
import com.HideoKuzeGits.YndexDirectAutobroker.utm.CampaignsWithUtmDao;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.CampaignWithUTM;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.GoogleAnalytics.AnalyticsAccount;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.GoogleAnalytics.AnalyticsGoal;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.GoogleAnalytics.AnalyticsWebproperty;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.APIAccounts.GoogleAnalyticsAccount;
import com.HideoKuzeGits.YndexDirectAutobroker.utm.ScheduledUtmCampaignCleaner;
import com.HideoKuzeGits.yndexDirectAPI.YndexDirectAPI;
import com.HideoKuzeGits.yndexDirectAPI.YndexDirectApiFactory;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.BannerInfo;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.GetBannersInfo;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.analytics.Analytics;
import com.google.api.services.analytics.model.*;
import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import static com.google.common.collect.Collections2.*;
import static com.google.common.collect.Sets.*;


/**
 * Created by root on 14.08.14.
 */
@Service
public class CampaignsGoalsWireService {

    @Autowired
    private AnalyticsAccountsDao analyticsAccountsDao;

    @Autowired
    private CampaignsWithUtmDao campaignsWithUtmDao;

    @Autowired
    private YndexDirectApiFactory yndexDirectApiFactory;

    @Autowired
    private ScheduledUtmCampaignCleaner utmCampaignCleaner;


    public static void main(String[] args) throws IOException {

     /*   FileSystemXmlApplicationContext context
                = new FileSystemXmlApplicationContext("//home/hideo/IdeaProjects/YndexDirectAutobroker/src/main/webapp/WEB-INF/spring_hibernate.xml,//home/hideo/IdeaProjects/YndexDirectAutobroker/src/main/webapp/WEB-INF/dispatcher-servlet.xml".split(","));

        StrategiesDao strategiesDao = context.getBean(StrategiesDao.class);

        ANYStrategy anyStrategy = new ANYStrategy();
        anyStrategy.setCmax(222d);
        anyStrategy.setId(35l);
        anyStrategy.setBannerId(12l);
        anyStrategy.setCampaignId(10163185l);

        strategiesDao.saveStrategy(anyStrategy);*/

    }

    public void refreshWire() throws IOException {

        List<AnalyticsGoal> goalList = getGoalsList();
        utmCampaignCleaner.removeDeletedCampaign();
        List<CampaignWithUTM> campaignWithUTMs = campaignsWithUtmDao.getAllCampaigns();

        for (CampaignWithUTM campaignWithUTM : campaignWithUTMs) {
            addGoalsToCampaign(campaignWithUTM, goalList);
            campaignsWithUtmDao.saveCampaignWithUtm(campaignWithUTM);
        }

    }

    private List<AnalyticsGoal> getGoalsList() throws IOException {
        List<GoogleAnalyticsAccount> googleAnalyticsAccounts = analyticsAccountsDao.getAccounts();
        List<AnalyticsGoal> goalsList = new ArrayList<AnalyticsGoal>();

        for (GoogleAnalyticsAccount googleAnalyticsAccount : googleAnalyticsAccounts) {
            Analytics analytic = googleAnalyticsAccount.getAnalytics();
            try {

                Map<String, AnalyticsAccount> accountsMap = getAccountsMap(analytic);
                Map<String, AnalyticsWebproperty> webPropertiesMap = getWebPropertiesMap(analytic);
                Map<String, AnalyticsView> viewMap = getViewMap(analytic);

                List<AnalyticsGoal> goals = getGoalsList(googleAnalyticsAccount,
                        analytic,
                        accountsMap,
                        webPropertiesMap,
                        viewMap);

                goalsList.addAll(goals);

            } catch (GoogleJsonResponseException e) {
                //If the error is due to the fact that the googleAnalyticsAccount does not have the elements we mute her.
                boolean isErrorCauseEmptyAccount = e.getDetails().getMessage().contains("User does not have any Google Analytics googleAnalyticsAccount.");
                if (!isErrorCauseEmptyAccount)
                    throw e;
            }
        }
        return goalsList;
    }


    private Map<String, AnalyticsAccount> getAccountsMap(Analytics analytic) throws IOException {

        Map<String, AnalyticsAccount> accountsMap = new HashMap<String, AnalyticsAccount>();

        Accounts accounts = analytic.management().accounts().list().execute();
        for (Account account : accounts.getItems()) {
            String id = account.getId();
            String name = account.getName();
            AnalyticsAccount analyticsAccount = new AnalyticsAccount(id, name);
            accountsMap.put(id, analyticsAccount);
        }
        return accountsMap;
    }

    private Map<String, AnalyticsWebproperty> getWebPropertiesMap(Analytics analytic) throws IOException {

        Map<String, AnalyticsWebproperty> webPropertiesMap = new HashMap<String, AnalyticsWebproperty>();

        Webproperties webproperties = analytic.management().webproperties().list("~all").execute();
        for (Webproperty webproperty : webproperties.getItems()) {
            String id = webproperty.getId();
            String name = webproperty.getName();

            String websiteUrl = webproperty.getWebsiteUrl();
            String host = getHost(websiteUrl);
            AnalyticsWebproperty analyticsWebproperty = new AnalyticsWebproperty(id, name, host);
            webPropertiesMap.put(id, analyticsWebproperty);
        }
        return webPropertiesMap;
    }

    private Map<String, AnalyticsView> getViewMap(Analytics analytic) throws IOException {

        Map<String, AnalyticsView> webViewsMap = new HashMap<String, AnalyticsView>();

        Profiles views = analytic.management().profiles().list("~all", "~all").execute();
        for (Profile view : views.getItems()) {
            String id = view.getId();
            String name = view.getName();

            AnalyticsView analyticsView = new AnalyticsView(id, name);
            webViewsMap.put(id, analyticsView);
        }
        return webViewsMap;
    }


    private List<AnalyticsGoal>
    getGoalsList(GoogleAnalyticsAccount googleAnalyticsAccount,
                 Analytics analytic,
                 Map<String, AnalyticsAccount> accountsMap,
                 Map<String, AnalyticsWebproperty> webPropertiesMap,
                 Map<String, AnalyticsView> viewMap ) throws IOException {

        List<AnalyticsGoal> goalsList = new ArrayList<AnalyticsGoal>();

        Goals goals = analytic.management().goals().list("~all", "~all", "~all").execute();
        for (Goal goal : goals.getItems()) {

            String id = goal.getId();
            String name = goal.getName();
            String accountId = goal.getAccountId();
            String webPropertyId = goal.getWebPropertyId();
            String profileId = goal.getProfileId();
            String dateOfCreating = goal.getCreated().toString().substring(0, 10);

            AnalyticsAccount analyticsAccount = accountsMap.get(accountId);
            AnalyticsWebproperty analyticsWebproperty = webPropertiesMap.get(webPropertyId);
            AnalyticsView analyticsView = viewMap.get(profileId);


            AnalyticsGoal analyticsGoal = new AnalyticsGoal(id, name);
            analyticsGoal.setGoogleAnalyticsAccount(googleAnalyticsAccount);
            analyticsGoal.setAccount(analyticsAccount);
            analyticsGoal.setWebproperty(analyticsWebproperty);
            analyticsGoal.setView(analyticsView);
            analyticsGoal.setDateOfCreating(dateOfCreating);

            goalsList.add(analyticsGoal);
        }

        return goalsList;
    }

    public void addGoalsToCampaign(CampaignWithUTM campaignWithUTM) throws IOException {
        List<AnalyticsGoal> goalsList = getGoalsList();
        addGoalsToCampaign(campaignWithUTM, goalsList);
    }

    private void addGoalsToCampaign(CampaignWithUTM campaignWithUTM, List<AnalyticsGoal> goalsList) throws MalformedURLException {

        final String campaignHost = getCampaignHost(campaignWithUTM);

        Predicate<AnalyticsGoal> predicate = new Predicate<AnalyticsGoal>() {

            @Override
            public boolean apply(@Nullable AnalyticsGoal analyticsGoal) {
                return analyticsGoal.getWebproperty().getHost().equals(campaignHost);
            }

        };

        Set<AnalyticsGoal> campaignGoalsList = newHashSet(filter(goalsList, predicate));
        campaignWithUTM.setGoalsSet(campaignGoalsList);

    }

    private String getCampaignHost(CampaignWithUTM campaignWithUTM) throws MalformedURLException {
        String token = campaignWithUTM.getYndexDirectAccount().getToken();
        YndexDirectAPI yndexDirectApi = yndexDirectApiFactory.createYndexDirectApi(token);
        GetBannersInfo getBannersInfo = new GetBannersInfo();
        Long campaignId = campaignWithUTM.getCampaignId();
        getBannersInfo.setCampaignIDS(Arrays.asList(campaignId));
        getBannersInfo.setLimit(1l);
        BannerInfo bannerInfo = yndexDirectApi.getBanners(getBannersInfo)[0];
        String href = bannerInfo.getHref();
        return getHost(href);
    }

    private String getHost(String websiteUrl) throws MalformedURLException {

        if (!websiteUrl.startsWith("http://"))
            websiteUrl = "http://" + websiteUrl;

        String host = new URL(websiteUrl).getHost();
        if (host.startsWith("www."))
            host = host.replaceFirst("www\\.", "");
        return host;
    }

}
