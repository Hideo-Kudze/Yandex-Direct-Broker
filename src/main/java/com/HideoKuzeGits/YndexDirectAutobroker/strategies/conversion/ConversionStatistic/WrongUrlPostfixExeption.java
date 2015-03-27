package com.HideoKuzeGits.YndexDirectAutobroker.strategies.conversion.ConversionStatistic;

/**
 * Created by root on 27.08.14.
 */
public class WrongUrlPostfixExeption extends Exception {

    public WrongUrlPostfixExeption(String massage) {
        super(massage);
    }

    public WrongUrlPostfixExeption(Throwable cause) {
        super(cause);
    }

    public WrongUrlPostfixExeption(String message, Throwable cause) {
        super(message, cause);
    }

}
