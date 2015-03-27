package com.HideoKuzeGits.YndexDirectAutobroker.strategies.conversion.SimpleStrategy;

import com.HideoKuzeGits.YndexDirectAutobroker.SavedMoney.SavedMoneyInfoService;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.strategies.ServiceStrategy;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.APIAccounts.YndexDirectAccount;
import com.HideoKuzeGits.YndexDirectAutobroker.strategies.Position;
import com.HideoKuzeGits.YndexDirectAutobroker.strategies.StrategiesDao;
import com.HideoKuzeGits.yndexDirectAPI.WrongRequestException;
import com.HideoKuzeGits.yndexDirectAPI.YndexDirectAPI;
import com.HideoKuzeGits.yndexDirectAPI.YndexDirectApiFactory;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.*;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.servlet.jsp.tagext.TagSupport;
import java.util.*;

import static com.HideoKuzeGits.YndexDirectAutobroker.strategies.Position.*;


/**
 * Created by root on 24.07.14.
 */

@EnableScheduling
@Service
public class ScheduledStrategyExecutor {

    @Autowired
    private SavedMoneyInfoService savedMoneyInfoService;

    @Autowired
    protected StrategiesDao strategiesDao;


    @Autowired
    private YndexDirectApiFactory yndexDirectApiFactory;


    public static final int CHANGES_NUM = 24;
    public static final Double MIN_AVALIBLE_PRICE = 0.30;

    private List<PhrasePriceInfo> phrasePriceInfoList = new ArrayList<PhrasePriceInfo>();
    private boolean flag = false;
    private YndexDirectAccount yndexDirectAccount;
    private List<Long> strategiesIds = new ArrayList<Long>();




    @Scheduled(cron = "0 0 1 * * *", zone = "Europe/Moscow")
    private void resetFlag() {
        flag = true;
    }


    @Scheduled(fixedDelay = 1000 * 60 * 60)
    protected void executeAllStrategies() {
        List<ServiceStrategy> strategiesList = strategiesDao.getAllStrategies(ServiceStrategy.class);
        executeStrategies(strategiesList);
    }


    protected void executeStrategies(List<? extends ServiceStrategy> strategiesList) {

        //Get strategies from database and int aray of it`s ids.


        for (ServiceStrategy strategy : strategiesList) {
            strategiesIds.add(strategy.getId());
        }


        //iterate over strategies.
        for (ServiceStrategy serviceStrategy : strategiesList) {
            yndexDirectAccount = serviceStrategy.getYndexDirectAccount();
            String token = yndexDirectAccount.getToken();
            YndexDirectAPI yndexDirectAPI = yndexDirectApiFactory.createYndexDirectApi(token);

            Long campaignId = serviceStrategy.getCampaignId();
            CampaignInfo campaignInfo = yndexDirectAPI.getCampaignsParams(new Long[]{campaignId})[0];

            if (campaignInfo.getStatusArchive().equals("Yes"))
                strategiesDao.removeStrategy(serviceStrategy.getId());

            if (campaignInfo.getIsActive().equals("Yes")) {
                //If strategy apply only for one banner.
                if (serviceStrategy.getBannerId() != null) {
                    executeBannerStrategy(serviceStrategy, yndexDirectAPI);
                }

                //If strategy apply for all banners of campaign.
                else {
                    executeCampaignStrategy(serviceStrategy, yndexDirectAPI);

                }
            }

            if (!phrasePriceInfoList.isEmpty())
                yndexDirectAPI.updatePrices(phrasePriceInfoList);

            phrasePriceInfoList = new ArrayList<PhrasePriceInfo>();
        }

        if (flag)
            savedMoneyInfoService.save();
        flag = false;
    }

    protected void executeCampaignStrategy(ServiceStrategy serviceStrategy, YndexDirectAPI yndexDirectAPI) {
        GetBannersInfo getBannersInfo = new GetBannersInfo();
        getBannersInfo.setGetPhrases("WithPrices");
        getBannersInfo.setCurrency("RUB");

        Long campaignID = serviceStrategy.getCampaignId();
        getBannersInfo.setCampaignIDS(Arrays.asList(campaignID));
        List<BannerInfo> banners = Arrays.asList(yndexDirectAPI.getBanners(getBannersInfo));

        // Iterate over all banners of this campaign and if there no strategy for them call executeStrategyOnBanner.
        for (BannerInfo banner : banners)
            if (!strategiesIds.contains(banner.getBannerID())) {
                executeStrategyOnBanner(serviceStrategy, banner);
            }
    }


    private void executeBannerStrategy(ServiceStrategy serviceStrategy, YndexDirectAPI yndexDirectAPI) {
        GetBannersInfo getBannersInfo = new GetBannersInfo();
        getBannersInfo.setGetPhrases("WithPrices");
        getBannersInfo.setCurrency("RUB");

        Long bannerId = serviceStrategy.getBannerId();
        getBannersInfo.setBannerIDS(Arrays.asList(bannerId));

        try {
            BannerInfo banner = Arrays.asList(yndexDirectAPI.getBanners(getBannersInfo)).get(0);

            if (banner.getStatusArchive().equals("Yes"))
                strategiesDao.removeStrategy(serviceStrategy.getId());

            executeStrategyOnBanner(serviceStrategy, banner);

        } catch (WrongRequestException e) {
            if (e.getMessage().contains("not found"))
                strategiesDao.removeStrategy(serviceStrategy.getId());
        }
    }


