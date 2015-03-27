package com.HideoKuzeGits.YndexDirectAutobroker.strategies.conversion.ConversionStatistic;

import com.HideoKuzeGits.YndexDirectAutobroker.strategies.Position;
import com.google.common.collect.ImmutableMap;

import static com.HideoKuzeGits.YndexDirectAutobroker.strategies.Position.*;

/**
 * Created by root on 27.08.14.
 */


public class PhraseConversion extends Conversion {

    private ImmutableMap<Position, Conversion> positionConversions = ImmutableMap.of(
            FIRST_SPEC, new Conversion(),
            SPEC, new Conversion(),
            FIRST_GUAR, new Conversion(),
            GUAR, new Conversion(),
            DYN, new Conversion());


    public void increaseConversion(Position position, int conversions, int sessions) {

        increaseConversion(conversions, sessions);
        Conversion positionConversion = positionConversions.get(position);
        positionConversion.increaseConversion(conversions, sessions);
    }

    public Conversion getPositionConversion(Position position) {
        return  positionConversions.get(position);
    }
}
