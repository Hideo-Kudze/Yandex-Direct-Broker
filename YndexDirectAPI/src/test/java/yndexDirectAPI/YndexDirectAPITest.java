package yndexDirectAPI;

import com.HideoKuzeGits.yndexDirectAPI.*;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.*;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by root on 26.06.14.
 */
//GoalIds 4025535960l, 5225120l
public class YndexDirectAPITest {

    private YndexDirectApiFactory yndexDirectApiFactory = new YndexDirectApiFactory();
    private YndexDirectAPI sandboxYndexDirectAPI = yndexDirectApiFactory.createSandboxApi();

    private YndexDirectAPI yndexDirectAPI = new YndexDirectAPI("9635f0e82fc14d98b62fb80292d37d21");
    private Long[] campaignIDS = new Long[]{65081l, 65082l, 65083l};
    private Long[] bannerIDS = new Long[]{764635l, 764636l, 764637l, 764638l, 764639l};
    private long campaignID = 9615143l;
    private long testBanner = 451045204l;
    private String imageHash = "6ze6EE39XPZGze-wgTLLGg";
    private String login = "sbx-hideo-BVuz03";


    @Test
    public void testGetClientInfo() throws Exception {
        Object actualResult = sandboxYndexDirectAPI.getClientInfo(Arrays.asList(login));
        String expected = "\"StatusArch\":\"No\",\"SharedAccountEnabled\":\"No\",\"Discount\":0.0,\"OverdraftSumAvailable\":0.0,\"ClientCurrencies\":[],\"CampaignEmails\":[\"sbx-hideo-BVuz03@yandex.ru\"],\"ClientRights\":[{\"RightName\":\"AllowEditCampaigns\",\"Value\":\"No\"},{\"RightName\":\"AllowTransferMoney\",\"Value\":\"No\"},{\"RightName\":\"AllowImportXLS\",\"Value\":\"No\"}],\"Role\":\"Client\"";
        assertContains(actualResult, expected);
    }

    @Test
    public void testGetCampaignsList() throws Exception {
        ShortCampaignInfo[] actualResult = sandboxYndexDirectAPI.getCampaignsList(Arrays.asList(login));
        assertContains(actualResult,
                "Test API Sandbox campaign 1",
                "Test API Sandbox campaign 2",
                "Test API Sandbox campaign 3");
    }

    @Test
    public void testGetCampaignsListFilter() throws Exception {
        CampaignsFilterInfo campaignsFilter = new CampaignsFilterInfo();
        campaignsFilter.setStatusModerate(Arrays.asList("Yes"));
        GetCampaignsInfo getCampaignsInfo = new GetCampaignsInfo(campaignsFilter);
        getCampaignsInfo.setLogins(Arrays.asList(login));
        ShortCampaignInfo[] actualResult = sandboxYndexDirectAPI.getCampaignsListFilter(getCampaignsInfo);
        String expectedContains = "[{\"CampaignID\":65081,\"Login\":\"sbx-hideo-BVuz03\",\"Name\":\"Test API Sandbox campaign 1\",\"StartDate\":\"2014-07-13\",\"StrategyName\":\"HighestPosition\",\"ContextStrategyName\":\"Default\"";
        assertContains(actualResult, expectedContains);
    }

    @Test
    public void testGetCampaignsParams() throws Exception {
        com.HideoKuzeGits.yndexDirectAPI.wrapClasses.CampaignInfo[] actualResult = sandboxYndexDirectAPI.getCampaignsParams(campaignIDS);

        assertContains(actualResult,
                "Test API Sandbox campaign 1",
                "Test API Sandbox campaign 2",
                "Test API Sandbox campaign 3");
    }

    @Test
    public void testGetCampaignsBanners() throws Exception {
        Object[] actualResult = sandboxYndexDirectAPI.getCampaignBanners(campaignIDS);
        assertContains(actualResult,
                "\"CompanyName\":\"Sandbox company\"",
                "\"BannerID\":764649,\"CampaignID\":65083,\"AdGroupID\":666338,\"PhraseID\":1897334,\"Phrase\":\"test keyword 5.1\",\"IsRubric\":\"No\"",
                "{\"Street\":\"1st street\",\"House\":\"16\",\"City\":\"Moscow\",\"CityCode\":\"812\",\"ContactEmail\":\"sbx-hideo-BVuz03@yandex.ru\"");
    }

    @Test
    public void testGetBanners() throws Exception {
        BannerInfo[] actualResult = sandboxYndexDirectAPI.getBanners(bannerIDS);
        for (BannerInfo bannerInfo : actualResult) {
            bannerInfo.setStatusBannerModerate("Yes");
        }
        assertContains(actualResult,
                "\"MinusKeywords\":[\"minusword1\",\"minusword2\",\"minusword3\"],\"Text\":\"Test sandbox banner 1 text\",\"Title\":\"Test sandbox banner 1\",\"CampaignID\"");
    }

    @Test
    public void testGetCampaignsTags() throws Exception {
        Object actualResult = yndexDirectAPI.getCampaignsTags(9615143l);
        String expected = "{\"CampaignID\":9615143,\"Tags\":[{\"TagID\":1776876,\"Tag\":\"For API Tests\"},{\"TagID\":1776877,\"Tag\":\"For API Tests1\"}]}";
        assertEquals(expected.replace(',', '\n'), actualResult.toString().replace(',', '\n'));
    }

    @Test
    public void testCreateOrUpdateCampaignAndDeleteCampaign() throws Exception {
     /*   CampaignInfo campaignInfo = new CampaignInfo("hideo.kuze.gits"
                , "TestFifo"
                , new CampaignStrategy("HighestPosition")
                , "test"
                , new EmailNotification(15l, 15l, "hideo.kuze.gits@gmail.com"));

        Long createdCampaignID = yndexDirectAPI.createOrUpdateCampaign(campaignInfo);
        String expectedResult = "{\"Status\":\"Draft\",\"IsActive\":\"No\",\"Login\":\"hideo-kuze-gits\",\"Strategy\":{\"StrategyName\":\"HighestPosition\"},\"AddRelevantPhrases\":\"No\",\"TimeTarget\":{\"TimeZone\":\"Europe/Moscow\",\"DaysHours\":[{\"Hours\":[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23],\"Days\":[1,2,3,4,5,6,7]}],\"ShowOnHolidays\":\"Yes\"},\"StatusShow\":\"Yes\",\"Sum\":0,\"StatusMetricaControl\":\"No\",\"AutoOptimization\":\"No\",\"StatusActivating\":\"Pending\",\"StatusContextStop\":\"No\",\"ContextPricePercent\":100,\"RelevantPhrasesBudgetLimit\":100,\"Rest\":0.0,\"EmailNotification\":{\"MoneyWarningValue\":15,\"SendAccNews\":\"No\",\"WarnPlaceInterval\":15,\"SendWarn\":\"No\",\"Email\":\"hideo.kuze.gits@gmail.com\"},\"StatusBehavior\":\"Yes\",\"StatusArchive\":\"No\",\"MinusKeywords\":[],\"StatusOpenStat\":\"No\",\"CampaignID\":0,\"StartDate\":\"\",\"ContextLimit\":\"Default\",\"StatusModerate\":\"New\",\"Clicks\":0,\"FIO\":\"TestFifo\",\"Shows\":0,\"ConsiderTimeTarget\":\"No\",\"SumAvailableForTransfer\":0.0,\"SmsNotification\":{\"MoneyInSms\":\"No\",\"SmsTimeTo\":\"21:00\",\"MoneyOutSms\":\"No\",\"ModerateResultSms\":\"No\",\"SmsTimeFrom\":\"09:00\",\"MetricaSms\":\"No\"},\"Name\":\"test\"}";

        //Set id to 0 because id will change
        CampaignInfo[] campaignsParams = yndexDirectAPI.getCampaignsParams(new Long[]{createdCampaignID});
        campaignsParams[0].setCampaignID(0l);
        campaignsParams[0].setStartDate("");

        assertEquals("CreateOrUpdateCampaign() method fails", expectedResult.replace(',', '\n'), campaignsParams[0].toString().replace(',', '\n'));

        yndexDirectAPI.deleteCampaign(createdCampaignID);

        //If camaing was delete must be thrown exception

        try {
            yndexDirectAPI.getCampaignsParams(new Long[]{createdCampaignID});
            fail("DeleteCampaign() method fails");
        } catch (WrongRequestException e) {
        }
*/

    }

    @Test
    public void testCreateOrUpdateBanners() throws Exception {
    /*    ArrayList<BannerInfo> bannersInfoList = new ArrayList<BannerInfo>();

        ArrayList<BannerPhraseInfo> phrases = new ArrayList<BannerPhraseInfo>();
        phrases.add(new BannerPhraseInfo(0l, "Test phrase 1", 15d));
        phrases.add(new BannerPhraseInfo(0l, "Test phrase 2", 15d));
        phrases.add(new BannerPhraseInfo(0l, "Test phrase 3", 15d));


        long campaignID = 9615143;
        BannerInfo bannerInfo = new BannerInfo(campaignID, "Api Test Banner"
                , "Text text text text text text text text text text"
                , "1"
                , phrases
                , "pikabu.ru");

        bannersInfoList.add(bannerInfo);

        bannerInfo = new BannerInfo(campaignID, "Api Test Banner1"
                , "Text text text text text text text text text text"
                , "1"
                , phrases
                , "pikabu.ru");


        bannersInfoList.add(bannerInfo);

        Long[] bannerIDs = yndexDirectAPI.createOrUpdateBanners(bannersInfoList);

        BannerInfo[] banners = yndexDirectAPI.getCampaignBanners(new Long[]{campaignID});

        String[] expectResultArray = new String[]{"Api Test Banner", "Api Test Banner1"};

        for (BannerInfo banner : banners) {
            banner.setBannerID(0l);
            List<BannerPhraseInfo> phrases1 = banner.getPhrases();
            for (BannerPhraseInfo phrase : phrases1) {
                phrase.setBannerID(0l);
                phrase.setPhraseID(0l);
            }
        }

        String actualResult = Arrays.asList(banners).toString();
        assertContains("\"CreateOrUpdateBanners() method fails\"", actualResult, expectResultArray);
        yndexDirectAPI.deleteBanners(campaignID, bannerIDs);

        try {
            yndexDirectAPI.getBanners(bannerIDs);
            fail("DeleteBanners() method fails");
        } catch (WrongRequestException e) {
        }*/

    }

    @Test
    public void testGetBannerPhrases() throws Exception {
        Object[] actualResult = sandboxYndexDirectAPI.getBannerPhrases(Arrays.asList(bannerIDS));
        String expectedContains = "[{\"BannerID\":764635,\"CampaignID\":65081,\"AdGroupID\":666324,\"PhraseID\":1897305,\"Phrase\":\"test keyword 1.2\",\"IsRubric\":\"No\"";
        assertContains(actualResult, expectedContains);
    }

