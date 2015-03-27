package com.HideoKuzeGits.YndexDirectAutobroker.xlsImport;

import com.HideoKuzeGits.yndexDirectAPI.YndexDirectAPI;
import com.HideoKuzeGits.yndexDirectAPI.YndexDirectApiFactory;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.BannerPhraseInfo;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.CampaignInfo;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.ContactInfo;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.Sitelink;
import com.google.api.client.repackaged.com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * Created by root on 25.08.14.
 */

@Service
//@Scope(value = "request")
public class XlsDirectParserService {

    @Autowired
    private RegionsDao regionsDao;


    public static List<String> daysOfWeek = ImmutableList.of("пн", "вт", "ср", "чт", "пт", "сб", "вс");


    public static void main(String[] args) throws IOException {

        FileSystemXmlApplicationContext context
                = new FileSystemXmlApplicationContext("//home/hideo/IdeaProjects/YndexDirectAutobroker/src/main/webapp/WEB-INF/spring_hibernate.xml,//home/hideo/IdeaProjects/YndexDirectAutobroker/src/main/webapp/WEB-INF/dispatcher-servlet.xml".split(","));
        XlsDirectParserService xlsDirectParserService = context.getBean(XlsDirectParserService.class);

        //  XlsDirectParser xlsDirectParser = new XlsDirectParser();

        //FileInputStream fis = new FileInputStream("/home/hideo/IdeaProjects/YndexDirectAutobroker/src/main/java/com/HideoKuzeGits/YndexDirectAutobroker/xlsImport/tamplate_with_groups.xls");
        FileInputStream fis = new FileInputStream("/home/hideo/IdeaProjects/YndexDirectAutobroker/src/main/java/com/HideoKuzeGits/YndexDirectAutobroker/xlsImport/tamplate.xls");

        BannerCollection bannerCollection = xlsDirectParserService.parse(fis);
        YndexDirectAPI yndexDirectApi = new YndexDirectApiFactory().createYndexDirectApi("2e02af49416a44eb8c9801c387cf7f0b");
        bannerCollection.uploadToDirect(yndexDirectApi);


        /*  List<BannerInfo> bannersInfo = xlsDirectParser.parseBanners(bannersSheet, contactSheet);-*/

     /*  Workbook wb = new HSSFWorkbook(fis);
        Sheet bannersSheet = wb.getSheet("Тексты");
        Sheet contactSheet = wb.getSheet("Контактная информация");
        CampaignInfo campaignInfo = xlsDirectParser.parseCampaignInfo(bannersSheet);*/

/*
        ContactInfo contact = xlsDirectParser.parseContact(contactSheet);

        String phraseWithMinusWordsTitle = xlsDirectParser.getStringCellValue(bannersSheet, 7, 5);
        int beginBannerCollNum;
        boolean isTemplateWithGroups = phraseWithMinusWordsTitle.contains("Фраза");


        Row row = bannersSheet.getRow(11);
        ExcelBanner banner = xlsDirectParser.parseBanner(row, contact, isTemplateWithGroups);
*/


   /*     YndexDirectAPI yndexDirectApi = new YndexDirectApiFactory().createYndexDirectApi("2e02af49416a44eb8c9801c387cf7f0b");

        GetBannersInfo getBannersInfo = new GetBannersInfo();
        getBannersInfo.setBannerIDS(Arrays.asList(new Long[]{525523749l}));
        BannerInfo[] bannersInfo = yndexDirectApi.getBanners(getBannersInfo);
        System.out.println(Arrays.asList(bannersInfo).toString().replace(",", ",\n"));
         CampaignInfo campaignInfo = yndexDirectApi.getCampaignsParams(new Long[]{10194252l})[0];
        GetBannersInfo getBannersInfo = new GetBannersInfo();
        getBannersInfo.setBannerIDS(Arrays.asList(525523745l));
        BannerInfo bannerInfo = yndexDirectApi.getBanners(getBannersInfo)[0];
        ContactInfo contactInfo = bannerInfo.getContactInfo();
        System.out.println(contactInfo.toString().replace(",", ",\n"));*/

      /*  banner.setCampaignID(10224197l);
        yndexDirectApi.createOrUpdateBanners(Arrays.asList(banner));*/

    }

