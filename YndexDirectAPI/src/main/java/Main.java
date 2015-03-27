import com.HideoKuzeGits.yndexDirectAPI.YndexDirectAPI;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by root on 20.06.14.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        byte[] encoded = Files.readAllBytes(Paths.get("/home/hideo/IdeaProjects/YndexDirectAutobroker/YndexDirectAPI/src/main/java/com/HideoKuzeGits/yndexDirectAPI/text"));
        String jsonString = new String(encoded);
        jsonString =jsonString.replaceAll("\\(string\\)", "\"ghjfg\"");
        jsonString =jsonString.replaceAll("\\(date\\)", "\"ghjfg\"");
        jsonString = jsonString.replaceAll("\\(int\\)", "1");
        jsonString = jsonString.replaceAll("\\(float\\)", "1.5");
        jsonString = jsonString.replaceAll("\\(long\\)", "1");
        jsonString = jsonString.replaceAll("\\.\\.\\.", "");
        jsonString = jsonString.replaceAll("\\/\\*(.*?)\\*\\/", "");

        System.out.println(jsonString);
    }

}