    @Test
    public void testGetBannerPhrasesFilter() throws Exception {
        BannerPhrasesFilterRequestInfo bannerPhrasesFilterRequest =
                new BannerPhrasesFilterRequestInfo(Arrays.asList(bannerIDS));
        bannerPhrasesFilterRequest.setFieldsNames(Arrays.asList("CampaignID"));
        Object[] actualResult = sandboxYndexDirectAPI.getBannerPhrasesFilter(bannerPhrasesFilterRequest);
        String expectedResult = "[{\"BannerID\":764635,\"CampaignID\":65081,\"PhraseID\":1897305}, {\"BannerID\":764635,\"CampaignID\":65081,\"PhraseID\":1897306}, {\"BannerID\":764636,\"CampaignID\":65081,\"PhraseID\":1897307}, {\"BannerID\":764636,\"CampaignID\":65081,\"PhraseID\":1897308}, {\"BannerID\":764637,\"CampaignID\":65081,\"PhraseID\":1897309}, {\"BannerID\":764637,\"CampaignID\":65081,\"PhraseID\":1897310}, {\"BannerID\":764638,\"CampaignID\":65081,\"PhraseID\":1897311}, {\"BannerID\":764638,\"CampaignID\":65081,\"PhraseID\":1897312}, {\"BannerID\":764639,\"CampaignID\":65081,\"PhraseID\":1897313}, {\"BannerID\":764639,\"CampaignID\":65081,\"PhraseID\":1897314}]";
        assertEquals(expectedResult.replace(',', '\n'), Arrays.asList(actualResult).toString().replace(',', '\n'));
    }

    @Test
    public void testKeyword() throws Exception {
        Object actual = yndexDirectAPI.keyword("Suspend", new Long[]{2395162130l});
        String expected = "{\"ActionsResult\":[{\"Warnings\":[{\"Description\":\"{}\",\"WarningString\":\"Keyword has already been stopped\",\"WarningCode\":212}],\"Errors\":[],\"KeywordID\":2395162130}]}";
        assertEquals(expected.replace(',', '\n'), actual.toString().replace(',', '\n'));
    }

    @Test
    public void testStopCampaign() throws Exception {
        Long result = yndexDirectAPI.stopCampaign(campaignID);
        assertEquals((Long) 1l, result);
        CampaignInfo[] campaignsParams = yndexDirectAPI.getCampaignsParams(new Long[]{campaignID});
        assertEquals("No", campaignsParams[0].getStatusShow());
    }

    @Test
    public void testResumeCampaign() throws Exception {
        Long result = yndexDirectAPI.resumeCampaign(campaignID);
        assertEquals((Long) 1l, result);
        CampaignInfo[] campaignsParams = yndexDirectAPI.getCampaignsParams(new Long[]{campaignID});
        assertEquals("Yes", campaignsParams[0].getStatusShow());
    }

    @Test
    public void testArchiveCampaign() throws Exception {
        Long result = yndexDirectAPI.archiveCampaign(campaignID);
        assertEquals(result, (Long) 1l);
        CampaignInfo[] campaignsParams = yndexDirectAPI.getCampaignsParams(new Long[]{campaignID});
        assertEquals("Yes", campaignsParams[0].getStatusArchive());
    }

    @Test
    public void testUnArchiveCampaign() throws Exception {
        Long result = yndexDirectAPI.unArchiveCampaign(campaignID);
        assertEquals(result, (Long) 1l);
        CampaignInfo[] campaignsParams = yndexDirectAPI.getCampaignsParams(new Long[]{campaignID});
        assertEquals("No", campaignsParams[0].getStatusArchive());
    }

    @Test
    public void testStopBanners() throws Exception {
        Long result = yndexDirectAPI.stopBanners(759136l, new Long[]{testBanner});
        assertEquals(result, (Long) 1l);
        BannerInfo[] bannersInfo = yndexDirectAPI.getBanners(new Long[]{testBanner});
        assertEquals("No", bannersInfo[0].getStatusShow());
    }

    @Test
    public void testResumeBanners() throws Exception {
        Long result = yndexDirectAPI.resumeBanners(759136l, new Long[]{testBanner});
        assertEquals(result, (Long) 1l);
        BannerInfo[] bannersInfo = yndexDirectAPI.getBanners(new Long[]{testBanner});
        assertEquals("Yes", bannersInfo[0].getStatusShow());
    }

    @Test
    public void testArchiveBanners() throws Exception {
        Long result = yndexDirectAPI.archiveBanners(759136l, new Long[]{testBanner});
        assertEquals(result, (Long) 1l);
        BannerInfo[] bannersInfo = yndexDirectAPI.getBanners(new Long[]{testBanner});
        assertEquals("Yes", bannersInfo[0].getStatusArchive());
    }

    @Test
    public void testUnArchiveBanners() throws Exception {
        Long result = yndexDirectAPI.unArchiveBanners(759136l, new Long[]{testBanner});
        assertEquals(result, (Long) 1l);
        BannerInfo[] bannersInfo = yndexDirectAPI.getBanners(new Long[]{testBanner});
        assertEquals("No", bannersInfo[0].getStatusArchive());
    }

    @Test
    public void testUpdatePrices() throws Exception {
      /*  long phraseId = 1897306l;
        long bannerId = bannerIDS[0];
        long campaignID = campaignIDS[0];
        PhrasePriceInfo phrasePriceInfo = new PhrasePriceInfo(campaignID, phraseId);
        Double price = new Random().nextDouble() * 10;
        price = Math.floor(price * 100) / 100;
        phrasePriceInfo.setPrice(price);
        Long result = sandboxYndexDirectAPI.updatePrices(Arrays.asList(phrasePriceInfo));
        assertEquals((Object) 1l, result);
        BannerPhraseInfo[] phrases = sandboxYndexDirectAPI.getBannerPhrases(Arrays.asList(bannerId));
        for (BannerPhraseInfo phrase : phrases)
            if (phrase.getPhraseID() == phraseId) {
                assertEquals(price, phrase.getPrice());
                return;
            }
        fail();*/
    }


    @Test
    public void testSetSinglePrice() throws Exception {
        Double singlePrice = (double) Math.round(new Random().nextDouble() * 10);
        SinglePriceInfo singlePriceInfo = new SinglePriceInfo(campaignIDS[0], singlePrice);
        PhrasePriceInfo[] actualResult = sandboxYndexDirectAPI.setSinglePrice(singlePriceInfo);

        for (PhrasePriceInfo phrasePriceInfo : actualResult) {
            assertEquals(phrasePriceInfo.getPrice(), singlePrice);
        }
    }

    @Test
    public void testSetWizardPrice() throws Exception {
        WizardPriceInfo wizardPriceInfo = new WizardPriceInfo(campaignIDS[0]);
        Float maxPrice = (float) new Random().nextInt(9) + 1;
        wizardPriceInfo.setMaxPrice(maxPrice);
        wizardPriceInfo.setProc(100l);
        wizardPriceInfo.setPriceBase("max");
        wizardPriceInfo.setProcBase("value");
        PhrasePriceInfo[] phrasePricesInfo = sandboxYndexDirectAPI.setWizardPrice(wizardPriceInfo);
        assertContains(phrasePricesInfo, "[{\"BannerID\":764635,\"PhraseID\":1897305,\"CampaignID\":65081,\"Price\":");

    }

    @Test
    public void testGetBalance() throws Exception {
        Object[] actualResult = sandboxYndexDirectAPI.getBalance(Arrays.asList(campaignIDS));
        assertContains(actualResult, "SumAvailableForTransfer", "\"CampaignID\":65082");
    }

    @Test
    public void testCreateNewReportAndGetReportListAndDeleteReport() throws Exception {
        NewReportInfo newReportInfo = new NewReportInfo(campaignIDS[0], "2014-07-01", "2014-07-05");
        Long reportIndex = sandboxYndexDirectAPI.createNewReport(newReportInfo);
        assertNotNull("Method createNewReport() fail. ReportIndex is null.", reportIndex);
        assertNotEquals("Method createNewReport() fail. ReportIndex equals 0l.", reportIndex, (Long) 0l);
        ReportInfo[] reportList = sandboxYndexDirectAPI.getReportList();
        assertContains("Method createNewReport() or getReportList() fail. ReportList don`t contains reportIndex",
                reportList,
                reportIndex.toString());
        Long aLong = sandboxYndexDirectAPI.deleteReport(reportIndex);
        assertEquals("Method deleteReport fails. Return value 0l", aLong, (Object) 1l);
        reportList = sandboxYndexDirectAPI.getReportList();
        assertFalse("Method deleteReport fails. ReportList still contains reportIndex.",
                Arrays.asList(reportList).toString().contains(reportIndex.toString()));
    }

    @Test
    public void testGetSummaryStat() throws Exception {
        GetSummaryStatRequest getSummaryStatRequest = new GetSummaryStatRequest(campaignIDS, "2014-07-11", "2014-07-12");
        Object[] actualResult = sandboxYndexDirectAPI.getSummaryStat(getSummaryStatRequest);
        assertContains(actualResult, "ClicksContext", "\"CampaignID\":64145");
    }

    @Test
    public void testGetBannersStat() throws Exception {
        Thread.sleep(3000);
        NewReportInfo newReportInfo = new NewReportInfo(campaignIDS[0], "2014-04-01", "2014-04-05");
        Object actualResult = sandboxYndexDirectAPI.getBannersStat(newReportInfo);
        assertContains(actualResult, "{\"EndDate\":\"2014-04-05\",\"Stat\"");
    }

    @Test
    public void testCreateNewWordstatReportAndDeleteWordstatReportAndwordstatReportStatusInfo() throws Exception {
        NewWordstatReportInfo newWordstatReportInfo
                = new NewWordstatReportInfo(Arrays.asList("купить", "термос", "припой"));
        Long reportIndex = sandboxYndexDirectAPI.createNewWordstatReport(newWordstatReportInfo);
        assertNotNull("Method createNewWordstatReport() fail. ReportIndex is null.", reportIndex);
        assertNotEquals("Method createNewWordstatReport() fail. ReportIndex equals 0l.", reportIndex, (Long) 0l);
        WordstatReportStatusInfo[] reportList = sandboxYndexDirectAPI.getWordstatReportList();
        assertContains("Method createNewWordstatReport() or getReportList() fail. ReportList don`t contains reportIndex",
                reportList, reportIndex.toString());
        Long aLong = sandboxYndexDirectAPI.deleteWordstatReport(reportIndex);
        assertEquals("Method deleteWordstatReport fails. Return value 0l", aLong, (Object) 1l);
        reportList = sandboxYndexDirectAPI.getWordstatReportList();
        assertFalse("Method deleteWordstatReport fails. ReportList still contains reportIndex.",
                Arrays.asList(reportList).toString().contains(reportIndex.toString()));
    }

    @Test
    public void testGetWordstatReport() throws Exception {
        NewWordstatReportInfo newWordstatReportInfo
                = new NewWordstatReportInfo(Arrays.asList("купить", "припой"));
        newWordstatReportInfo.setGeoID(Arrays.asList(37l, 30l));
        Long reportIndex = sandboxYndexDirectAPI.createNewWordstatReport(newWordstatReportInfo);
        Thread.sleep(1000);
        boolean flag = true;
        while (flag)
            try {
                WordstatReportInfo[] actualResult = sandboxYndexDirectAPI.getWordstatReport(reportIndex);
                flag = false;
                String actualResultString = Arrays.asList(actualResult).toString();
                assertContains((Object) actualResultString,
                        "{\"Phrase\":\"купить\",\"GeoID\":[37,30],\"SearchedWith\":[{\"Phrase\":\"купить\"");
            } catch (WrongRequestException e) {
            }
        sandboxYndexDirectAPI.deleteWordstatReport(reportIndex);
    }

    @Test
    public void testGetKeywordsSuggestion() throws Exception {
        String[] actualResult
                = sandboxYndexDirectAPI.getKeywordsSuggestion(new String[]{"купить", "припой"});
        String expectedResult = "[test keyword 1, test keyword 2, test keyword 3, test keyword 4, test keyword 5, test keyword 6, test keyword 7, test keyword 8, test keyword 9, test keyword 10, test keyword 11, test keyword 12, test keyword 13, test keyword 14, test keyword 15, test keyword 16, test keyword 17, test keyword 18, test keyword 19, test keyword 20]";
        assertEquals(expectedResult.replace(',', '\n'), Arrays.asList(actualResult).toString().replace(',', '\n'));
    }