    public BannerCollection parse(InputStream excelFileInputStream) throws IOException {

        Workbook wb = new HSSFWorkbook(excelFileInputStream);
        Sheet bannersSheet = wb.getSheet("Тексты");
        Sheet contactSheet = wb.getSheet("Контактная информация");

        ContactInfo contact = parseContact(contactSheet);
        BannerCollection bannerCollection = parseBanners(bannersSheet, contact);

        CampaignInfo campaignInfo = parseCampaignInfo(bannersSheet);
        bannerCollection.setCampaignInfo(campaignInfo);

        return bannerCollection;
    }

    private CampaignInfo parseCampaignInfo(Sheet bannersSheet) {

        CampaignInfo campaignInfo = new CampaignInfo();

        //Название кампании:
        String name = getStringCellValue(bannersSheet, 3, 1);
        if (!Strings.isNullOrEmpty(name))
            campaignInfo.setName(name);
        else
            campaignInfo.setName("Новая компания.");

        //Минус-слова на кампанию:
        String minusKeywordsString = getStringCellValue(bannersSheet, 7, 4);
        if (!Strings.isNullOrEmpty(minusKeywordsString)) {
            String[] minusKeywords = minusKeywordsString.split("[ ,-]+");
            campaignInfo.setMinusKeywords(Arrays.asList(minusKeywords));
        }

        //Валюта:
        String currency = getStringCellValue(bannersSheet, 6, 7);
        campaignInfo.setCurrency(currency);

        return campaignInfo;
    }

    private BannerCollection parseBanners(Sheet bannersSheet,
                                          ContactInfo contact) {

        BannerCollection bannerCollection = new BannerCollection();

        //Title Фраза (с минус-словами)
        String phraseWithMinusWordsTitle = getStringCellValue(bannersSheet, 8, 0);
        boolean isTemplateWithGroups = phraseWithMinusWordsTitle.contains("Доп. объявление группы");


        int i = 10;

        for (Row row = bannersSheet.getRow(i++);
             !isRowEmpty(row, 1, 24);
             row = bannersSheet.getRow(i++)) {

            ExcelBanner banner = parseBanner(row, contact, isTemplateWithGroups);
            bannerCollection.add(banner);
        }

        return bannerCollection;
    }

    private ExcelBanner parseBanner(Row bannerRow, ContactInfo contactInfo, boolean isTemplateWithGroups) {

        ExcelBanner banner = new ExcelBanner();


        int currentColl;

        if (isTemplateWithGroups) {

            currentColl = 0;

            //Доп. объявление группы
            String stringCellValue = getStringCellValue(bannerRow, currentColl);

            if ("-".equals(stringCellValue))
                banner.setIsAdditional(false);
            else if ("+".equals(stringCellValue))
                banner.setIsAdditional(true);

            //Название группы
            currentColl += 2;
            String groupName = getStringCellValue(bannerRow, currentColl);
            if (groupName == null)
                groupName = "NULL";
            banner.setAdGroupName(groupName);

            //Номер группы
            currentColl++;
            String groupNumString = getStringCellValue(bannerRow, currentColl);
            if (!Strings.isNullOrEmpty(groupNumString)) {
                Integer groupNum = Integer.valueOf(groupNumString);
                banner.setGroupNum(groupNum);
            }

            currentColl += 2;
        } else {
            currentColl = 2;
        }

        //Фраза (с минус-словами)
        String phraseString = getStringCellValue(bannerRow, currentColl);
        BannerPhraseInfo phrase = null;
        if (!Strings.isNullOrEmpty(phraseString)) {
            phrase = new BannerPhraseInfo();
            banner.setPhrases(Arrays.asList(phrase));
            phrase.setPhrase(phraseString);
        }

        //Заголовок
        currentColl += 2;
        String title = getStringCellValue(bannerRow, currentColl);
        banner.setTitle(title);

        //Текст
        currentColl++;
        String bannerText = getStringCellValue(bannerRow, currentColl);
        banner.setText(bannerText);

        //Ссылка
        currentColl += 3;
        String bannerHref = getStringCellValue(bannerRow, currentColl);
        banner.setHref(bannerHref);

        //Регион
        currentColl++;
        String bannerRegions = getStringCellValue(bannerRow, currentColl);
        String regionsId = getRegionsId(bannerRegions);
        banner.setGeo(regionsId);

        //Ставка
        currentColl++;
        String priceString = getStringCellValue(bannerRow, currentColl);
        Double price = null;
        if (!Strings.isNullOrEmpty(priceString) && phrase != null) {
            price = Double.valueOf(priceString);
            phrase.setPrice(price);
        }


        //Контакты
        currentColl += 2;
        String containsContact = getStringCellValue(bannerRow, currentColl);
        if ("+".equals(containsContact))
            banner.setContactInfo(contactInfo);

        //Заголовки быстрых ссылок
        currentColl += 3;
        String siteLinksTitles = getStringCellValue(bannerRow, currentColl);

        //Адреса быстрых ссылок
        currentColl++;
        String siteLinksReferences = getStringCellValue(bannerRow, currentColl);
        if (!Strings.isNullOrEmpty(siteLinksTitles) || !Strings.isNullOrEmpty(siteLinksReferences)) {
            Sitelink[] sitelinks = getSitelinks(siteLinksTitles, siteLinksReferences);
            banner.setSitelinks(Arrays.asList(sitelinks));
        }

        //Метки
        currentColl += 3;
        String tagsString = getStringCellValue(bannerRow, currentColl);
        if (!Strings.isNullOrEmpty(tagsString)) {
            String[] tags = tagsString.split(" *, *");
            banner.setTagsNames(Arrays.asList(tags));
        }

        //Изображение
        currentColl++;
        String imageUrl = getStringCellValue(bannerRow, currentColl);
        banner.setImageUrl(imageUrl);

        //Минус-слова на объявление/группу
        currentColl++;
        String minusKeywordsString = getStringCellValue(bannerRow, currentColl);
        if (!Strings.isNullOrEmpty(minusKeywordsString)) {
            String[] minusKeywords = minusKeywordsString.split("[ ,-]+");
            banner.setMinusKeywords(Arrays.asList(minusKeywords));
        }


        return banner;
    }

