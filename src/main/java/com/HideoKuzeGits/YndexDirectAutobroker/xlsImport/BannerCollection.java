package com.HideoKuzeGits.YndexDirectAutobroker.xlsImport;


import com.HideoKuzeGits.YndexDirectAutobroker.utm.UTMService;
import com.HideoKuzeGits.yndexDirectAPI.YndexDirectAPI;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.*;
import com.google.api.client.repackaged.com.google.common.base.Strings;
import com.google.common.base.Function;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.apache.commons.beanutils.BeanUtils;

import javax.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static com.HideoKuzeGits.YndexDirectAutobroker.UsefulStaticMethods.cloneBeanList;

public class BannerCollection {

    private ArrayListMultimap<Integer, ExcelBanner> bannersWithGroupMultimap = ArrayListMultimap.create();
    private List<ExcelBanner> bannersWithoutGroup = new ArrayList<ExcelBanner>();
    private CampaignInfo campaignInfo;
    private Integer cloneBannersCount = -10;

    public static Function<ExcelBanner,Long>  extractBannersIdsFunction
            = new Function<ExcelBanner, Long>() {
        @Nullable
        @Override
        public Long apply(@Nullable ExcelBanner banner) {
            return banner.getBannerID();
        }
    };


    public void add(ExcelBanner banner) {

        Integer groupNum = banner.getGroupNum();
        Boolean isAdditional = banner.getIsAdditional();
        String groupName = banner.getAdGroupName();

        //If there is no group parametrs in banner create them without groups
        if (groupNum == null &&
                isAdditional == null &&
                (Strings.isNullOrEmpty(groupName) ||
                        "NULL".equals(groupName))) {
            banner.setAdGroupName(null);
            bannersWithoutGroup.add(banner);
        } else
            bannersWithGroupMultimap.put(banner.getGroupNum(), banner);
    }