    @Test
    public void testGetRegions() throws Exception {
        Object[] actualResult =
                sandboxYndexDirectAPI.getRegions();
        String expectedResult = "[{\"RegionID\":0,\"RegionName\":\"All\"}, {\"RegionType\":\"Continent\",\"ParentID\":0,\"RegionID\":111,\"RegionName\":\"Europe\"}, {\"RegionType\":\"Continent\",\"ParentID\":0,\"RegionID\":138,\"RegionName\":\"Australia and Oceania\"}, {\"RegionType\":\"Region\",\"ParentID\":0,\"RegionID\":166,\"RegionName\":\"CIS (except Russia)\"}, {\"RegionType\":\"Continent\",\"ParentID\":0,\"RegionID\":183,\"RegionName\":\"Asia\"}, {\"RegionType\":\"Country\",\"ParentID\":0,\"RegionID\":225,\"RegionName\":\"Russia\"}, {\"RegionType\":\"Continent\",\"ParentID\":0,\"RegionID\":241,\"RegionName\":\"Africa\"}, {\"RegionType\":\"Continent\",\"ParentID\":0,\"RegionID\":10002,\"RegionName\":\"North America\"}, {\"RegionType\":\"Continent\",\"ParentID\":0,\"RegionID\":10003,\"RegionName\":\"South America\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":213,\"RegionName\":\"Moscow\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":214,\"RegionName\":\"Dolgoprudniy\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":215,\"RegionName\":\"Dubna\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":217,\"RegionName\":\"Pushino\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":219,\"RegionName\":\"Chernogolovka\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":10716,\"RegionName\":\"Balashiha\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":10722,\"RegionName\":\"Voskresensk\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":10723,\"RegionName\":\"Dmitrov\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":10734,\"RegionName\":\"Kolomna\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":10735,\"RegionName\":\"Krasnogorsk\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":10739,\"RegionName\":\"Mozhaysk\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":10745,\"RegionName\":\"Orehovo-Zuevo\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":10747,\"RegionName\":\"Podolsk\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":10750,\"RegionName\":\"Ramenskoe\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":10752,\"RegionName\":\"Sergiev Posad\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":10754,\"RegionName\":\"Serpuhov\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":10765,\"RegionName\":\"Shelkovo\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":20571,\"RegionName\":\"Zhukovskiy\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":20728,\"RegionName\":\"Korolev\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":21619,\"RegionName\":\"Fryazino\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":21620,\"RegionName\":\"Yubileyny\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":21622,\"RegionName\":\"Zheleznodorozhny\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":21623,\"RegionName\":\"Ivanteevka\"}, {\"RegionType\":\"City\",\"ParentID\":1,\"RegionID\":37147,\"RegionName\":\"Klimovsk\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":3,\"RegionID\":1,\"RegionName\":\"Moscow and Moscow region\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":3,\"RegionID\":10645,\"RegionName\":\"Belgorod District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":3,\"RegionID\":10650,\"RegionName\":\"Bryansk District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":3,\"RegionID\":10658,\"RegionName\":\"Vladimir District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":3,\"RegionID\":10672,\"RegionName\":\"Voronezh District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":3,\"RegionID\":10687,\"RegionName\":\"Ivanovo district\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":3,\"RegionID\":10693,\"RegionName\":\"Kaluga District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":3,\"RegionID\":10699,\"RegionName\":\"Kostroma District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":3,\"RegionID\":10705,\"RegionName\":\"Kursk District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":3,\"RegionID\":10712,\"RegionName\":\"Lipetsk District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":3,\"RegionID\":10772,\"RegionName\":\"Orel District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":3,\"RegionID\":10776,\"RegionName\":\"Ryazhan District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":3,\"RegionID\":10795,\"RegionName\":\"Smolensk District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":3,\"RegionID\":10802,\"RegionName\":\"Tambov District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":3,\"RegionID\":10819,\"RegionName\":\"Tver District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":3,\"RegionID\":10832,\"RegionName\":\"Tula District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":3,\"RegionID\":10841,\"RegionName\":\"Yaroslavl District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":17,\"RegionID\":10174,\"RegionName\":\"Saint-Petersburg and Leningradskaya oblast\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":17,\"RegionID\":10176,\"RegionName\":\"Nenets Autonomous Okrug\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":17,\"RegionID\":10842,\"RegionName\":\"Arkhangelsk District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":17,\"RegionID\":10853,\"RegionName\":\"Vologda District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":17,\"RegionID\":10857,\"RegionName\":\"Kaliningrad District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":17,\"RegionID\":10897,\"RegionName\":\"Murmansk District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":17,\"RegionID\":10904,\"RegionName\":\"Novgorod District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":17,\"RegionID\":10926,\"RegionName\":\"Pskov District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":17,\"RegionID\":10933,\"RegionName\":\"Respublika Kareliya\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":17,\"RegionID\":10939,\"RegionName\":\"Respublika Komi\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":26,\"RegionID\":10946,\"RegionName\":\"Astrakhan District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":26,\"RegionID\":10950,\"RegionName\":\"Volgograd District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":26,\"RegionID\":10995,\"RegionName\":\"Krasnodar Krai\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":26,\"RegionID\":11004,\"RegionName\":\"The Republic of Adygea\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":26,\"RegionID\":11015,\"RegionName\":\"The Republic of Kalmykia\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":26,\"RegionID\":11029,\"RegionName\":\"Rostov District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":40,\"RegionID\":11070,\"RegionName\":\"Kirov District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":40,\"RegionID\":11077,\"RegionName\":\"Mariy El\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":40,\"RegionID\":11079,\"RegionName\":\"Nizhny Novgorod District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":40,\"RegionID\":11084,\"RegionName\":\"Orenburg District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":40,\"RegionID\":11095,\"RegionName\":\"Penza District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":40,\"RegionID\":11108,\"RegionName\":\"Perm District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":40,\"RegionID\":11111,\"RegionName\":\"Bashkortostan\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":40,\"RegionID\":11117,\"RegionName\":\"Mordovia\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":40,\"RegionID\":11119,\"RegionName\":\"Tatarstan\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":40,\"RegionID\":11131,\"RegionName\":\"Samara District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":40,\"RegionID\":11146,\"RegionName\":\"Saratov District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":40,\"RegionID\":11148,\"RegionName\":\"Udmurtiya\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":40,\"RegionID\":11153,\"RegionName\":\"Ulyanovsk District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":40,\"RegionID\":11156,\"RegionName\":\"Chuvashiya\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":52,\"RegionID\":11158,\"RegionName\":\"Kurgan District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":52,\"RegionID\":11162,\"RegionName\":\"Sverdlov District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":52,\"RegionID\":11176,\"RegionName\":\"Tyumen District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":52,\"RegionID\":11193,\"RegionName\":\"Khanty-Mansi Autonomous Okrug\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":52,\"RegionID\":11225,\"RegionName\":\"Chelyabinsk District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":52,\"RegionID\":11232,\"RegionName\":\"Yamalo-Nenets Autonomous Okrug \"}, {\"RegionType\":\"Administrative area\",\"ParentID\":59,\"RegionID\":10231,\"RegionName\":\"Altai Republic\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":59,\"RegionID\":10233,\"RegionName\":\"Tyva Republic\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":59,\"RegionID\":11235,\"RegionName\":\"Altai Krai\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":59,\"RegionID\":11266,\"RegionName\":\"Irkutsk District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":59,\"RegionID\":11282,\"RegionName\":\"Kemerovo District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":59,\"RegionID\":11309,\"RegionName\":\"Krasnoyarsk Krai\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":59,\"RegionID\":11316,\"RegionName\":\"Novosibirsk District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":59,\"RegionID\":11318,\"RegionName\":\"Omsk District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":59,\"RegionID\":11330,\"RegionName\":\"Buryat Republic\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":59,\"RegionID\":11340,\"RegionName\":\"Republic of Khakassia\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":59,\"RegionID\":11353,\"RegionName\":\"Tomsk District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":59,\"RegionID\":21949,\"RegionName\":\"Zabaykalsky Krai\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":73,\"RegionID\":10243,\"RegionName\":\"Jewish Autonomous Region\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":73,\"RegionID\":10251,\"RegionName\":\"Chukotka Autonomous Okrug\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":73,\"RegionID\":11375,\"RegionName\":\"Amursk District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":73,\"RegionID\":11398,\"RegionName\":\"Kamchatka Krai\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":73,\"RegionID\":11403,\"RegionName\":\"Magadan District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":73,\"RegionID\":11409,\"RegionName\":\"Primorie\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":73,\"RegionID\":11443,\"RegionName\":\"The Sakha (Yakutia) Republic\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":73,\"RegionID\":11450,\"RegionName\":\"Sakhalin District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":73,\"RegionID\":11457,\"RegionName\":\"Khabarovsk Krai\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":96,\"RegionName\":\"Germany\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":102,\"RegionName\":\"United Kingdom\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":113,\"RegionName\":\"Austria\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":114,\"RegionName\":\"Belgium\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":115,\"RegionName\":\"Bulgaria\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":116,\"RegionName\":\"Hungary\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":118,\"RegionName\":\"Netherlands\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":119,\"RegionName\":\"Norway\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":120,\"RegionName\":\"Poland\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":121,\"RegionName\":\"Slovakia\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":122,\"RegionName\":\"Slovenia\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":123,\"RegionName\":\"Finland\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":124,\"RegionName\":\"France\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":125,\"RegionName\":\"Czech Republic\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":126,\"RegionName\":\"Switzerland\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":127,\"RegionName\":\"Sweden\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":180,\"RegionName\":\"Serbia\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":203,\"RegionName\":\"Denmark\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":204,\"RegionName\":\"Spain\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":205,\"RegionName\":\"Italy\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":246,\"RegionName\":\"Greece\"}, {\"RegionType\":\"Region\",\"ParentID\":111,\"RegionID\":980,\"RegionName\":\"Baltic\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":983,\"RegionName\":\"Turkey\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":10083,\"RegionName\":\"Croatia\"}, {\"RegionType\":\"Country\",\"ParentID\":111,\"RegionID\":20574,\"RegionName\":\"Cyprus\"}, {\"RegionType\":\"Country\",\"ParentID\":138,\"RegionID\":139,\"RegionName\":\"New Zealand\"}, {\"RegionType\":\"Country\",\"ParentID\":138,\"RegionID\":211,\"RegionName\":\"Australia\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":149,\"RegionID\":29629,\"RegionName\":\"Moguilev District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":149,\"RegionID\":29630,\"RegionName\":\"Minsk District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":149,\"RegionID\":29631,\"RegionName\":\"Gomel District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":149,\"RegionID\":29632,\"RegionName\":\"Brest District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":149,\"RegionID\":29633,\"RegionName\":\"Vitebsk District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":149,\"RegionID\":29634,\"RegionName\":\"Grodno District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":159,\"RegionID\":29403,\"RegionName\":\"Akmolinsk District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":159,\"RegionID\":29404,\"RegionName\":\"Aktubinsk District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":159,\"RegionID\":29406,\"RegionName\":\"Alma-Ata District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":159,\"RegionID\":29407,\"RegionName\":\"Atyrau District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":159,\"RegionID\":29408,\"RegionName\":\"East-Kazakhstan District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":159,\"RegionID\":29409,\"RegionName\":\"Zhambylsk District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":159,\"RegionID\":29410,\"RegionName\":\"West-Kazakhstan District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":159,\"RegionID\":29411,\"RegionName\":\"Karaganda District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":159,\"RegionID\":29412,\"RegionName\":\"Kostanai District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":159,\"RegionID\":29413,\"RegionName\":\"Kyzylorda District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":159,\"RegionID\":29414,\"RegionName\":\"Mangystau District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":159,\"RegionID\":29415,\"RegionName\":\"Pavlodar District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":159,\"RegionID\":29416,\"RegionName\":\"North-Kazakhstan District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":159,\"RegionID\":29417,\"RegionName\":\"South-Kazakhstan District\"}, {\"RegionType\":\"Country\",\"ParentID\":166,\"RegionID\":149,\"RegionName\":\"Belarus\"}, {\"RegionType\":\"Country\",\"ParentID\":166,\"RegionID\":159,\"RegionName\":\"Kazakhstan\"}, {\"RegionType\":\"Country\",\"ParentID\":166,\"RegionID\":167,\"RegionName\":\"Azerbaijan\"}, {\"RegionType\":\"Country\",\"ParentID\":166,\"RegionID\":168,\"RegionName\":\"Armenia\"}, {\"RegionType\":\"Country\",\"ParentID\":166,\"RegionID\":170,\"RegionName\":\"Turkmenistan\"}, {\"RegionType\":\"Country\",\"ParentID\":166,\"RegionID\":171,\"RegionName\":\"Uzbekistan\"}, {\"RegionType\":\"Country\",\"ParentID\":166,\"RegionID\":187,\"RegionName\":\"Ukraine\"}, {\"RegionType\":\"Country\",\"ParentID\":166,\"RegionID\":207,\"RegionName\":\"Kyrgyzstan\"}, {\"RegionType\":\"Country\",\"ParentID\":166,\"RegionID\":208,\"RegionName\":\"Moldova\"}, {\"RegionType\":\"Country\",\"ParentID\":166,\"RegionID\":209,\"RegionName\":\"Tajikistan\"}, {\"RegionType\":\"Country\",\"ParentID\":166,\"RegionID\":29386,\"RegionName\":\"Abkhasia\"}, {\"RegionType\":\"Country\",\"ParentID\":183,\"RegionID\":134,\"RegionName\":\"China\"}, {\"RegionType\":\"Country\",\"ParentID\":183,\"RegionID\":135,\"RegionName\":\"South Korea\"}, {\"RegionType\":\"Country\",\"ParentID\":183,\"RegionID\":137,\"RegionName\":\"Japan\"}, {\"RegionType\":\"Country\",\"ParentID\":183,\"RegionID\":169,\"RegionName\":\"Georgia\"}, {\"RegionType\":\"Country\",\"ParentID\":183,\"RegionID\":994,\"RegionName\":\"India\"}, {\"RegionType\":\"Country\",\"ParentID\":183,\"RegionID\":995,\"RegionName\":\"Thailand\"}, {\"RegionType\":\"Region\",\"ParentID\":183,\"RegionID\":1004,\"RegionName\":\"Middle East\"}, {\"RegionType\":\"Country\",\"ParentID\":183,\"RegionID\":20975,\"RegionName\":\"Cambodia\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":187,\"RegionID\":977,\"RegionName\":\"Krim\"}, {\"RegionType\":\"Region\",\"ParentID\":187,\"RegionID\":20524,\"RegionName\":\"West\"}, {\"RegionType\":\"Region\",\"ParentID\":187,\"RegionID\":20525,\"RegionName\":\"East\"}, {\"RegionType\":\"Region\",\"ParentID\":187,\"RegionID\":20526,\"RegionName\":\"South\"}, {\"RegionType\":\"Region\",\"ParentID\":187,\"RegionID\":20527,\"RegionName\":\"Centre\"}, {\"RegionType\":\"Region\",\"ParentID\":187,\"RegionID\":20528,\"RegionName\":\"North\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":225,\"RegionID\":3,\"RegionName\":\"Central\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":225,\"RegionID\":17,\"RegionName\":\"Northwest\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":225,\"RegionID\":26,\"RegionName\":\"South\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":225,\"RegionID\":40,\"RegionName\":\"Volga Region\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":225,\"RegionID\":52,\"RegionName\":\"Ural\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":225,\"RegionID\":59,\"RegionName\":\"Siberian\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":225,\"RegionID\":73,\"RegionName\":\"Far East\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":225,\"RegionID\":102444,\"RegionName\":\"North Kavkaz\"}, {\"RegionType\":\"City\",\"ParentID\":977,\"RegionID\":146,\"RegionName\":\"Simferopol\"}, {\"RegionType\":\"City\",\"ParentID\":977,\"RegionID\":959,\"RegionName\":\"Sevastopol\"}, {\"RegionType\":\"City\",\"ParentID\":977,\"RegionID\":11463,\"RegionName\":\"Evpatoria\"}, {\"RegionType\":\"City\",\"ParentID\":977,\"RegionID\":11464,\"RegionName\":\"Kerch\"}, {\"RegionType\":\"City\",\"ParentID\":977,\"RegionID\":11469,\"RegionName\":\"Feodosia\"}, {\"RegionType\":\"City\",\"ParentID\":977,\"RegionID\":11470,\"RegionName\":\"Yalta\"}, {\"RegionType\":\"Country\",\"ParentID\":980,\"RegionID\":117,\"RegionName\":\"Lithuania\"}, {\"RegionType\":\"Country\",\"ParentID\":980,\"RegionID\":179,\"RegionName\":\"Estonia\"}, {\"RegionType\":\"Country\",\"ParentID\":980,\"RegionID\":206,\"RegionName\":\"Latvia\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103668,\"RegionName\":\"Agri\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103669,\"RegionName\":\"Adana\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103670,\"RegionName\":\"Adiyaman\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103671,\"RegionName\":\"Aydin\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103672,\"RegionName\":\"Aksaray\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103673,\"RegionName\":\"Amasya\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103674,\"RegionName\":\"Ankara\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103675,\"RegionName\":\"Antalya\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103676,\"RegionName\":\"Ardahan\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103677,\"RegionName\":\"Artvin\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103678,\"RegionName\":\"Afyonkarahisar\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103679,\"RegionName\":\"Bayburt\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103680,\"RegionName\":\"Balikesir\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103681,\"RegionName\":\"Bartin\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103682,\"RegionName\":\"Batman\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103683,\"RegionName\":\"Bilecik\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103684,\"RegionName\":\"Bingöl \"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103685,\"RegionName\":\"Bitlis\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103686,\"RegionName\":\"Bolu\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103687,\"RegionName\":\"Burdur\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103688,\"RegionName\":\"Bursa\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103689,\"RegionName\":\"Van\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103690,\"RegionName\":\"Gaziantep\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103691,\"RegionName\":\"Giresun\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103692,\"RegionName\":\"Gümüşhane\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103693,\"RegionName\":\"Denizli\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103694,\"RegionName\":\"Diyarbakir\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103695,\"RegionName\":\"Duezce\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103696,\"RegionName\":\"Zonguldak\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103697,\"RegionName\":\"Izmir\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103698,\"RegionName\":\"Yozgat\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103699,\"RegionName\":\"Kayseri\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103700,\"RegionName\":\"Karabuk\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103701,\"RegionName\":\"Karaman\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103702,\"RegionName\":\"Kars\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103703,\"RegionName\":\"Kastamonu\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103704,\"RegionName\":\"Kahramanmaras\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103705,\"RegionName\":\"Kilis\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103706,\"RegionName\":\"Kocaeli\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103707,\"RegionName\":\"Konya\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103708,\"RegionName\":\"Kirklareli\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103709,\"RegionName\":\"Kirsehir\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103710,\"RegionName\":\"Kirikkale\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103711,\"RegionName\":\"Kütahya \"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103712,\"RegionName\":\"Malatya\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103713,\"RegionName\":\"Manisa\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103714,\"RegionName\":\"Mardin\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103715,\"RegionName\":\"Mersin\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103716,\"RegionName\":\"Mugla\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103717,\"RegionName\":\"Mus\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103718,\"RegionName\":\"Nevsehir\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103719,\"RegionName\":\"Nigde\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103720,\"RegionName\":\"Ordu\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103721,\"RegionName\":\"Osmaniye\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103722,\"RegionName\":\"Rize\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103723,\"RegionName\":\"Sakarya\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103724,\"RegionName\":\"Samsun\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103725,\"RegionName\":\"Sivas\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103726,\"RegionName\":\"Siirt\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103727,\"RegionName\":\"Sinop\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103728,\"RegionName\":\"Istanbul\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103729,\"RegionName\":\"Tekirdag\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103730,\"RegionName\":\"Tokat\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103731,\"RegionName\":\"Trabzon\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103732,\"RegionName\":\"Tunceli\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103733,\"RegionName\":\"Usak\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103734,\"RegionName\":\"Hakkâri\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103735,\"RegionName\":\"Hatay\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103736,\"RegionName\":\"Canakkale\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103737,\"RegionName\":\"Cankiri\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103738,\"RegionName\":\"Corum\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103739,\"RegionName\":\"Sanliurfa\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103740,\"RegionName\":\"Sirnak\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103741,\"RegionName\":\"Igdir\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103742,\"RegionName\":\"Isparta\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103743,\"RegionName\":\"Edirne\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103744,\"RegionName\":\"Elazig\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103745,\"RegionName\":\"Erzincan\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103746,\"RegionName\":\"Erzurum\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103747,\"RegionName\":\"Eskisehir\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":983,\"RegionID\":103748,\"RegionName\":\"Yalova\"}, {\"RegionType\":\"Country\",\"ParentID\":1004,\"RegionID\":181,\"RegionName\":\"Israel\"}, {\"RegionType\":\"Country\",\"ParentID\":1004,\"RegionID\":210,\"RegionName\":\"United Arab Emirates\"}, {\"RegionType\":\"Country\",\"ParentID\":1004,\"RegionID\":1056,\"RegionName\":\"Egypt\"}, {\"RegionType\":\"Country\",\"ParentID\":10002,\"RegionID\":84,\"RegionName\":\"United States\"}, {\"RegionType\":\"Country\",\"ParentID\":10002,\"RegionID\":95,\"RegionName\":\"Canada\"}, {\"RegionType\":\"Country\",\"ParentID\":10003,\"RegionID\":93,\"RegionName\":\"Argentina\"}, {\"RegionType\":\"Country\",\"ParentID\":10003,\"RegionID\":94,\"RegionName\":\"Brazil\"}, {\"RegionType\":\"City\",\"ParentID\":10174,\"RegionID\":2,\"RegionName\":\"Saint Petersburg\"}, {\"RegionType\":\"City\",\"ParentID\":10174,\"RegionID\":969,\"RegionName\":\"Vyborg\"}, {\"RegionType\":\"City\",\"ParentID\":10174,\"RegionID\":10864,\"RegionName\":\"Volhov\"}, {\"RegionType\":\"City\",\"ParentID\":10174,\"RegionID\":10865,\"RegionName\":\"Vsevolgsk\"}, {\"RegionType\":\"City\",\"ParentID\":10174,\"RegionID\":10867,\"RegionName\":\"Gatchina\"}, {\"RegionType\":\"City\",\"ParentID\":10174,\"RegionID\":10871,\"RegionName\":\"Kirishi\"}, {\"RegionType\":\"City\",\"ParentID\":10174,\"RegionID\":10891,\"RegionName\":\"Sosnoviy Bor\"}, {\"RegionType\":\"City\",\"ParentID\":10174,\"RegionID\":10892,\"RegionName\":\"Tikhvin\"}, {\"RegionType\":\"City\",\"ParentID\":10645,\"RegionID\":4,\"RegionName\":\"Belgorod\"}, {\"RegionType\":\"City\",\"ParentID\":10645,\"RegionID\":10649,\"RegionName\":\"Stariy Oskol\"}, {\"RegionType\":\"City\",\"ParentID\":10658,\"RegionID\":192,\"RegionName\":\"Vladimir\"}, {\"RegionType\":\"City\",\"ParentID\":10658,\"RegionID\":10664,\"RegionName\":\"Kovrov\"}, {\"RegionType\":\"City\",\"ParentID\":10658,\"RegionID\":10668,\"RegionName\":\"Murom\"}, {\"RegionType\":\"City\",\"ParentID\":10693,\"RegionID\":6,\"RegionName\":\"Kaluga\"}, {\"RegionType\":\"City\",\"ParentID\":10693,\"RegionID\":967,\"RegionName\":\"Obninsk\"}, {\"RegionType\":\"City\",\"ParentID\":10705,\"RegionID\":8,\"RegionName\":\"Kursk\"}, {\"RegionType\":\"City\",\"ParentID\":10705,\"RegionID\":10710,\"RegionName\":\"Zheleznogorsk\"}, {\"RegionType\":\"City\",\"ParentID\":10832,\"RegionID\":15,\"RegionName\":\"Tula\"}, {\"RegionType\":\"City\",\"ParentID\":10832,\"RegionID\":10830,\"RegionName\":\"Novomoskovsk\"}, {\"RegionType\":\"City\",\"ParentID\":10841,\"RegionID\":16,\"RegionName\":\"Yaroslavl\"}, {\"RegionType\":\"City\",\"ParentID\":10841,\"RegionID\":10839,\"RegionName\":\"Rybinsk\"}, {\"RegionType\":\"City\",\"ParentID\":10841,\"RegionID\":21154,\"RegionName\":\"Tutaev\"}, {\"RegionType\":\"City\",\"ParentID\":10842,\"RegionID\":20,\"RegionName\":\"Arhangelsk\"}, {\"RegionType\":\"City\",\"ParentID\":10842,\"RegionID\":10849,\"RegionName\":\"Severodvinsk\"}, {\"RegionType\":\"City\",\"ParentID\":10853,\"RegionID\":21,\"RegionName\":\"Vologda\"}, {\"RegionType\":\"City\",\"ParentID\":10853,\"RegionID\":968,\"RegionName\":\"Cherepovets\"}, {\"RegionType\":\"City\",\"ParentID\":10897,\"RegionID\":23,\"RegionName\":\"Murmansk\"}, {\"RegionType\":\"City\",\"ParentID\":10897,\"RegionID\":10894,\"RegionName\":\"Apatity\"}, {\"RegionType\":\"City\",\"ParentID\":10926,\"RegionID\":25,\"RegionName\":\"Pskov\"}, {\"RegionType\":\"City\",\"ParentID\":10926,\"RegionID\":10928,\"RegionName\":\"Velikie Luky\"}, {\"RegionType\":\"City\",\"ParentID\":10933,\"RegionID\":18,\"RegionName\":\"Petrozavodsk\"}, {\"RegionType\":\"City\",\"ParentID\":10933,\"RegionID\":10934,\"RegionName\":\"Kondopoga\"}, {\"RegionType\":\"City\",\"ParentID\":10933,\"RegionID\":10937,\"RegionName\":\"Sortavala\"}, {\"RegionType\":\"City\",\"ParentID\":10939,\"RegionID\":19,\"RegionName\":\"Syktyvkar\"}, {\"RegionType\":\"City\",\"ParentID\":10939,\"RegionID\":10940,\"RegionName\":\"Vorkuta\"}, {\"RegionType\":\"City\",\"ParentID\":10939,\"RegionID\":10944,\"RegionName\":\"Usinsk\"}, {\"RegionType\":\"City\",\"ParentID\":10939,\"RegionID\":10945,\"RegionName\":\"Uhta\"}, {\"RegionType\":\"City\",\"ParentID\":10950,\"RegionID\":38,\"RegionName\":\"Volgograd\"}, {\"RegionType\":\"City\",\"ParentID\":10950,\"RegionID\":10951,\"RegionName\":\"Volzhskiy\"}, {\"RegionType\":\"City\",\"ParentID\":10950,\"RegionID\":10959,\"RegionName\":\"Kamishin\"}, {\"RegionType\":\"City\",\"ParentID\":10995,\"RegionID\":35,\"RegionName\":\"Krasnodar\"}, {\"RegionType\":\"City\",\"ParentID\":10995,\"RegionID\":239,\"RegionName\":\"Sochi\"}, {\"RegionType\":\"City\",\"ParentID\":10995,\"RegionID\":970,\"RegionName\":\"Novorossiysk\"}, {\"RegionType\":\"City\",\"ParentID\":10995,\"RegionID\":1058,\"RegionName\":\"Tuapse\"}, {\"RegionType\":\"City\",\"ParentID\":10995,\"RegionID\":1107,\"RegionName\":\"Anapa\"}, {\"RegionType\":\"City\",\"ParentID\":10995,\"RegionID\":10987,\"RegionName\":\"Armavir\"}, {\"RegionType\":\"City\",\"ParentID\":10995,\"RegionID\":10993,\"RegionName\":\"Yesk\"}, {\"RegionType\":\"City\",\"ParentID\":11029,\"RegionID\":39,\"RegionName\":\"Rostov-na-Donu\"}, {\"RegionType\":\"City\",\"ParentID\":11029,\"RegionID\":238,\"RegionName\":\"Novocherkassk\"}, {\"RegionType\":\"City\",\"ParentID\":11029,\"RegionID\":971,\"RegionName\":\"Taganrog\"}, {\"RegionType\":\"City\",\"ParentID\":11029,\"RegionID\":11036,\"RegionName\":\"Volgodonsk\"}, {\"RegionType\":\"City\",\"ParentID\":11029,\"RegionID\":11043,\"RegionName\":\"Kamensk-Shakhtinsky\"}, {\"RegionType\":\"City\",\"ParentID\":11029,\"RegionID\":11053,\"RegionName\":\"Shakhty\"}, {\"RegionType\":\"City\",\"ParentID\":11069,\"RegionID\":36,\"RegionName\":\"Stavropol\"}, {\"RegionType\":\"City\",\"ParentID\":11069,\"RegionID\":11057,\"RegionName\":\"Essentuky\"}, {\"RegionType\":\"City\",\"ParentID\":11069,\"RegionID\":11062,\"RegionName\":\"Kislovodsk\"}, {\"RegionType\":\"City\",\"ParentID\":11069,\"RegionID\":11063,\"RegionName\":\"Mineralniye Vodi\"}, {\"RegionType\":\"City\",\"ParentID\":11069,\"RegionID\":11064,\"RegionName\":\"Nevinnomissk\"}, {\"RegionType\":\"City\",\"ParentID\":11069,\"RegionID\":11067,\"RegionName\":\"Pyatigorsk\"}, {\"RegionType\":\"City\",\"ParentID\":11079,\"RegionID\":47,\"RegionName\":\"Nizhny Novgorod\"}, {\"RegionType\":\"City\",\"ParentID\":11079,\"RegionID\":972,\"RegionName\":\"Dzerzhinsk\"}, {\"RegionType\":\"City\",\"ParentID\":11079,\"RegionID\":11083,\"RegionName\":\"Sarov\"}, {\"RegionType\":\"City\",\"ParentID\":11079,\"RegionID\":20040,\"RegionName\":\"Vyksa\"}, {\"RegionType\":\"City\",\"ParentID\":11079,\"RegionID\":20044,\"RegionName\":\"Kstovo\"}, {\"RegionType\":\"City\",\"ParentID\":11084,\"RegionID\":48,\"RegionName\":\"Orenburg\"}, {\"RegionType\":\"City\",\"ParentID\":11084,\"RegionID\":11091,\"RegionName\":\"Orsk\"}, {\"RegionType\":\"City\",\"ParentID\":11108,\"RegionID\":50,\"RegionName\":\"Perm\"}, {\"RegionType\":\"City\",\"ParentID\":11108,\"RegionID\":20237,\"RegionName\":\"Berezniki\"}, {\"RegionType\":\"City\",\"ParentID\":11111,\"RegionID\":172,\"RegionName\":\"Ufa\"}, {\"RegionType\":\"City\",\"ParentID\":11111,\"RegionID\":11114,\"RegionName\":\"Nephtekamsk\"}, {\"RegionType\":\"City\",\"ParentID\":11111,\"RegionID\":11115,\"RegionName\":\"Salavat\"}, {\"RegionType\":\"City\",\"ParentID\":11111,\"RegionID\":11116,\"RegionName\":\"Sterlitamak\"}, {\"RegionType\":\"City\",\"ParentID\":11111,\"RegionID\":20235,\"RegionName\":\"Oktyabrsky\"}, {\"RegionType\":\"City\",\"ParentID\":11119,\"RegionID\":43,\"RegionName\":\"Kazan\"}, {\"RegionType\":\"City\",\"ParentID\":11119,\"RegionID\":236,\"RegionName\":\"Naberezhnie Chelny\"}, {\"RegionType\":\"City\",\"ParentID\":11119,\"RegionID\":11121,\"RegionName\":\"Almetyevsk\"}, {\"RegionType\":\"City\",\"ParentID\":11119,\"RegionID\":11122,\"RegionName\":\"Bugulma\"}, {\"RegionType\":\"City\",\"ParentID\":11119,\"RegionID\":11127,\"RegionName\":\"Nizhnekamsk\"}, {\"RegionType\":\"City\",\"ParentID\":11131,\"RegionID\":51,\"RegionName\":\"Samara\"}, {\"RegionType\":\"City\",\"ParentID\":11131,\"RegionID\":240,\"RegionName\":\"Togliatti\"}, {\"RegionType\":\"City\",\"ParentID\":11131,\"RegionID\":11132,\"RegionName\":\"Zhiguliovsk\"}, {\"RegionType\":\"City\",\"ParentID\":11131,\"RegionID\":11139,\"RegionName\":\"Sizran\"}, {\"RegionType\":\"City\",\"ParentID\":11146,\"RegionID\":194,\"RegionName\":\"Saratov\"}, {\"RegionType\":\"City\",\"ParentID\":11146,\"RegionID\":11143,\"RegionName\":\"Balakovo\"}, {\"RegionType\":\"City\",\"ParentID\":11146,\"RegionID\":11147,\"RegionName\":\"Engels\"}, {\"RegionType\":\"City\",\"ParentID\":11148,\"RegionID\":44,\"RegionName\":\"Izhevsk\"}, {\"RegionType\":\"City\",\"ParentID\":11148,\"RegionID\":11150,\"RegionName\":\"Glazov\"}, {\"RegionType\":\"City\",\"ParentID\":11148,\"RegionID\":11152,\"RegionName\":\"Sarapul\"}, {\"RegionType\":\"City\",\"ParentID\":11153,\"RegionID\":195,\"RegionName\":\"Ulyanovsk\"}, {\"RegionType\":\"City\",\"ParentID\":11153,\"RegionID\":11155,\"RegionName\":\"Dimitrovgrad\"}, {\"RegionType\":\"City\",\"ParentID\":11156,\"RegionID\":45,\"RegionName\":\"Cheboksary\"}, {\"RegionType\":\"City\",\"ParentID\":11156,\"RegionID\":37133,\"RegionName\":\"Novocheboksarsk\"}, {\"RegionType\":\"City\",\"ParentID\":11162,\"RegionID\":54,\"RegionName\":\"Yekaterinburg\"}, {\"RegionType\":\"City\",\"ParentID\":11162,\"RegionID\":11164,\"RegionName\":\"Kamensk-Uralskiy\"}, {\"RegionType\":\"City\",\"ParentID\":11162,\"RegionID\":11168,\"RegionName\":\"Nizhniy Tagil\"}, {\"RegionType\":\"City\",\"ParentID\":11162,\"RegionID\":11171,\"RegionName\":\"Pervouralsk\"}, {\"RegionType\":\"City\",\"ParentID\":11176,\"RegionID\":55,\"RegionName\":\"Tyumen\"}, {\"RegionType\":\"City\",\"ParentID\":11176,\"RegionID\":11173,\"RegionName\":\"Ishim\"}, {\"RegionType\":\"City\",\"ParentID\":11176,\"RegionID\":11175,\"RegionName\":\"Tobolsk\"}, {\"RegionType\":\"City\",\"ParentID\":11193,\"RegionID\":57,\"RegionName\":\"Khanty-Mansiysk\"}, {\"RegionType\":\"City\",\"ParentID\":11193,\"RegionID\":973,\"RegionName\":\"Surgut\"}, {\"RegionType\":\"City\",\"ParentID\":11193,\"RegionID\":1091,\"RegionName\":\"Nizhnevartovsk\"}, {\"RegionType\":\"City\",\"ParentID\":11193,\"RegionID\":11184,\"RegionName\":\"Nefteugansk\"}, {\"RegionType\":\"City\",\"ParentID\":11225,\"RegionID\":56,\"RegionName\":\"Chelyabinsk\"}, {\"RegionType\":\"City\",\"ParentID\":11225,\"RegionID\":235,\"RegionName\":\"Magnitogorsk\"}, {\"RegionType\":\"City\",\"ParentID\":11225,\"RegionID\":11212,\"RegionName\":\"Miass\"}, {\"RegionType\":\"City\",\"ParentID\":11225,\"RegionID\":11214,\"RegionName\":\"Ozersk\"}, {\"RegionType\":\"City\",\"ParentID\":11225,\"RegionID\":11217,\"RegionName\":\"Satka\"}, {\"RegionType\":\"City\",\"ParentID\":11232,\"RegionID\":58,\"RegionName\":\"Salekhard\"}, {\"RegionType\":\"City\",\"ParentID\":11232,\"RegionID\":11230,\"RegionName\":\"Noviy Urengoy\"}, {\"RegionType\":\"City\",\"ParentID\":11232,\"RegionID\":11231,\"RegionName\":\"Noyabrsk\"}, {\"RegionType\":\"City\",\"ParentID\":11235,\"RegionID\":197,\"RegionName\":\"Barnaul\"}, {\"RegionType\":\"City\",\"ParentID\":11235,\"RegionID\":975,\"RegionName\":\"Biysk\"}, {\"RegionType\":\"City\",\"ParentID\":11266,\"RegionID\":63,\"RegionName\":\"Irkutsk\"}, {\"RegionType\":\"City\",\"ParentID\":11266,\"RegionID\":976,\"RegionName\":\"Bratsk\"}, {\"RegionType\":\"City\",\"ParentID\":11266,\"RegionID\":11256,\"RegionName\":\"Angarsk\"}, {\"RegionType\":\"City\",\"ParentID\":11266,\"RegionID\":11273,\"RegionName\":\"Ust-Ilimsk\"}, {\"RegionType\":\"City\",\"ParentID\":11282,\"RegionID\":64,\"RegionName\":\"Kemerovo\"}, {\"RegionType\":\"City\",\"ParentID\":11282,\"RegionID\":237,\"RegionName\":\"Novokuznetsk\"}, {\"RegionType\":\"City\",\"ParentID\":11282,\"RegionID\":11287,\"RegionName\":\"Mezgdurechensk\"}, {\"RegionType\":\"City\",\"ParentID\":11309,\"RegionID\":62,\"RegionName\":\"Krasnoyarsk\"}, {\"RegionType\":\"City\",\"ParentID\":11309,\"RegionID\":11302,\"RegionName\":\"Achinsk\"}, {\"RegionType\":\"City\",\"ParentID\":11309,\"RegionID\":11310,\"RegionName\":\"Minusinsk\"}, {\"RegionType\":\"City\",\"ParentID\":11309,\"RegionID\":11311,\"RegionName\":\"Norilsk\"}, {\"RegionType\":\"City\",\"ParentID\":11309,\"RegionID\":20086,\"RegionName\":\"Zheleznogorsk\"}, {\"RegionType\":\"City\",\"ParentID\":11353,\"RegionID\":67,\"RegionName\":\"Tomsk\"}, {\"RegionType\":\"City\",\"ParentID\":11353,\"RegionID\":11351,\"RegionName\":\"Seversk\"}, {\"RegionType\":\"City\",\"ParentID\":11375,\"RegionID\":77,\"RegionName\":\"Blagoveshchensk\"}, {\"RegionType\":\"City\",\"ParentID\":11375,\"RegionID\":11374,\"RegionName\":\"Belogorsk\"}, {\"RegionType\":\"City\",\"ParentID\":11375,\"RegionID\":11391,\"RegionName\":\"Tynda\"}, {\"RegionType\":\"City\",\"ParentID\":11409,\"RegionID\":75,\"RegionName\":\"Vladivostok\"}, {\"RegionType\":\"City\",\"ParentID\":11409,\"RegionID\":974,\"RegionName\":\"Nahodka\"}, {\"RegionType\":\"City\",\"ParentID\":11409,\"RegionID\":11426,\"RegionName\":\"Ussuriysk\"}, {\"RegionType\":\"City\",\"ParentID\":11457,\"RegionID\":76,\"RegionName\":\"Khabarovsk\"}, {\"RegionType\":\"City\",\"ParentID\":11457,\"RegionID\":11453,\"RegionName\":\"Komsomolsk-at-Amur\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20524,\"RegionID\":20529,\"RegionName\":\"Lvov District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20524,\"RegionID\":20530,\"RegionName\":\"Zakarpattia District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20524,\"RegionID\":20531,\"RegionName\":\"Ternopil District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20524,\"RegionID\":20532,\"RegionName\":\"Ivano-Frankovsk District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20524,\"RegionID\":20533,\"RegionName\":\"Chernovtci District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20524,\"RegionID\":20534,\"RegionName\":\"Rovno District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20524,\"RegionID\":20535,\"RegionName\":\"Khmelnitsky District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20524,\"RegionID\":20550,\"RegionName\":\"Volyn Oblast\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20525,\"RegionID\":20536,\"RegionName\":\"Donetsk Region \"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20525,\"RegionID\":20537,\"RegionName\":\"Dnipropetrovsk Region \"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20525,\"RegionID\":20538,\"RegionName\":\"Kharkiv Region  \"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20525,\"RegionID\":20539,\"RegionName\":\"Zaporizhia Region \"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20525,\"RegionID\":20540,\"RegionName\":\"Luhansk Region \"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20526,\"RegionID\":20541,\"RegionName\":\"Odessa District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20526,\"RegionID\":20542,\"RegionName\":\"Kherson District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20526,\"RegionID\":20543,\"RegionName\":\"Nikolaev District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20527,\"RegionID\":20544,\"RegionName\":\"Kyiv Region \"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20527,\"RegionID\":20545,\"RegionName\":\"Vinnytsia Region\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20527,\"RegionID\":20546,\"RegionName\":\"Cherkassi District\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20527,\"RegionID\":20547,\"RegionName\":\"Zhytomyr Regoin \"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20527,\"RegionID\":20548,\"RegionName\":\"Kirovohrad Region\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20527,\"RegionID\":20549,\"RegionName\":\"Poltava Region \"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20528,\"RegionID\":20551,\"RegionName\":\"Chernihiv Region \"}, {\"RegionType\":\"Administrative area\",\"ParentID\":20528,\"RegionID\":20552,\"RegionName\":\"Sumi District\"}, {\"RegionType\":\"City\",\"ParentID\":20536,\"RegionID\":142,\"RegionName\":\"Donetsk\"}, {\"RegionType\":\"City\",\"ParentID\":20536,\"RegionID\":10366,\"RegionName\":\"Mariupol\"}, {\"RegionType\":\"City\",\"ParentID\":20536,\"RegionID\":20554,\"RegionName\":\"Kramatorsk\"}, {\"RegionType\":\"City\",\"ParentID\":20536,\"RegionID\":21774,\"RegionName\":\"Horlivka  \"}, {\"RegionType\":\"City\",\"ParentID\":20536,\"RegionID\":24876,\"RegionName\":\"Makiivka \"}, {\"RegionType\":\"City\",\"ParentID\":20537,\"RegionID\":141,\"RegionName\":\"Dnipropetrovsk\"}, {\"RegionType\":\"City\",\"ParentID\":20537,\"RegionID\":10347,\"RegionName\":\"Kryvyi Rih \"}, {\"RegionType\":\"City\",\"ParentID\":20537,\"RegionID\":21773,\"RegionName\":\"Nikopol\"}, {\"RegionType\":\"City\",\"ParentID\":20537,\"RegionID\":21775,\"RegionName\":\"Dniprodzerzhynsk\"}, {\"RegionType\":\"City\",\"ParentID\":20537,\"RegionID\":28401,\"RegionName\":\"Pavlohrad \"}, {\"RegionType\":\"City\",\"ParentID\":20540,\"RegionID\":222,\"RegionName\":\"Luhansk \"}, {\"RegionType\":\"City\",\"ParentID\":20540,\"RegionID\":24885,\"RegionName\":\"Alchevsk\"}, {\"RegionType\":\"City\",\"ParentID\":20540,\"RegionID\":24893,\"RegionName\":\"Sievierodonetsk \"}, {\"RegionType\":\"City\",\"ParentID\":20544,\"RegionID\":143,\"RegionName\":\"Kyiv \"}, {\"RegionType\":\"City\",\"ParentID\":20544,\"RegionID\":10369,\"RegionName\":\"Bila Tserkva\"}, {\"RegionType\":\"City\",\"ParentID\":20549,\"RegionID\":964,\"RegionName\":\"Poltava\"}, {\"RegionType\":\"City\",\"ParentID\":20549,\"RegionID\":21609,\"RegionName\":\"Kremenchuk \"}, {\"RegionType\":\"City\",\"ParentID\":29403,\"RegionID\":163,\"RegionName\":\"Astana\"}, {\"RegionType\":\"City\",\"ParentID\":29403,\"RegionID\":20809,\"RegionName\":\"Kokshetau\"}, {\"RegionType\":\"City\",\"ParentID\":29406,\"RegionID\":162,\"RegionName\":\"Almaty\"}, {\"RegionType\":\"City\",\"ParentID\":29406,\"RegionID\":10303,\"RegionName\":\"Taldikorgan\"}, {\"RegionType\":\"City\",\"ParentID\":29408,\"RegionID\":165,\"RegionName\":\"Semey\"}, {\"RegionType\":\"City\",\"ParentID\":29408,\"RegionID\":10306,\"RegionName\":\"Ust-Kamenogorsk\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":102444,\"RegionID\":11010,\"RegionName\":\"The Republic of Dagestan\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":102444,\"RegionID\":11012,\"RegionName\":\"The Republic of Ingushetia\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":102444,\"RegionID\":11013,\"RegionName\":\"The Kabardino-Balkar Republic\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":102444,\"RegionID\":11020,\"RegionName\":\"Karachaevo-Cherkesia Republic\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":102444,\"RegionID\":11021,\"RegionName\":\"The Republic of North Ossetia-Alania\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":102444,\"RegionID\":11024,\"RegionName\":\"Chechen Republic\"}, {\"RegionType\":\"Administrative area\",\"ParentID\":102444,\"RegionID\":11069,\"RegionName\":\"Stavropol Krai\"}]";
        assertEquals(expectedResult.replace(',', '\n'), Arrays.asList(actualResult).toString().replace(',', '\n'));
    }