    private void executeStrategyOnBanner(ServiceStrategy strategy, BannerInfo banner) {


        List<BannerPhraseInfo> phrases = banner.getPhrases();
        for (BannerPhraseInfo phrase : phrases) {

            PhrasePriceInfo phrasePriceInfo = new PhrasePriceInfo();
            phrasePriceInfo.setCampaignID(phrase.getCampaignID());
            phrasePriceInfo.setPhraseID(phrase.getPhraseID());
            phrasePriceInfo.setAutoBroker("Yes");


            Double price = executeStrategy(phrase, strategy);


            if (flag) try {
                ServiceStrategy copyOfStrategy = (ServiceStrategy) BeanUtils.cloneBean(strategy);
                copyOfStrategy.setHighestPosition(true);
                copyOfStrategy.setPositions(Arrays.asList(Position.values()));
                double priceThatCouldBePaid = executeStrategy(phrase, copyOfStrategy);
                savedMoneyInfoService.saveStatistic(yndexDirectAccount,
                        priceThatCouldBePaid,
                        phrase.getCampaignID(),
                        phrase.getPhraseID()
                );
            } catch (Exception e) {

            }

            phrasePriceInfo.setPrice(price);
            phrasePriceInfo.setCurrency("RUB");
            phrasePriceInfoList.add(phrasePriceInfo);
        }


    }


    protected Double executeStrategy(BannerPhraseInfo phrase, ServiceStrategy strategy) {

        Map<Position, Double> positionPrices = getAvailablePositionPrices(phrase);

        Double rmax = strategy.getRmax();
        List<Position> positions = strategy.getPositions();

        Position position;

        if (strategy.isHighestPosition()) {
            position = getHighestPosition(positionPrices, positions, rmax);
        } else
            position = getLowerCostPosition(positionPrices, positions, rmax);

        if (position == null)
            return MIN_AVALIBLE_PRICE;

        Double positionPrice = positionPrices.get(position);
        Double nearestTopPrice = getNearestTopPrice(positionPrice, positionPrices.values());
        return calculatePrice(strategy.getRmax(), positionPrice, nearestTopPrice);

    }

    protected Position getHighestPosition(Map<Position, Double> positionsPrices, List<Position> positions, Double maxPrice) {

        Collections.sort(positions);
        for (Position position : positions) {
            Double positionPrice = positionsPrices.get(position);
            if (positionPrice != null)
                if (positionPrice < maxPrice) {
                    return position;
                }
        }
        return null;
    }

    protected Position getLowerCostPosition(Map<Position, Double> positionsPrices, List<Position> positions, Double maxPrice) {


        Double minPrice = 1000d;

        Position desiredPosition = null;

        for (Position position : positions) {
            if (positionsPrices.containsKey(position)) {
                Double positionPrice = positionsPrices.get(position);
                if (positionPrice < minPrice && positionPrice < maxPrice) {
                    minPrice = positionPrice;
                    desiredPosition = position;
                }
            }
        }
        return desiredPosition;
    }


    protected Double calculatePrice(Double rmax, Double desiredPrice, Double nearestTopPrice) {

        if (desiredPrice > rmax)
            return MIN_AVALIBLE_PRICE;

        else if (nearestTopPrice.equals(-1d))
            return rmax;

        else if (nearestTopPrice < rmax)
            return (nearestTopPrice - desiredPrice) / 2 + desiredPrice;
        else
            return (rmax - desiredPrice) / 2 + desiredPrice;

    }

    protected Map<Position, Double> getAvailablePositionPrices(BannerPhraseInfo phrase) {

        Map<Position, Double> pricesMap = new LinkedHashMap<Position, Double>();

        double firstSpec = phrase.getPremiumMax();
        double spec = phrase.getPremiumMin();
        double firstGuar = phrase.getMax();
        double guar = phrase.getMin();
        double dyn = phrase.getMinPrice();


        pricesMap.put(FIRST_SPEC, firstSpec);

        if (spec < firstSpec)
            pricesMap.put(SPEC, spec);

        if (firstGuar < min(firstSpec, spec))
            pricesMap.put(FIRST_GUAR, firstGuar);

        if (guar < min(firstSpec, spec, firstGuar))
            pricesMap.put(GUAR, guar);

        if (dyn < min(firstSpec, spec, firstGuar, guar))
            pricesMap.put(DYN, dyn);

        return pricesMap;
    }


    private Double min(Double... values) {

        List<Double> doubles = Arrays.asList(values);
        return Collections.min(doubles);
    }


    public static Double getNearestTopPrice(Double priceForSearch, Collection<Double> prices) {
        ArrayList<Double> pricesList = new ArrayList<Double>(prices);
        Collections.sort(pricesList);

        for (Double price : pricesList) {
            if (price > priceForSearch)
                return price;
        }
        return -1d;
    }

}