    public void uploadToDirect(YndexDirectAPI yndexDirectApi) {

        try {
            Long campaignId = uploadCampaign(yndexDirectApi);
            setCurrencyForAllBakers();
            fillParametersForAdditionAds();
            cloneBanners();
            addUtmToBanners();
            uploadBanners(yndexDirectApi, campaignId);
            uploadTags(yndexDirectApi, campaignId);
            uploadImages(yndexDirectApi, campaignId);
            moderateBaners(yndexDirectApi, campaignId);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setCurrencyForAllBakers() {

        String currency = campaignInfo.getCurrency();

        for (ExcelBanner banner : bannersWithoutGroup) {

            List<BannerPhraseInfo> phrases = banner.getPhrases();
            for (BannerPhraseInfo phrase : phrases)
                phrase.setCurrency(currency);
        }

        Collection<ExcelBanner> banners = bannersWithGroupMultimap.values();

        for (ExcelBanner banner : banners) {
            List<BannerPhraseInfo> phrases = banner.getPhrases();
            for (BannerPhraseInfo phrase : phrases)
                phrase.setCurrency(currency);
        }


    }

    private void fillParametersForAdditionAds() throws InvocationTargetException, IllegalAccessException {

        ArrayList<ExcelBanner> mainBanners = new ArrayList<ExcelBanner>();

        for (Integer groupNum : bannersWithGroupMultimap.keySet()) {

            List<ExcelBanner> banners = bannersWithGroupMultimap.get(groupNum);

            for (ExcelBanner banner : banners)
                if (banner.getIsAdditional() != null)
                    if (!banner.getIsAdditional()) {
                        mainBanners.add(banner);
                        break;
                    }
        }

        for (ExcelBanner mainBanner : mainBanners) {

            List<ExcelBanner> groupBanners = bannersWithGroupMultimap.get(mainBanner.getGroupNum());

            for (ExcelBanner groupBanner : groupBanners)
                BeanUtils.copyProperty(groupBanner, "geo", mainBanner.getGeo());

        }
    }

    private Long uploadCampaign(YndexDirectAPI yndexDirectApi) {
        ClientInfo clientInfo = yndexDirectApi.getClientInfo();
        campaignInfo.setCampaignID(0l);
        String login = clientInfo.getLogin();
        campaignInfo.setLogin(login);
        campaignInfo.setStrategy(new CampaignStrategy("HighestPosition"));
        String FIO = clientInfo.getFIO();
        campaignInfo.setFIO(FIO);
        String email = clientInfo.getEmail();
        EmailNotification emailNotification = new EmailNotification();
        emailNotification.setEmail(email);
        emailNotification.setWarnPlaceInterval(30l);
        emailNotification.setMoneyWarningValue(20l);
        campaignInfo.setEmailNotification(emailNotification);
        Long campaignID = yndexDirectApi.createOrUpdateCampaign(campaignInfo);
        campaignInfo.setCampaignID(campaignID);
        return campaignID;
    }

    public void uploadBanners(YndexDirectAPI yndexDirectApi, Long campaignId) throws InvocationTargetException, IllegalAccessException {

        //All first banners in map used for group creation.
        uploadGroups(yndexDirectApi, campaignId);

        //Upload on direct all another banners
        ArrayList<ExcelBanner> bannerfForUpload = new ArrayList<ExcelBanner>();
        bannerfForUpload.addAll(bannersWithoutGroup);

        for (Integer groupNum : bannersWithGroupMultimap.keySet()) {

            List<ExcelBanner> banners = bannersWithGroupMultimap.get(groupNum);
            Iterator<ExcelBanner> iterator = banners.iterator();
            //Skip first banner
            iterator.next();

            while (iterator.hasNext()) {
                ExcelBanner excelBanner = iterator.next();
                bannerfForUpload.add(excelBanner);
            }

        }

        uploadBanners(yndexDirectApi, campaignId, bannerfForUpload);


    }


    private void uploadBanners(YndexDirectAPI yndexDirectApi,
                               Long campaignId,
                               List<ExcelBanner> banners) {


        if (banners == null)
            return;

        if (banners.isEmpty())
            return;;

        for (ExcelBanner banner : banners) {
            banner.setCampaignID(campaignId);
        }

        Long[] bannersIds = yndexDirectApi.createOrUpdateBanners(banners);

        for (int i = 0; i < bannersIds.length; i++) {

            Long bannerId = bannersIds[i];
            ExcelBanner banner = banners.get(i);
            banner.setBannerID(bannerId);
        }
    }

    public void cloneBanners() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        ArrayListMultimap<Integer, ExcelBanner> bannersCloneMultimap = ArrayListMultimap.create();

        for (Integer key : bannersWithGroupMultimap.keys()) {

            Map<String, BannerPhraseInfo> groupPhrases = new HashMap<String, BannerPhraseInfo>();
            //All banners from one group
            List<ExcelBanner> excelBanners = bannersWithGroupMultimap.get(key);


            //Remove phrases objects from banners for all banners
            for (ExcelBanner excelBanner : excelBanners) {

                List<BannerPhraseInfo> phrases = excelBanner.getPhrases();

                //Get all phrases in group
                if (phrases != null)
                    if (!phrases.isEmpty()) {
                        BannerPhraseInfo bannerPhrase = phrases.get(0);
                        String phrase = bannerPhrase.getPhrase();
                        phrase = phrase.trim();
                        groupPhrases.put(phrase, bannerPhrase);
                    }

                excelBanner.setPhrases(null);
            }

            boolean isFirst = true;

            //Clone banners one to one group <--> phrase.
            for (String phrase : groupPhrases.keySet()) {

                //Don`t clone banner for first phrase they are already in multimap.
                BannerPhraseInfo bannerPhrase = groupPhrases.get(phrase);


                if (!isFirst) {
                    excelBanners = cloneBeanList(excelBanners);
                    bannersCloneMultimap.putAll(cloneBannersCount, excelBanners);

                    //Cope fields that not filled for addition ads in group.
                    for (ExcelBanner excelBanner : excelBanners)
                        excelBanner.setGroupNum(cloneBannersCount);
                    cloneBannersCount--;
                }

                isFirst = false;
                for (ExcelBanner excelBanner : excelBanners)
                    excelBanner.setPhrases(Arrays.asList(bannerPhrase));

            }
        }
        bannersWithGroupMultimap.putAll(bannersCloneMultimap);
    }

    private void addUtmToBanners() {

        String name = campaignInfo.getName();

        if (name == null)
            return;

        List<ExcelBanner> allBanners = getAllBanners();

        for (ExcelBanner banner : allBanners)
            UTMService.addUTMtoBanner(banner, name);

    }

    private void uploadGroups(YndexDirectAPI yndexDirectApi, Long campaignId) throws InvocationTargetException, IllegalAccessException {

        ArrayList<ExcelBanner> bannersForGroupCreation = new ArrayList<ExcelBanner>();

        for (Integer groupNumbers : bannersWithGroupMultimap.keySet()) {

            ExcelBanner excelBanner = bannersWithGroupMultimap.get(groupNumbers).get(0);
            bannersForGroupCreation.add(excelBanner);
        }

        if (bannersForGroupCreation.isEmpty())
            return;

        uploadBanners(yndexDirectApi, campaignId, bannersForGroupCreation);

        List<Long> bannersIds = Lists.transform(bannersForGroupCreation, extractBannersIdsFunction);
        GetBannersInfo getBannersInfo = new GetBannersInfo();
        getBannersInfo.setBannerIDS(bannersIds);
        BannerInfo[] bannersWithGroups = yndexDirectApi.getBanners(getBannersInfo);

        for (int i = 0; i < bannersWithGroups.length; i++) {

            BannerInfo bannerWithGroup = bannersWithGroups[i];
            ExcelBanner bannerForGroupCreation = bannersForGroupCreation.get(i);
            Long adGroupID = bannerWithGroup.getAdGroupID();
            Integer groupNum = bannerForGroupCreation.getGroupNum();
            List<ExcelBanner> excelBanners = bannersWithGroupMultimap.get(groupNum);

            for (ExcelBanner excelBanner : excelBanners) {
                excelBanner.setAdGroupID(adGroupID);
            }
        }


    }

    private void uploadTags(YndexDirectAPI yndexDirectApi, Long campaignId) {

        List<ExcelBanner> allBanners = getAllBanners();
        Map<String, Tag> tagsMap = new HashMap<String, Tag>();


        for (ExcelBanner excelBanner : allBanners) {
            List<String> tagsNames = excelBanner.getTagsNames();
            if (tagsNames != null)
                for (String tag : tagsNames)
                    tagsMap.put(tag, new Tag(tag, 0l));
        }

        CampaignTagsInfo campaignTags = new CampaignTagsInfo();
        campaignTags.setCampaignID(campaignId);
        campaignTags.setTags(new ArrayList<Tag>(tagsMap.values()));

        CampaignTagsInfo campaignTagsWihIds = yndexDirectApi.updateCampaignsTags(Arrays.asList(campaignTags))[0];

        for (Tag tag : campaignTagsWihIds.getTags())
            tagsMap.put(tag.getTag(), tag);


        ArrayList<BannerTagsInfo> bannersTagsInfo = new ArrayList<BannerTagsInfo>();

        for (ExcelBanner excelBanner : allBanners) {
            BannerTagsInfo bannerTagsInfo = new BannerTagsInfo();
            bannersTagsInfo.add(bannerTagsInfo);
            bannerTagsInfo.setBannerID(excelBanner.getBannerID());
            List<String> tagsNames = excelBanner.getTagsNames();
            if (tagsNames != null)
                for (String tag : tagsNames) {
                    Long tagID = tagsMap.get(tag).getTagID();
                    bannerTagsInfo.getTags().add(tagID);
                }

        }

        yndexDirectApi.updateBannersTags(bannersTagsInfo);

    }

    private void uploadImages(YndexDirectAPI yndexDirectApi, Long campaignId) {

        List<ExcelBanner> allBanners = getAllBanners();
        Multimap<String, Long> imageUrlBannerIdMap = HashMultimap.create();
        Set<AdImageURL> adImagesURLs = new HashSet<AdImageURL>();

        for (ExcelBanner banner : allBanners) {

            String name = UUID.randomUUID().toString();
            String imageUrl = banner.getImageUrl();
            imageUrl = normalizeUrl(imageUrl);
            Long bannerID = banner.getBannerID();

            if (imageUrl != null) {
                AdImageURL adImageURL = new AdImageURL(name, imageUrl);
                adImagesURLs.add(adImageURL);
                imageUrlBannerIdMap.put(imageUrl, bannerID);
            }

        }


        List<AdImageActionResult> adImageActionResults
                = yndexDirectApi.uploadImage(new ArrayList<AdImageURL>(adImagesURLs));


        Function<AdImageActionResult, Long> actionResultTaskIdFunction = new Function<AdImageActionResult, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable AdImageActionResult adImageActionResult) {
                return adImageActionResult.getAdImageUploadTaskID();
            }

        };