    @Test
    public void testGetRubrics() throws Exception {
        Object[] actualResult =
                sandboxYndexDirectAPI.getRubrics();
        assertContains(actualResult, "{\"RubricName\":\"Utility\",\"RubricID\":12060,\"RubricFullName\":\"Hi-Tech / Mobile Communications / MobileApps / Java / Utility\",\"ParentID\":4401.0,\"Checkable\":\"Yes\",\"Url\":\"http://yaca.yandex.ru/yca/cat/Computers/Mobile/MobileApps/Java/Utility/\"}, {\"RubricName\":\"Results\",\"RubricID\":12065,\"RubricFullName\":\"Education / Secondary Education / Centralized testing / Results\"");
    }

    @Test
    public void testGetTimeZones() throws Exception {
        Object[] actualResult =
                sandboxYndexDirectAPI.getTimeZones();
        assertContains(actualResult, ":00)\"}, {\"GMTOffset\":-14400,\"TimeZone\":\"America/Grand_Turk\",\"Name\":\"Turks and Caicos Islands (GMT -04:00)\"}, {\"GMTOffset\":43200,\"TimeZone\":\"Pacific/Funafuti\",\"Name\":\"Tuvalu (GMT +12:00)\"}, {\"GMTOffset\":10800,\"TimeZone\":\"Africa/Kampala\",\"Name\"");
    }

