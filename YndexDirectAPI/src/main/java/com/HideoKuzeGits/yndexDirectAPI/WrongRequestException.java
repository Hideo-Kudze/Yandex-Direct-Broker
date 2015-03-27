package com.HideoKuzeGits.yndexDirectAPI;

/**
 * Created by root on 22.06.14.
 */
public class WrongRequestException extends RuntimeException {
    public WrongRequestException(String jsonString, String resultJson) {
      super("Request:\n"+jsonString+"\n return error:\n"+resultJson+"\n");
    }
}