    private Sitelink[] getSitelinks(String siteLinksTitlesString, String siteLinksReferencesString) {


        String[] siteLinksTitles = siteLinksTitlesString.split("\\|\\|");
        String[] siteLinksReferences = siteLinksReferencesString.split("\\|\\|");

        Sitelink[] sitelinks = new Sitelink[siteLinksTitles.length];

        for (int i = 0; i < siteLinksTitles.length; i++) {

            String siteLinkTitle = siteLinksTitles[i];
            String siteLinkReference = siteLinksReferences[i];
            Sitelink sitelink = new Sitelink(siteLinkTitle, siteLinkReference);
            sitelinks[i] = sitelink;
        }

        return sitelinks;
    }

    private String getRegionsId(String bannerRegion) {

        if (bannerRegion == null)
            return null;


        StringBuilder regionsIdStringBuilder = new StringBuilder();
        String[] regions = bannerRegion.split(",");
        boolean isFirst = true;


        for (String region : regions) {

            if (!isFirst)
                regionsIdStringBuilder.append(",");
            isFirst = false;

            String regionName;
            region = region.trim();

            if (region.startsWith("-")) {
                regionsIdStringBuilder.append("-");
                regionName = region.substring(1);
            } else
                regionName = region;

            Long regionId = regionsDao.getRegionId(regionName);
            regionsIdStringBuilder.append(regionId);

        }
        return regionsIdStringBuilder.toString();
    }

    private ContactInfo parseContact(Sheet contactSheet) {
        ContactInfo contactInfo = new ContactInfo();

        //Страна
        String country = getStringCellValue(contactSheet, 8, 2);
        contactInfo.setCountry(country);

        //Город
        String city = getStringCellValue(contactSheet, 10, 2);
        contactInfo.setCity(city);

        //Телефон
        Row phoneNumberRow = contactSheet.getRow(12);
        appendPhoneNumber(contactInfo, phoneNumberRow);

        //Название компании / ФИО
        String companyName = getStringCellValue(contactSheet, 16, 1);
        contactInfo.setCompanyName(companyName);

        //Контактное лицо
        String contactPerson = getStringCellValue(contactSheet, 19, 1);
        contactInfo.setContactPerson(contactPerson);

        //Почтовый адрес
        Row postalAddressRow = contactSheet.getRow(22);
        appendPostalAdress(contactInfo, postalAddressRow);

        //Время работы
        String workTimeString = getWorkTimeString(contactSheet);
        contactInfo.setWorkTime(workTimeString);

        //ОГРН / ОРГНИП
        String OGRN = getStringCellValue(contactSheet, 12, 8);
        contactInfo.setOGRN(OGRN);

        //Контактный e-mail
        String email = getStringCellValue(contactSheet, 16, 8);
        contactInfo.setContactEmail(email);

        //Интернет-пейджер
        String iMClient = getStringCellValue(contactSheet, 19, 8);
        contactInfo.setIMClient(iMClient);

        String iMLogin = getStringCellValue(contactSheet, 19, 10);
        contactInfo.setIMLogin(iMLogin);

        //Подробнее о товаре/услуге
        String extraMessage = getStringCellValue(contactSheet, 22, 8);
        contactInfo.setExtraMessage(extraMessage);


        return contactInfo;
    }