    @Test
    public void testPingAPI() throws Exception {
        Long aLong = sandboxYndexDirectAPI.pingAPI();
        assertEquals(aLong, (Object) 1l);
    }

    @Test
    public void testGetEventsLog() throws Exception {
        GetEventsLogRequest getEventsLogRequest = new GetEventsLogRequest("2014-07-01T11:11:11Z");
        Object[] actualResult =
                yndexDirectAPI.getEventsLog(getEventsLogRequest);
        String expectedContains = "\"EventName\":\"Получен результат модерации баннера\"";
        assertContains(actualResult, expectedContains);
    }

    @Test
    public void testGetStatGoals() throws Exception {
        YndexDirectAPI yndexDirectAPI = new YndexDirectAPI("e4067735ee934cacbbfb6ea35ca3d887");
        Object[] actualResult =
                yndexDirectAPI.getStatGoals(new Long[]{8763270l});
        assertEquals(Arrays.asList(actualResult).toString(),
                "[{\"GoalID\":4567286,\"Name\":\"Просмотр 1 страницы сайта\"}]");

    }


    @Test
    public void testGetImages() throws Exception {
        AdImageSelectionCriteria adImageSelectionCriteria = new AdImageSelectionCriteria();
        adImageSelectionCriteria.setAdImageHashes(Arrays.asList(imageHash));
        List actualResult = yndexDirectAPI.getImages(adImageSelectionCriteria);
        String expectedResult = "[{\"Login\":\"hideo-kuze-gits\",\"AdImageHash\":\"6ze6EE39XPZGze-wgTLLGg\",\"AdImageURL\":\"http://direct.yandex.ru/images/6ze6EE39XPZGze-wgTLLGg\",\"Name\":\"1404585015_2011352241.jpg\",\"Assigned\":\"Yes\"}]";
        assertEquals(expectedResult.replace(',', '\n'), actualResult.toString().replace(',', '\n'));
    }

