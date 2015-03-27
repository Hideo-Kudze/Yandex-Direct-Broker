package com.HideoKuzeGits.YndexDirectAutobroker.xlsImport;

import com.HideoKuzeGits.yndexDirectAPI.YndexDirectAPI;
import com.HideoKuzeGits.yndexDirectAPI.YndexDirectApiFactory;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.RegionInfo;
import com.google.api.client.repackaged.com.google.common.base.Strings;
import org.apache.log4j.Logger;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;

import static com.HideoKuzeGits.yndexDirectAPI.MethodsToJsonAspect.Locale;

/**
 * Created by root on 29.08.14.
 */


@Service
@EnableScheduling
public class RegionsDao {


    private static Logger log = Logger.getLogger(RegionsDao.class.getName());

    @PersistenceContext
    private EntityManager em;


    public static void main(String[] args) {

        FileSystemXmlApplicationContext context
                = new FileSystemXmlApplicationContext("//home/hideo/IdeaProjects/YndexDirectAutobroker/src/main/webapp/WEB-INF/spring_hibernate.xml,//home/hideo/IdeaProjects/YndexDirectAutobroker/src/main/webapp/WEB-INF/dispatcher-servlet.xml".split(","));
        RegionsDao regionsDao = context.getBean(RegionsDao.class);
        regionsDao.update();
        System.out.println("End.");

    }

    public Long getRegionId(String regionName) {

        if (Strings.isNullOrEmpty(regionName))
            return null;

        RegionEntry regionEntry = em.find(RegionEntry.class, regionName);
        return regionEntry.getRegionId();
    }


    @Transactional
    public void update() {

        ArrayList<RegionEntry> regions = getRegions();

        for (RegionEntry region : regions) {
            em.merge(region);
            System.out.println(region);
            System.out.println("Merge regions: " + regions.indexOf(region) * 100 / regions.size() + "%");
        }
    }


    private ArrayList<RegionEntry> getRegions() {

        ArrayList<RegionEntry> regionEntries = new ArrayList<RegionEntry>();
        YndexDirectApiFactory yndexDirectApiFactory = new YndexDirectApiFactory();
        Locale[] locales = Locale.values();

        for (Locale locale : locales) {
            yndexDirectApiFactory.setLocale(locale);
            YndexDirectAPI yndexDirectApi = yndexDirectApiFactory.createSandboxApi();
            RegionInfo[] regions = yndexDirectApi.getRegions();

            for (RegionInfo region : regions) {
                System.out.println(region);
                String regionName = region.getRegionName();
                Long regionId = region.getRegionID();
                RegionEntry regionEntry = new RegionEntry(regionName, regionId);
                regionEntry = chakeAndHandleExceptionRegions(regionEntry, locale);
                regionEntries.add(regionEntry);
            }
        }
        return regionEntries;
    }

    private RegionEntry chakeAndHandleExceptionRegions(RegionEntry region, Locale locale) {

        Long regionId = region.getRegionId();

        //Железногорск (Красноярский край)
        long zheleznogorskKrasnoyarskKraiId = 20086l;

        //Юг (Украина)
        long southOfUkraineId = 20526l;

        //Центр (Украина)
        long centreOfUkraineId = 20527l;



        if (regionId.equals(zheleznogorskKrasnoyarskKraiId)) {

            if (locale.equals(Locale.ru))
                return new RegionEntry("Железногорск (Красноярский край)", zheleznogorskKrasnoyarskKraiId);
            else if (locale.equals(Locale.ua))
                return new RegionEntry("Желєзногорськ (Красноярський край)", zheleznogorskKrasnoyarskKraiId);
            else if (locale.equals(Locale.en))
                return new RegionEntry("Zheleznogorsk (Krasnoyarsk Krai)", zheleznogorskKrasnoyarskKraiId);

        } else {
            if (regionId.equals(southOfUkraineId)) {

                if (locale.equals(Locale.ru))
                    return new RegionEntry("Юг (Украина)", southOfUkraineId);
                else if (locale.equals(Locale.ua))
                    return new RegionEntry("Південь (Україна)", southOfUkraineId);
                else if (locale.equals(Locale.en))
                    return new RegionEntry("South (Ukraine)", southOfUkraineId);

            } else {
                if (regionId.equals(centreOfUkraineId)) {

                    if (locale.equals(Locale.ru))
                        return new RegionEntry("Центр (Украина)", centreOfUkraineId);
                    else if (locale.equals(Locale.ua))
                        return new RegionEntry("Центр (Україна)", centreOfUkraineId);
                    else if (locale.equals(Locale.en))
                        return new RegionEntry("Centre (Ukraine)", centreOfUkraineId);

                }
            }
        }


        return region;
    }

}
