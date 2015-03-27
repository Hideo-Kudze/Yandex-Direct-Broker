package com.HideoKuzeGits.YndexDirectAutobroker.utm;

import com.HideoKuzeGits.YndexDirectAutobroker.SessionAttributeWrap;
import com.HideoKuzeGits.YndexDirectAutobroker.UsefulStaticMethods;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.APIAccounts.YndexDirectAccount;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.CampaignWithUTM;
import com.HideoKuzeGits.YndexDirectAutobroker.strategies.conversion.CampaignsGoalsWireService;
import com.HideoKuzeGits.YndexDirectAutobroker.xlsImport.BannerCollection;
import com.HideoKuzeGits.YndexDirectAutobroker.xlsImport.ExcelBanner;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.*;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Collections2;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by root on 28.07.14.
 */
@Service
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UTMService {


    public static final String utmPostfix = "&type={source_type}&source={source}&added={addphrases}&block={position_type}&position={position}&keyword={keyword}";
    public static final String utm_medium = "cpc";
    public static final String custom_prefix = "ad";
    public static final String utm_source = "yandex";
    public static final double MIN_PRICE = 0.30;


    @Autowired
    private SessionAttributeWrap sessionWrap;

    @Autowired
    private CampaignsWithUtmDao campaignsWithUtmDao;

    @Autowired
    private CampaignsGoalsWireService campaignsGoalsWireService;


    @Transactional(rollbackFor = Throwable.class)
    public void addUTMtoCampaign(Long oldCampaignId) throws Exception {

        CampaignInfo oldCampaign = sessionWrap.getApi().getCampaignsParams(new Long[]{oldCampaignId})[0];
        oldCampaign.setCampaignID(0l);
        Long newCampaignId = sessionWrap.getApi().createOrUpdateCampaign(oldCampaign);

        GetBannersInfo getBannersInfo = new GetBannersInfo();
        getBannersInfo.setCampaignIDS(Arrays.asList(oldCampaignId));
        getBannersInfo.setGetPhrases("WithPrices");
        getBannersInfo.setCurrency("RUB");
        BannerInfo[] banners = sessionWrap.getApi().getBanners(getBannersInfo);
        if (banners.length < 1)
            return;
        String campaignName = oldCampaign.getName();

        try {

            Long[] newBannersIdsArray = createBannersWithUTM(banners, campaignName, newCampaignId);
            stopOldCampaign(oldCampaignId);
            YndexDirectAccount account = sessionWrap.getAccount();

            CampaignWithUTM campaignWithUTM = new CampaignWithUTM();
            campaignWithUTM.setCampaignId(newCampaignId);
            campaignWithUTM.setYndexDirectAccount(account);
            campaignWithUTM.setName(oldCampaign.getName());
            campaignsGoalsWireService.addGoalsToCampaign(campaignWithUTM);
            campaignsWithUtmDao.saveCampaignWithUtm(campaignWithUTM);
            sessionWrap.getApi().moderateBanners(newCampaignId, newBannersIdsArray);
        } catch (Exception e) {
            restoreOldCampaign(oldCampaignId);
            sessionWrap.getApi().deleteCampaign(newCampaignId);
            throw e;
        }
    }

    private Long[] createBannersWithUTM(BannerInfo[] banners, String campaignName, Long newCampaignId) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {


        ArrayListMultimap<Integer, ExcelBanner> bannersWithGroupMultimap = getBannersGroupNumMultimap(Arrays.asList(banners));


        cloneBanners(bannersWithGroupMultimap);

        Collection<ExcelBanner> excelBanners = bannersWithGroupMultimap.values();


        for (BannerInfo banner : excelBanners) {

            banner.setCampaignID(newCampaignId);
            banner.setAgeLabel(null);
            banner.setBannerID(0l);
            banner.setAdGroupID(0l);
            banner.getPhrases().get(0).setCurrency("RUB");

            if (banner.getPhrases().get(0).getContextPrice() != null)
                if (banner.getPhrases().get(0).getContextPrice() < MIN_PRICE)
                    banner.getPhrases().get(0).setContextPrice(MIN_PRICE);

            if (banner.getPhrases().get(0).getPrice() < MIN_PRICE)
                banner.getPhrases().get(0).setPrice(MIN_PRICE);

        }


        BannerCollection bannerCollection = new BannerCollection();
        bannerCollection.setBannersWithGroupMultimap(bannersWithGroupMultimap);
        bannerCollection.uploadBanners(sessionWrap.getApi(), newCampaignId);


        BannerInfo[] bannersWithNewId = excelBanners.toArray(new BannerInfo[excelBanners.size()]);
        Collection<Long> newBannersIdsCollection
                = Collections2.transform(excelBanners, BannerCollection.extractBannersIdsFunction);
        Long[] newBannersIdsArray
                = newBannersIdsCollection.toArray(new Long[newBannersIdsCollection.size()]);


        for (BannerInfo bannerInfo : bannersWithNewId) {
            addUTMtoBanner(bannerInfo, campaignName);
        }

        sessionWrap.getApi().createOrUpdateBanners(Arrays.asList(bannersWithNewId));
        return newBannersIdsArray;
    }

    private void cloneBanners(ArrayListMultimap<Integer, ExcelBanner> bannersWithGroupMultimap) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {

        int groupNum = -1;

        ArrayListMultimap<Integer, ExcelBanner> multimapForGroupClones = ArrayListMultimap.create();

        for (Integer adGroupNum : bannersWithGroupMultimap.keySet()) {

            List<ExcelBanner> currentGroupBanners = bannersWithGroupMultimap.get(adGroupNum);
            ExcelBanner firstBannerInGroup = currentGroupBanners.get(0);

            List<BannerPhraseInfo> bannerPhrases = firstBannerInGroup.getPhrases();

            List<BannerPhraseInfo> firstPhraseInGroup = Arrays.asList(bannerPhrases.get(0));

            for (ExcelBanner banner : currentGroupBanners)
                banner.setPhrases(firstPhraseInGroup);


            if (bannerPhrases.size() != 1) {

                Iterator<BannerPhraseInfo> bannerPhraseIterator = bannerPhrases.iterator();
                //Skip first
                bannerPhraseIterator.next();

                while (bannerPhraseIterator.hasNext()) {

                    BannerPhraseInfo bannerPhrase = bannerPhraseIterator.next();
                    for (ExcelBanner banner : currentGroupBanners) {

                        ExcelBanner newBanner = (ExcelBanner) BeanUtils.cloneBean(banner);
                        newBanner.setPhrases(Arrays.asList(bannerPhrase));
                        newBanner.setGroupNum(groupNum);
                        multimapForGroupClones.put(groupNum, newBanner);
                    }
                    groupNum--;
                }
            }

        }

        bannersWithGroupMultimap.putAll(multimapForGroupClones);
    }

    private ArrayListMultimap<Integer, ExcelBanner> getBannersGroupNumMultimap(List<BannerInfo> banners) {

        ArrayListMultimap<Integer, ExcelBanner> bannersWithGroupMultimap = ArrayListMultimap.create();
        OrderedMap adGroupIdNumMap = new OrderedMap();


        for (BannerInfo bannerInfo : banners) {

            Long adGroupID = bannerInfo.getAdGroupID();
            bannerInfo.setAdGroupID(0l);
            Integer num = adGroupIdNumMap.put(adGroupID);
            ExcelBanner excelBanner = new ExcelBanner();
            excelBanner.setGroupNum(num);
            try {
                BeanUtils.copyProperties(excelBanner, bannerInfo);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }


            bannersWithGroupMultimap.put(num, excelBanner);
        }


        return bannersWithGroupMultimap;
    }

    public static void addUTMtoBanner(BannerInfo banner, String campaignName) {

        BannerPhraseInfo bannerPhrase = banner.getPhrases().get(0);

        String phrase = bannerPhrase.getPhrase();
        Long phraseID = bannerPhrase.getPhraseID();
        Long bannerID = banner.getBannerID();

        String href = banner.getHref();
        String url = addUTMToUrl(href, campaignName, phrase, bannerID, phraseID);
        banner.setHref(url);


        List<Sitelink> sitelinks = banner.getSitelinks();

        for (int i = 0; i < sitelinks.size(); i++) {
            Sitelink sitelink = sitelinks.get(i);
            String sitelinkPhrase = phrase + "_быстрая" + i;
            url = addUTMToUrl(sitelink.getHref(), campaignName, sitelinkPhrase, bannerID, phraseID);
            sitelink.setHref(url);
        }


    }

    private static String addUTMToUrl(String urlString,
                                      String campaignName,
                                      String phrase,
                                      Long bannerID,
                                      Long phraseId) {

        try {
            urlString = removeUTMFromURL(urlString);
            campaignName = URLEncoder.encode(campaignName, "UTF-8");
            phrase = URLEncoder.encode(phrase, "UTF-8");


            StringBuilder stringBuilder = new StringBuilder(urlString);

            if (!urlString.contains("?"))
                stringBuilder.append("?");
            else
                stringBuilder.append("&");


            stringBuilder.append("utm_source=");
            stringBuilder.append(utm_source);


            stringBuilder.append("&utm_campaign=");
            stringBuilder.append(campaignName);

            stringBuilder.append("&utm_medium=");
            stringBuilder.append(utm_medium);

            stringBuilder.append("&utm_content=");
            stringBuilder.append(phrase);
            stringBuilder.append("_");
            stringBuilder.append(custom_prefix);
            stringBuilder.append(bannerID);

            stringBuilder.append("&phraseId=");
            stringBuilder.append(phraseId);

            stringBuilder.append(utmPostfix);


            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private void stopOldCampaign(Long oldCampaignId) {
        sessionWrap.getApi().stopCampaign(oldCampaignId);
    }


    private void restoreOldCampaign(Long oldCampaignId) {
        sessionWrap.getApi().resumeCampaign(oldCampaignId);
    }


    private static String removeUTMFromURL(String urlString) {


        urlString = UsefulStaticMethods.removeUrlParameter(urlString, "utm_source");
        urlString = UsefulStaticMethods.removeUrlParameter(urlString, "utm_campaign");
        urlString = UsefulStaticMethods.removeUrlParameter(urlString, "utm_medium");
        urlString = UsefulStaticMethods.removeUrlParameter(urlString, "utm_content");
        urlString = UsefulStaticMethods.removeUrlParameter(urlString, "utm_term");
        urlString = UsefulStaticMethods.removeUrlParameter(urlString, "phraseId");
        urlString = UsefulStaticMethods.removeUrlParameter(urlString, "type");
        urlString = UsefulStaticMethods.removeUrlParameter(urlString, "source");
        urlString = UsefulStaticMethods.removeUrlParameter(urlString, "added");
        urlString = UsefulStaticMethods.removeUrlParameter(urlString, "block");
        urlString = UsefulStaticMethods.removeUrlParameter(urlString, "position");
        urlString = UsefulStaticMethods.removeUrlParameter(urlString, "keyword");

        if (urlString.endsWith("?") || urlString.endsWith("&"))
            urlString = urlString.substring(0, urlString.length() - 1);

        return urlString;
    }


}