    @Test
    public void testGetLimits() throws Exception {
        Object actualResult = yndexDirectAPI.getLimits();
        assertContains(actualResult, ",\"Utilized\":2}", "{\"Login\":\"hideo-kuze-gits\",\"Capacity\"");
    }

    @Test
    public void testGetImageAssociation() throws Exception {
        AdImageAssociationSelectionCriteria imageAssociationSelectionCriteria = new AdImageAssociationSelectionCriteria();
        imageAssociationSelectionCriteria.setAdImageHashes(Arrays.asList(imageHash));
        Object actualResult = yndexDirectAPI.getImageAssociation(imageAssociationSelectionCriteria);
        String expectedResult = "[{\"AdID\":451154649,\"AdImageHash\":\"6ze6EE39XPZGze-wgTLLGg\",\"Login\":\"hideo-kuze-gits\",\"CampaignID\":9674248,\"StatusAdImageModerate\":\"No\",\"ModerateRejectionReasons\":[]}]";
        assertEquals(expectedResult.replace(',', '\n'), actualResult.toString().replace(',', '\n'));
    }

    @Test
    public void testUploadRawData() throws Exception {

        File file = new File("315576.jpg");
        BufferedImage image = ImageIO.read(file);
        String name = file.getName();
        String type = name.substring(name.lastIndexOf(".") + 1, name.length());
        Base64EncodedImage base64EncodedImage = new Base64EncodedImage("TestBase64EncodedImage", image, type);
        List<AdImageActionResult> adImageActionResults = yndexDirectAPI.uploadRawData(Arrays.asList(base64EncodedImage));

        String expectedContains = "[{\"AdImageHash\":\"";
        assertContains(adImageActionResults, expectedContains);

        String imageHash = adImageActionResults.get(0).getAdImageHash();
        AdImageSelectionCriteria imageHashSelectionCriteria = new AdImageSelectionCriteria();
        imageHashSelectionCriteria.setAdImageHashes(Arrays.asList(imageHash));


        List<AdImage> images = yndexDirectAPI.getImages(imageHashSelectionCriteria);
        expectedContains = "TestBase64EncodedImage";
        assertContains(images, expectedContains);

        List<AdImageUpload> deleteResult = yndexDirectAPI.deleteImage(imageHashSelectionCriteria);

        imageHashSelectionCriteria = new AdImageSelectionCriteria();
        images = yndexDirectAPI.getImages(imageHashSelectionCriteria);

    }


