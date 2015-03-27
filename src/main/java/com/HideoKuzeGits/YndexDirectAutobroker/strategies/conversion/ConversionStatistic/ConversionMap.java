package com.HideoKuzeGits.YndexDirectAutobroker.strategies.conversion.ConversionStatistic;

import com.HideoKuzeGits.YndexDirectAutobroker.strategies.Position;
import com.google.api.services.analytics.model.GaData;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;

import static com.HideoKuzeGits.YndexDirectAutobroker.UsefulStaticMethods.getUrlParameter;
import static com.HideoKuzeGits.YndexDirectAutobroker.strategies.Position.*;

/**
 * Created by root on 27.08.14.
 */
public class ConversionMap extends HashMap<Long, PhraseConversion> {

    private static Logger log = Logger.getLogger(ConversionMap.class.getName());

    public static void main(String[] args) throws WrongUrlPostfixExeption {
        String landingPagePostfix = "/?type=search&source=none&added=no&block=premium&position=1&keyword=Соки";
        new ConversionMap().getPosition(landingPagePostfix);
    }

    public void appendStatistic(GaData gaData) {
        List<List<String>> rows = gaData.getRows();
        for (List<String> row : rows) {
            try {
                String landingPagePostfix = row.get(0);

                Long phraseId = getPhraseId(landingPagePostfix);
                Position position = getPosition(landingPagePostfix);
                Integer sessions = new Integer(row.get(1));
                Integer conversions = new Integer(row.get(2));

                //get was override so that return a new instance if it is not contained in the map.
                PhraseConversion phraseConversion = get(phraseId);
                phraseConversion.increaseConversion(position, conversions, sessions);
            } catch (WrongUrlPostfixExeption e) {
                log.warn(e);
            }
        }
    }

    private Long getPhraseId(String landingPagePostfix) throws WrongUrlPostfixExeption {

        String phraseId = null;
        try {
            phraseId = getUrlParameter(landingPagePostfix, "phraseId");
            return new Long(phraseId);
        } catch (StringIndexOutOfBoundsException e) {

            throw new WrongUrlPostfixExeption( "There is no phraseId parameter." +
                    " \n Postfix: " + landingPagePostfix, e);
        } catch (NumberFormatException e) {
            throw new WrongUrlPostfixExeption("Wrong phrase id: " + phraseId +
                    " \n Postfix: " + landingPagePostfix, e);
        }
    }

    private Position getPosition(String landingPagePostfix) throws WrongUrlPostfixExeption {

        String block = null;
        try {
            block = getUrlParameter(landingPagePostfix, "block");
        } catch (StringIndexOutOfBoundsException e) {
            throw new WrongUrlPostfixExeption("There is no block parameter." +
                    " \n Postfix: " + landingPagePostfix, e);
        }

        String position = null;
        try {
            position = getUrlParameter(landingPagePostfix, "position");
        } catch (StringIndexOutOfBoundsException e) {
            throw new WrongUrlPostfixExeption("There is no position parameter." +
                    " \n Postfix: " + landingPagePostfix, e);
        }


        if (block.equals("premium"))
            if (position.equals("1"))
                return FIRST_SPEC;
            else
                return SPEC;
        else if (block.equals("other"))
            if (position.equals("1"))
                return FIRST_GUAR;
            else
                return GUAR;
        else if (block.equals("none"))
            return DYN;
        else
            throw new WrongUrlPostfixExeption("Wrong block name: " + block +
                    " \n Postfix: " + landingPagePostfix);

    }


    @Override
    public PhraseConversion get(Object key) {

        if (containsKey(key))
            return super.get(key);
        else {
            PhraseConversion phraseConversion = new PhraseConversion();
            put((Long) key, phraseConversion);
            return phraseConversion;
        }
    }
}
