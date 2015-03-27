package com.HideoKuzeGits.YndexDirectAutobroker.SavedMoney;

import com.HideoKuzeGits.YndexDirectAutobroker.UsefulStaticMethods;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.Statistic;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.APIAccounts.YndexDirectAccount;
import com.HideoKuzeGits.yndexDirectAPI.WrongRequestException;
import com.HideoKuzeGits.yndexDirectAPI.YndexDirectAPI;
import com.HideoKuzeGits.yndexDirectAPI.YndexDirectApiFactory;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by root on 12.08.14.
 */
@Service
public class SavedMoneyInfoService {


    @Autowired
    private StatisticsDao statisticsDAO;

    @Autowired
    private YndexDirectApiFactory yndexDirectApiFactory;

    private Map<Long, Map<Long, BannersStatItem>> bannerStatsTree
            = new HashMap<Long, Map<Long, BannersStatItem>>();

    private Statistic statistic;
    public int i = -15;
    private double moneySavedYesterday = 0d;
    private Long updateRatesYesterday = 0l;


    public static void main(String[] args) {


        FileSystemXmlApplicationContext context
                = new FileSystemXmlApplicationContext("//home/hideo/IdeaProjects/YndexDirectAutobroker/src/main/webapp/WEB-INF/spring_hibernate.xml,//home/hideo/IdeaProjects/YndexDirectAutobroker/src/main/webapp/WEB-INF/dispatcher-servlet.xml".split(","));
        SavedMoneyInfoService savedMoneyInfoService = context.getBean(SavedMoneyInfoService.class);
        YndexDirectApiFactory yndexDirectApiFactory = new YndexDirectApiFactory();
        YndexDirectAPI yndexDirectAPI = yndexDirectApiFactory.createSandboxApi();
        ClientInfo[] clientsList = yndexDirectAPI.getClientsList();

        ArrayList<String> logins = new ArrayList<String>();

        for (ClientInfo clientInfo : clientsList) {
            logins.add(clientInfo.getLogin());
        }

        GetBannersInfo getBannersInfo = new GetBannersInfo();
        getBannersInfo.setGetPhrases("WithPrices");


        ShortCampaignInfo[] campaignsList = yndexDirectAPI.getCampaignsList(logins);

        ArrayList<Long> campaignsIds = new ArrayList<Long>();

        int i = 0;
        for (ShortCampaignInfo shortCampaignInfo : campaignsList) {
            campaignsIds.add(shortCampaignInfo.getCampaignID());
            i++;
            if (i == 10)
                break;
        }

        getBannersInfo.setCampaignIDS(campaignsIds);

        BannerInfo[] banners = yndexDirectAPI.getBanners(getBannersInfo);

        for (; savedMoneyInfoService.i < 0; savedMoneyInfoService.i++) {


            for (BannerInfo banner : banners) {
                List<BannerPhraseInfo> phrases = banner.getPhrases();

                for (BannerPhraseInfo phrase : phrases) {

                    savedMoneyInfoService.saveStatistic(new YndexDirectAccount(), 0.30,
                            phrase.getCampaignID(),
                            phrase.getPhraseID());

                }


            }
            savedMoneyInfoService.save();
        }
    }

    public void save() {

        statistic.setMoneySavedYesterday(moneySavedYesterday);
        Double moneySavedAllTime = statistic.getMoneySavedAllTime();

        statistic.setMoneySavedAllTime(moneySavedAllTime + moneySavedYesterday);

        statistic.setUpdateRatesYesterday(updateRatesYesterday);
        Long updateRatesAllTime = statistic.getUpdateRatesAllTime();
        statistic.setUpdateRatesAllTime(updateRatesAllTime + updateRatesYesterday);

        moneySavedYesterday = 0d;
        updateRatesYesterday = 0l;

        statisticsDAO.save(statistic);
        statistic = null;
    }


    public void saveStatistic(YndexDirectAccount yndexDirectAccount,
                              Double positionPrice,
                              Long campaignId,
                              Long phraseId) {

        String yesterdayDateString = UsefulStaticMethods.getYesterdayDateString();
        YndexDirectAPI yndexDirectApi
                = yndexDirectApiFactory.createYndexDirectApi(yndexDirectAccount.getToken());


        if (statistic == null) {
            statistic = statisticsDAO.getStatistic();
            if (statistic == null) {

                statistic = new Statistic();
                statistic.setBeginDate(UsefulStaticMethods.getYesterdayDateString());
            }
        }


        if (!bannerStatsTree.containsKey(campaignId)) {

            HashMap<Long, BannersStatItem> bannersStatItemsMap = new HashMap<Long, BannersStatItem>();
            NewReportInfo newReportInfo
                    = new NewReportInfo(campaignId, yesterdayDateString, yesterdayDateString);

            newReportInfo.setGroupByColumns(new String[]{"clPhrase"});
            newReportInfo.setOrderBy(new String[]{"clPhrase"});

            GetBannersStatResponse bannersStat = null;
            try {
                bannersStat = yndexDirectApi.getBannersStat(newReportInfo);
            } catch (WrongRequestException e) {
                if (e.getMessage().contains("\"error_code\":2"))
                    return;
                else
                    throw e;

            }

            List<BannersStatItem> statItems = bannersStat.getStat();

            for (BannersStatItem statItem : statItems) {
                Long phraseID = statItem.getPhraseID();
                bannersStatItemsMap.put(phraseID, statItem);
            }
            bannerStatsTree.put(campaignId, bannersStatItemsMap);
        }


        BannersStatItem bannersStatItem = bannerStatsTree.get(campaignId).get(phraseId);
        if (bannersStatItem != null)
            addToTheStatistics(bannersStatItem, positionPrice);

        updateRatesYesterday += 24;

    }


    private void addToTheStatistics(BannersStatItem bannersStatItem,
                                    Double positionPrice) {

        Long clicks = bannersStatItem.getClicks();
        Double moneyCanBeSpend = clicks * positionPrice;
        Double moneySpend = bannersStatItem.getSum();
        moneySavedYesterday = moneyCanBeSpend - moneySpend;

    }


    private String getCurrentDateString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }

}