    @Test
    public void testGetRetargetingGoals() throws Exception {

        Object[] actualResult = yndexDirectAPI.getRetargetingGoals();
        String expectedResult = "[{\"GoalID\":4025535960,\"Name\":\"TestAPI :: посетил сайт\",\"GoalDomain\":\"06085fa026aa79791f673b2508d0c05dbc80717d.googledrive.com\",\"Login\":\"hideo-kuze-gits\"}, {\"GoalID\":5225120,\"Name\":\"Цель № 1\",\"GoalDomain\":\"06085fa026aa79791f673b2508d0c05dbc80717d.googledrive.com\",\"Login\":\"hideo-kuze-gits\"}]";
        assertEquals(expectedResult.replace(',', '\n'), Arrays.asList(actualResult).toString().replace(',', '\n'));
    }


    @Test
    public void testAddRetargetingConditionAndDeleteRetargetingCondition() throws Exception {

        //Create criteria retargeting conditionItem
        List<RetargetingConditionGoalItem> goalItems
                = new ArrayList<RetargetingConditionGoalItem>();

        goalItems.add(new RetargetingConditionGoalItem(5l, 4025535960l));
        goalItems.add(new RetargetingConditionGoalItem(5l, 5225120l));
        RetargetingConditionItem conditionItem = new RetargetingConditionItem("all", goalItems);
        RetargetingCondition retargetingCondition
                = new RetargetingCondition("TestRetargetingCondition", "hideo-kuze-gits", Arrays.asList(conditionItem));

        //Add retargeting condition
        List<RetargetingConditionActionResult> actionResults
                = yndexDirectAPI.addRetargetingCondition(Arrays.asList(retargetingCondition));
        assertContains("Method addRetargetingCondition worck wrong.",
                actionResults,
                "[{\"Warnings\":[],\"Errors\":[],\"RetargetingConditionID\":");

        //Create criteria
        RetargetingConditionSelectionCriteria selectionCriteria = new RetargetingConditionSelectionCriteria();
        Long retargetingConditionID = actionResults.get(0).getRetargetingConditionID();
        //    Long retargetingConditionID = 119906l;
        selectionCriteria.setRetargetingConditionIDS(Arrays.asList(retargetingConditionID));


        //Check was retargeting condition added
        Object actualResult = yndexDirectAPI.getRetargetingCondition(selectionCriteria);
        String expectedContains = "\"Login\":\"hideo-kuze-gits\",\"IsAccessible\":\"Yes\",\"Fields\":[],\"RetargetingCondition\":[{\"Type\":\"all\",\"Goals\":[{\"Time\":5,\"GoalID\":4025535960},{\"Time\":5,\"GoalID\":5225120}]}]}]";
        assertContains("Retargeting condition was not added.",
                actualResult,
                expectedContains);


        //Delete retargeting condition
        actualResult = yndexDirectAPI.deleteRetargetingCondition(selectionCriteria);
        assertEquals("Method deleteRetargetingCondition work wrong."
                , actualResult.toString()
                , "{\"ActionsResult\":[],\"RetargetingConditions\":[]}");


        //Check was retargeting condition deleted
        actualResult = yndexDirectAPI.getRetargetingCondition(selectionCriteria);
        assertEquals("Method deleteRetargetingCondition don`t delete Retargeting Condition."
                , actualResult.toString()
                , "[]");
    }

    @Test
    public void testGetRetargetingCondition() throws Exception {
        RetargetingConditionSelectionCriteria selectionCriteria = new RetargetingConditionSelectionCriteria();
        Long retargetingConditionID = 119911l;
        selectionCriteria.setRetargetingConditionIDS(Arrays.asList(retargetingConditionID));
        List<RetargetingCondition> retargetingCondition = yndexDirectAPI.getRetargetingCondition(selectionCriteria);
        String expectedResult = "[{\"RetargetingConditionName\":\"TestGetRetargetingCondition\",\"RetargetingConditionDescription\":\"\",\"RetargetingConditionID\":119911,\"Login\":\"hideo-kuze-gits\",\"IsAccessible\":\"Yes\",\"Fields\":[],\"RetargetingCondition\":[{\"Type\":\"or\",\"Goals\":[{\"Time\":30,\"GoalID\":5225120},{\"Time\":30,\"GoalID\":4025535960}]}]}]";
        assertEquals(retargetingCondition.toString().replace(',', '\n'), expectedResult.replace(',', '\n'));
    }

    @Test
    public void testUpdateRetargetingCondition() throws Exception {
        long retargetingConditionID = 119922l;
        RetargetingCondition retargetingCondition = new RetargetingCondition(retargetingConditionID);
        retargetingCondition.setFields(Arrays.asList("RetargetingConditionDescription"));
        String randomDescription = ((Integer) new Random().nextInt()).toString();
        retargetingCondition.setRetargetingConditionDescription(randomDescription);
        Object actualResult
                = yndexDirectAPI.updateRetargetingCondition(Arrays.asList(retargetingCondition));
        assertEquals(actualResult.toString(), "[{\"Warnings\":[],\"Errors\":[],\"RetargetingConditionID\":119922}]");

        RetargetingConditionSelectionCriteria retargetingConditionSelectionCriteria
                = new RetargetingConditionSelectionCriteria(Arrays.asList(retargetingConditionID));
        actualResult = yndexDirectAPI.getRetargetingCondition(retargetingConditionSelectionCriteria);
        assertContains(actualResult,
                randomDescription);
    }

