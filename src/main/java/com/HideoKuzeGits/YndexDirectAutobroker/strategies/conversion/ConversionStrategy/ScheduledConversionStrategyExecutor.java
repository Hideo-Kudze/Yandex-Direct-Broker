package com.HideoKuzeGits.YndexDirectAutobroker.strategies.conversion.ConversionStrategy;

import com.HideoKuzeGits.YndexDirectAutobroker.AnalyticsAccount.AnalyticsAccountsDao;
import com.HideoKuzeGits.YndexDirectAutobroker.UsefulStaticMethods;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.strategies.ConversionStrategy;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.GoogleAnalytics.AnalyticsGoal;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.strategies.ServiceStrategy;
import com.HideoKuzeGits.YndexDirectAutobroker.strategies.Position;
import com.HideoKuzeGits.YndexDirectAutobroker.strategies.conversion.SimpleStrategy.ScheduledStrategyExecutor;
import com.HideoKuzeGits.YndexDirectAutobroker.strategies.conversion.ConversionStatistic.Conversion;
import com.HideoKuzeGits.YndexDirectAutobroker.strategies.conversion.ConversionStatistic.ConversionMap;
import com.HideoKuzeGits.YndexDirectAutobroker.strategies.conversion.ConversionStatistic.PhraseConversion;
import com.HideoKuzeGits.yndexDirectAPI.YndexDirectAPI;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.BannerPhraseInfo;
import com.google.api.services.analytics.Analytics;
import com.google.api.services.analytics.model.GaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by root on 18.08.14.
 */

@Service
public class ScheduledConversionStrategyExecutor extends ScheduledStrategyExecutor {

    @Autowired
    private AnalyticsAccountsDao analyticsAccountsDao;

    private static final String METRICS = "ga:sessions,ga:goalXXCompletions";
    private static final int FIRST_THRESHOLD = 3;
    private static final int SECOND_THRESHOLD = 3;

    private ConversionMap conversionMap;

    public static void main(String[] args) {
       /* FileSystemXmlApplicationContext context
                = new FileSystemXmlApplicationContext("//home/hideo/IdeaProjects/YndexDirectAutobroker/src/main/webapp/WEB-INF/spring_hibernate.xml,//home/hideo/IdeaProjects/YndexDirectAutobroker/src/main/webapp/WEB-INF/dispatcher-servlet.xml".split(","));

        ScheduledConversionStrategyExecutor strategyExecutor = context.getBean(ScheduledConversionStrategyExecutor.class);
*/



    }


    @Override
    //Scheduled from super class
    protected void executeAllStrategies() {
        List<ConversionStrategy> strategiesLst
                = strategiesDao.getAllStrategies(ConversionStrategy.class);
        executeStrategies(strategiesLst);
    }


    @Override
    protected void executeCampaignStrategy(ServiceStrategy serviceStrategy, YndexDirectAPI yndexDirectAPI) {
        this.conversionMap = createConversionMap((ConversionStrategy) serviceStrategy);
        super.executeCampaignStrategy(serviceStrategy, yndexDirectAPI);
    }


    @Override
    protected Double executeStrategy(BannerPhraseInfo phrase, ServiceStrategy strategy) {



        Long phraseID = phrase.getPhraseID();
        PhraseConversion phraseConversion = conversionMap.get(phraseID);

        if (phraseConversion.getConversions() < FIRST_THRESHOLD)
            return super.executeStrategy(phrase, strategy);

        Map<Position, Double> positionPrices = getAvailablePositionPrices(phrase);
        Map<Position, Double> positionConversionPrices = getPositionConversionPrices(positionPrices, phraseConversion);

        Double rmax = strategy.getRmax();
        Double cmax = ((ConversionStrategy) strategy).getCmax();
        List<Position> positions = strategy.getPositions();

        Position position;

        if (strategy.isHighestPosition()) {

            Position highestPosition = getHighestPosition(positionPrices, positions , rmax);
            Double highestPositionPrice = positionPrices.get(highestPosition);

            Position highestConversionPosition = getHighestPosition(positionConversionPrices, positions, cmax);
            Double highestConversionPositionPrice = positionPrices.get(highestConversionPosition);

            if (highestConversionPositionPrice == null)
                position = highestPosition;
            else if (highestPositionPrice == null)
                position = highestConversionPosition;
            else if (highestConversionPositionPrice == null && highestPositionPrice == null)
                position = null;
            else  if (highestPositionPrice < highestConversionPositionPrice)
                position = highestPosition;
            else
                position = highestConversionPosition;

        } else
            position = getLowerCostPosition(positionConversionPrices, positions , cmax);

        if (position == null)
            return 0.30d;

        Double positionPrice = positionPrices.get(position);
        Double nearestTopPrice = getNearestTopPrice(positionPrice, positionPrices.values());
        return calculatePrice(strategy.getRmax(), positionPrice, nearestTopPrice);
    }

    private Map<Position, Double> getPositionConversionPrices(Map<Position, Double> positionPrices, PhraseConversion phraseConversion) {

        Map<Position, Double> conversionPriceMap = new HashMap<Position, Double>();

        for (Position position : positionPrices.keySet()) {

            Double price = positionPrices.get(position);
            double positionConversionPrice = getPositionConversionPrice(position, phraseConversion, price);
            conversionPriceMap.put(position, positionConversionPrice);
        }

        return conversionPriceMap;
    }

    private double getPositionConversionPrice(Position position, PhraseConversion phraseConversion, Double price) {

        Conversion positionConversion = phraseConversion.getPositionConversion(position);

        if (positionConversion.getConversions() > SECOND_THRESHOLD)
            return price / positionConversion.getConversionRate();
        else
            return price / phraseConversion.getConversionRate();
    }

    private ConversionMap createConversionMap(ConversionStrategy conversionStrategy) {

        ConversionMap conversionMap = new ConversionMap();

        Set<AnalyticsGoal> goals = conversionStrategy.getGoals();

        for (AnalyticsGoal goal : goals) {

            try {

                GaData gaData = getGoalStatistic(goal, "ga:landingPagePath" , METRICS);
                conversionMap.appendStatistic(gaData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return conversionMap;
    }

    private GaData getGoalStatistic(AnalyticsGoal goal, String gaLandingPagePath, String metrics) throws IOException {

        Analytics analytics = goal.getGoogleAnalyticsAccount().getAnalytics();
        String viewId = "ga:" + goal.getView().getViewId();
        String dateOfCreating = goal.getDateOfCreating();
        String yesterdayDate = UsefulStaticMethods.getYesterdayDateString();
        metrics = metrics.replaceAll("XX", goal.getGoalId());
        return analytics.data().ga().get(viewId, dateOfCreating, yesterdayDate, metrics)
                .setDimensions(gaLandingPagePath)
                .execute();
    }
}