    private void appendPhoneNumber(ContactInfo contactInfo, Row phoneNumberRow) {

        String countryCode = getStringCellValue(phoneNumberRow, 2);
        contactInfo.setCountryCode(countryCode);

        String cityCode = getStringCellValue(phoneNumberRow, 3);
        contactInfo.setCityCode(cityCode);

        String phoneNumber = getStringCellValue(phoneNumberRow, 4);
        contactInfo.setPhone(phoneNumber);

        String phoneExt = getStringCellValue(phoneNumberRow, 5);
        contactInfo.setPhoneExt(phoneExt);
    }

    private void appendPostalAdress(ContactInfo contactInfo, Row postalAddressRow) {

        //улица
        String street = getStringCellValue(postalAddressRow, 1);
        contactInfo.setStreet(street);

        //дом
        String house = getStringCellValue(postalAddressRow, 3);
        contactInfo.setHouse(house);

        //корпус
        String build = getStringCellValue(postalAddressRow, 4);
        contactInfo.setBuild(build);

        //офис
        String officeNumber = getStringCellValue(postalAddressRow, 5);
        contactInfo.setApart(officeNumber);
    }

    private String getWorkTimeString(Sheet contactSheet) {

        StringBuilder workTimeStringBuilder = new StringBuilder();

        boolean isFirst = true;
        int i = 26;

        for (Row row = contactSheet.getRow(i++);
             !isRowEmpty(row, 1, 5);
             row = contactSheet.getRow(i++)) {

            if ((i - 26) > 10)
                throw new WrongExcelExeption("To large work time table.");

            if (!isFirst)
                workTimeStringBuilder.append(";");
            isFirst = false;


            String beginDayOfWeekName = getStringCellValue(row, 1);
            String endDayOfWeekName = getStringCellValue(row, 2);
            String beginTimeString = getStringCellValue(row, 4);
            String endTimeString = getStringCellValue(row, 5);

            boolean isFieldsNullOrEmty = Strings.isNullOrEmpty(beginDayOfWeekName) &&
                    Strings.isNullOrEmpty(endDayOfWeekName) &&
                    Strings.isNullOrEmpty(beginTimeString) &&
                    Strings.isNullOrEmpty(endTimeString);

            if (!isFieldsNullOrEmty) {

                int beginDayOfWeekNum = daysOfWeek.indexOf(beginDayOfWeekName);
                workTimeStringBuilder.append(beginDayOfWeekNum);

                workTimeStringBuilder.append(";");
                int endDayOfWeekNum = daysOfWeek.indexOf(endDayOfWeekName);
                workTimeStringBuilder.append(endDayOfWeekNum);

                workTimeStringBuilder.append(";");
                beginTimeString = beginTimeString.replace(":", ";");
                workTimeStringBuilder.append(beginTimeString);

                workTimeStringBuilder.append(";");
                endTimeString = endTimeString.replace(":", ";");
                workTimeStringBuilder.append(endTimeString);

            }
        }

        return workTimeStringBuilder.toString();
    }

    private static boolean isRowEmpty(Row row, int beginColumn, int endColumn) {

        if (row == null)
            return true;

        boolean isEmpty = true;

        for (int i = beginColumn; i <= endColumn; i++) {

            Cell cell = row.getCell(i);
            if (cell != null)
                if (cell.getCellType() != Cell.CELL_TYPE_BLANK)
                    isEmpty = false;
        }


        return isEmpty;
    }

    private String getStringCellValue(Row row, int columnNum) {

        if (row == null)
            return null;

        Cell cell = row.getCell(columnNum);

        if (cell == null)
            return null;

        cell.setCellType(Cell.CELL_TYPE_STRING);
        String stringCellValue = cell.getStringCellValue();

        if (Strings.isNullOrEmpty(stringCellValue))
            return null;

        return stringCellValue.trim();
    }

    private String getStringCellValue(Sheet sheet, int rowNum, int columnNum) {

        Row row = sheet.getRow(rowNum);

        if (row == null)
            return null;

        return getStringCellValue(row, columnNum);
    }


}