    @Test
    public void testAddRetargetingAndDeleteRetargeting() throws Exception {

        //Create retargetings
        List<Retargeting> retargetings = new ArrayList<Retargeting>();
        Retargeting retargeting = new Retargeting(464550574l, 119911l);
        retargeting.setContextPrice(0.30);
        retargetings.add(retargeting);
        retargeting = new Retargeting(464550574l, 119922l);
        retargeting.setContextPrice(0.30);
        retargetings.add(retargeting);


        //Add retargetings
        List<RetargetingActionResult> retargetingActionResults = yndexDirectAPI.addRetargeting(retargetings);
        String expectedContains = "[{\"Warnings\":[],\"Errors\":[],\"RetargetingID\":";
        assertContains("Method addRetargeting worck wrong.",
                retargetingActionResults,
                expectedContains);


        //Create criteria
        RetargetingSelectionCriteria selectionCriteria = new RetargetingSelectionCriteria();
        selectionCriteria.setAdIDS(Arrays.asList(464550574l));


        //Check was retargeting added
        Object actualResult = yndexDirectAPI.getRetargeting(selectionCriteria);
        assertContains("Retargeting was not added.",
                actualResult,
                "\"RetargetingConditionID\":119911",
                "\"RetargetingConditionID\":119922");


        //Delete retargeting condition
        actualResult = yndexDirectAPI.deleteRetargeting(selectionCriteria);
        assertEquals("Method deleteRetargeting work wrong."
                , actualResult.toString()
                , "[]");


        //Check was retargeting deleted
        actualResult = yndexDirectAPI.getRetargeting(selectionCriteria);
        assertEquals("Method deleteRetargeting don`t delete Retargeting Condition."
                , actualResult.toString()
                , "[]");
    }


    @Test
    public void testGetRetargeting() throws Exception {
        RetargetingSelectionCriteria selectionCriteria = new RetargetingSelectionCriteria();
        selectionCriteria.setAdIDS(Arrays.asList(466136943l));
        List<Retargeting> actualResult = yndexDirectAPI.getRetargeting(selectionCriteria);
        actualResult.get(0).setContextPrice(0d);
        String expectedResult = "[{\"Fields\":[],\"RetargetingID\":554800,\"AdID\":466136943,\"RetargetingConditionID\":119957,\"ContextPrice\":0.0,\"AutoBudgetPriority\":\"Medium\",\"StatusPaused\":\"No\"}]";
        assertEquals(actualResult.toString().replace(',', '\n'), expectedResult.replace(',', '\n'));
    }


    @Test
    public void testUpdateRetargeting() throws Exception {
        Retargeting retargeting = new Retargeting(554800l);
        int cp = new Random().nextInt(9) + 1;
        Double contextPrice = (double) cp;
        retargeting.setFields(Arrays.asList("ContextPrice"));
        retargeting.setContextPrice(contextPrice);
        Object actualResult = yndexDirectAPI.updateRetargeting(Arrays.asList(retargeting));
        String expectedResult = "[{\"Warnings\":[],\"Errors\":[],\"RetargetingID\":554800}]";
        assertEquals(actualResult.toString().replace(',', '\n'), expectedResult.replace(',', '\n'));

        RetargetingSelectionCriteria selectionCriteria = new RetargetingSelectionCriteria();
        selectionCriteria.setRetargetingIDS(Arrays.asList(554800l));
        actualResult = yndexDirectAPI.getRetargeting(selectionCriteria);
        assertContains(actualResult, "\"ContextPrice\":" + cp);
    }

    @Test
    public void testGetCreditLimits() {
        Object actualResul = sandboxYndexDirectAPI.getCreditLimits();
        String expectedResult = "{\"Limits\":[{\"ContractID\":\"11111/00\",\"Limit\":10000.0,\"LimitSpent\":0.0}]}";
        assertEquals(expectedResult, actualResul.toString());
    }

    @Test
    public void testCreateInvoiceInfo() {
        CreateInvoiceInfo createInvoiceInfo = new CreateInvoiceInfo(campaignIDS[0], 250d);
        Object actualResul =
                sandboxYndexDirectAPI.createInvoice(new CreateInvoiceInfo[]{createInvoiceInfo});
        String expectedContains = "https://passport.yandex.ru/passport?mode=subscribe&from=balance&retpath=http";
        assertContains(actualResul, expectedContains);
    }

    @Test
    public void testPayCampaigns() {

        CampaignBalanceInfo[] balance = sandboxYndexDirectAPI.getBalance(Arrays.asList(campaignIDS[0]));
        Long sum = balance[0].getSum();

        PayCampElement payCampElement = new PayCampElement(campaignIDS[0], 10d);
        PayCampaignsInfo payCampaignsInfo = new PayCampaignsInfo(Arrays.asList(payCampElement), "11111/00", "Bank");

        Object actualResul = sandboxYndexDirectAPI.payCampaigns(payCampaignsInfo);
        assertEquals(1l, actualResul);

        balance = sandboxYndexDirectAPI.getBalance(Arrays.asList(campaignIDS[0]));
        assertEquals(10l, balance[0].getSum() - sum);
    }

    @Test
    public void testTransferMoney() {
        CampaignBalanceInfo[] balance = sandboxYndexDirectAPI.getBalance(Arrays.asList(campaignIDS[0]));
        Long sum = balance[0].getSum();

        PayCampElement fromCampaign = new PayCampElement(campaignIDS[0], 10d);
        PayCampElement toCampaign = new PayCampElement(campaignIDS[1], 10d);

        Object actualResul =
                sandboxYndexDirectAPI.transferMoney(Arrays.asList(fromCampaign), Arrays.asList(toCampaign));
        assertEquals(1l, actualResul);

        balance = sandboxYndexDirectAPI.getBalance(Arrays.asList(campaignIDS[0]));
        assertEquals(-10l, balance[0].getSum() - sum);

        sandboxYndexDirectAPI.transferMoney(Arrays.asList(toCampaign), Arrays.asList(fromCampaign));
    }

    @Test
    public void testGetClientsList() {
        Object actualResult = sandboxYndexDirectAPI.getClientsList();
        assertContains(actualResult,
                "sbx-hideo-BVuz03",
                "sbx-hideo-J0Tp3R",
                "sbx-hideo-8rsSEu");
    }

    @Test
    public void testGetSubClients() {
        Object[] actualResult = sandboxYndexDirectAPI.getSubClients("hideo-kuze-gits");
        assertContains(actualResult,
                "sbx-hideo-BVuz03",
                "sbx-hideo-J0Tp3R",
                "sbx-hideo-8rsSEu");
    }

    @Test
    public void testGetClientsUnits() {
        Object[] actualResult = sandboxYndexDirectAPI.getClientsUnits(Arrays.asList("hideo-kuze-gits"));
        assertContains(actualResult, "[{\"Login\":\"hideo-kuze-gits\",\"UnitsRest\":");
    }

    @Test
    public void testUpdateClientInfo() {
        Long phone = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
        ClientInfo client = new ClientInfo(login, phone.toString(), "testFIFO", "test@gmail.com");
        Object actualResult = sandboxYndexDirectAPI.updateClientInfo(Arrays.asList(client));
        assertEquals(1l, actualResult);

        ClientInfo clientInfo = sandboxYndexDirectAPI.getClientInfo(Arrays.asList(login));
        assertEquals(phone.toString(), clientInfo.getPhone());
    }

    @Test
    public void testCreateNewSubclient() {
        Long newLogin = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
        Object actualResult = sandboxYndexDirectAPI.createNewSubclient("jackob" + newLogin, "testName", "testSurname");
        assertContains(actualResult, newLogin.toString());

        actualResult = sandboxYndexDirectAPI.getSubClients("hideo-kuze-gits");
        assertContains(actualResult, newLogin.toString());

    }

 /*   @Test
    public void testEnableSharedAccount(){
        YndexDirectAPI sandboxYndexDirectAPI = new YndexDirectAPI();
        sandboxYndexDirectAPI.setContextrelcomTestAccount();
        System.out.println(Arrays.asList(sandboxYndexDirectAPI.getClientsList()));
        EnableSharedAccountResponse contextrelcom = sandboxYndexDirectAPI.enableSharedAccount("sbx-contexm2XMq8");
        System.out.println(contextrelcom);
    }*/


//System.out.println(Arrays.asList(actualResult));
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testUploadImageAndCheckUploadStatusAndDeleteImage() throws Exception {
        ArrayList<AdImageURL> adImageURLs = new ArrayList<AdImageURL>();
        AdImageURL adImageURL = new AdImageURL("Test",
                "http://s21.postimg.org/881axe2gj/10298569.jpg");
        adImageURLs.add(adImageURL);
        adImageURL = new AdImageURL("Test", null);
        adImageURLs.add(adImageURL);
        List<AdImageActionResult> uploadImageResponse = yndexDirectAPI.uploadImage(adImageURLs);
        String expectedResultContains = " {\"Errors\":[{\"FaultDetail\":\"Field AdImageURLData[1].URL must not be empty\",\"FaultString\":\"Invalid request parameters\",\"FaultCode\":71}]}]";
        assertContains("Method uploadImage don`t return Error on wrong url.",
                uploadImageResponse,
                expectedResultContains);

        assertContains("Method uploadImage don`t upload image.",
                uploadImageResponse,
                "\"AdImageUploadTaskID\"");


        AdImageSelectionCriteria imageIDSelectionCriteria = new AdImageSelectionCriteria();
        AdImageActionResult adImageActionResult = uploadImageResponse.get(0);
        Long adImageUploadTaskID = adImageActionResult.getAdImageUploadTaskID();
        imageIDSelectionCriteria.setAdImageUploadTaskIDS(Arrays.asList(adImageUploadTaskID));
        List<AdImageUpload> images = yndexDirectAPI.checkUploadStatus(imageIDSelectionCriteria);
        expectedResultContains = "\"Status\":\"Pending\",\"SourceURL\":\"http://s21.postimg.org/881axe2gj/10298569.jpg\",\"Name\":\"Test\"}]";
        assertContains("Method checkUploadStatus don`t show image.",
                images,
                expectedResultContains);

        int seconds = 0;

        while (yndexDirectAPI.checkUploadStatus(imageIDSelectionCriteria).get(0).getStatus().equals("Pending")) {
            Thread.sleep(1000);
            seconds++;
            System.out.println("Pending " + seconds + " seconds");
        }

        AdImageUpload adImageUpload = yndexDirectAPI.checkUploadStatus(imageIDSelectionCriteria).get(0);
        AdImageSelectionCriteria imageHashSelectionCriteria = new AdImageSelectionCriteria();
        String adImageHash = adImageUpload.getAdImageHash();
        imageHashSelectionCriteria.setAdImageHashes(Arrays.asList(adImageHash));


        List<AdImageUpload> deleteResult = yndexDirectAPI.deleteImage(imageHashSelectionCriteria);
        assertEquals("Method deleteImage worked incorrectly.", "[]", deleteResult.toString());


        List<AdImage> imagesAfterDelete = yndexDirectAPI.getImages(imageHashSelectionCriteria);
        assertEquals("Method deleteImage don`t delete image.", "[]", imagesAfterDelete.toString());

    }


    public void assertContains(Object actualResult, String... expectContains) {
        assertContains("", actualResult, expectContains);
    }


    public void assertContains(String message, Object actualResult, String... expectContains) {

        if (actualResult.getClass().isArray())
            actualResult = Arrays.asList((Object[]) actualResult);

        String actualResultString = actualResult.toString();
        StringBuilder notContains = new StringBuilder();


        for (int i = 0; i < expectContains.length; i++) {
            if (!actualResultString.contains(expectContains[i]))
                notContains.append(i + 1 + ") " + expectContains[i] + "\n");
        }

        message = message + "\n Actual result : \n" +
                actualResult +
                "\n Don`t contains : \n" +
                notContains;

        if (notContains.length() != 0)
            assertTrue(message, false);
    }

}
