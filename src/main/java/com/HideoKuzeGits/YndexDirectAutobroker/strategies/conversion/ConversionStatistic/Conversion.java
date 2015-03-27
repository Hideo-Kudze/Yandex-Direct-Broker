package com.HideoKuzeGits.YndexDirectAutobroker.strategies.conversion.ConversionStatistic;

import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.AbstractWrap;

/**
 * Created by root on 27.08.14.
 */
public class Conversion extends AbstractWrap{

    private int conversions =0;
    private int sessions = 0;

    public void increaseConversion(int conversions, int sessions){

       this.conversions += conversions;
       this.sessions += sessions;
    }

    public int getConversions() {
        return conversions;
    }

    public int getSessions() {
        return sessions;
    }

    public double getConversionRate() {
        return (double)conversions / sessions;
    }
}