        List<Long> imagesTasksIDs = Lists.transform(adImageActionResults, actionResultTaskIdFunction);
        imagesTasksIDs.removeAll(Collections.singleton(null));


        ImageAssociationTask imageAssociationTask
                = new ImageAssociationTask(yndexDirectApi, imagesTasksIDs, imageUrlBannerIdMap);

        new Thread(imageAssociationTask).start();

    }

    private void moderateBaners(YndexDirectAPI yndexDirectApi, Long campaignId) {

        List<ExcelBanner> banners = getAllBanners();
        List<Long> bannersIds = Lists.transform(banners, extractBannersIdsFunction);
        Long[] bannerIDS =  bannersIds.toArray(new Long[bannersIds.size()]);
        yndexDirectApi.moderateBanners(campaignId, bannerIDS);
    }


    private String normalizeUrl(String imageUrl) {

        if (imageUrl == null)
            return null;

        imageUrl = imageUrl.replace("www\\.", imageUrl);

        return imageUrl;
    }

    public CampaignInfo getCampaignInfo() {
        return campaignInfo;
    }

    public void setCampaignInfo(CampaignInfo campaignInfo) {
        this.campaignInfo = campaignInfo;
    }

    public List<ExcelBanner> getAllBanners() {

        ArrayList<ExcelBanner> allBanners = new ArrayList<ExcelBanner>();
        allBanners.addAll(bannersWithoutGroup);
        allBanners.addAll(bannersWithGroupMultimap.values());
        return allBanners;
    }

    public ArrayListMultimap<Integer, ExcelBanner> getBannersWithGroupMultimap() {
        return bannersWithGroupMultimap;
    }

    public void setBannersWithGroupMultimap(ArrayListMultimap<Integer, ExcelBanner> bannersWithGroupMultimap) {
        this.bannersWithGroupMultimap = bannersWithGroupMultimap;
    }
}
