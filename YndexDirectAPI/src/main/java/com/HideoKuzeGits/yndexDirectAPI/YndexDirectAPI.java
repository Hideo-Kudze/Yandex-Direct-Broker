package com.HideoKuzeGits.yndexDirectAPI;


//import yndexDirectAPI.wrapClasses.*;

import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.*;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 21.06.14.
 */

//ApplicationID = "7f237c1382cd4224938b923f1d4b1419";
//campaignIDS = 64145, 64146, 64147
//token = "ba6bfb8077d1482c9749b1163411d116";  for tests hideo.kuze.gits
//token = "f717c3903b8d479c9102e23ce4fd528a"    contextrelcom акаунт заказчика
//directApiUrl = "https://api-sandbox.direct.yandex.ru/v4/json/" yndex direct sand
// box
public class YndexDirectAPI {


    public static final String DIRECT_API_URL = "https://api.direct.yandex.ru/live/v4/json/";
    public static final String DIRECT_API_SANDBOX_URL = "https://api-sandbox.direct.yandex.ru/live/v4/json/";

    protected String token;
    protected String masterToken;
    protected String directApiUrl = DIRECT_API_URL;
    protected CloseableHttpClient httpClient;
    protected AuthorizationErrorHandler authorizationErrorHandler;
    private MethodsToJsonAspect.Locale locale;


    public YndexDirectAPI(String token) {
        this.token = token;
    }

    public YndexDirectAPI(String token, String masterToken) {
        this.token = token;
        this.masterToken = masterToken;
    }

    public CloseableHttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String getMasterToken() {
        return masterToken;
    }

    public void setMasterToken(String masterToken) {
        this.masterToken = masterToken;


    }

    public AuthorizationErrorHandler getAuthorizationErrorHandler() {
        return authorizationErrorHandler;
    }

    public void setAuthorizationErrorHandler(AuthorizationErrorHandler authorizationErrorHandler) {
        this.authorizationErrorHandler = authorizationErrorHandler;
    }


    public String getDirectApiUrl() {
        return directApiUrl;
    }

    public MethodsToJsonAspect.Locale getLocale() {
        return locale;
    }

    public void setLocale(MethodsToJsonAspect.Locale locale) {
        this.locale = locale;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @ApiMethod
    public ShortCampaignInfo[] getCampaignsListFilter(GetCampaignsInfo getCampaignsInfo) {
        return new ShortCampaignInfo[]{new ShortCampaignInfo()};
    }


    @ApiMethod
    public CampaignInfo[] getCampaignsParams(Long campaignIDS[]) {
        return null;
    }

    @ApiMethod
    public BannerTagsInfo[] getBannersTags(Long campaignIDS[], Long bannerIDS[]) {
        return null;
    }

    public CampaignTagsInfo getCampaignsTags(Long campaignID) {
        return getCampaignsTags(new Long[]{campaignID})[0];
    }

    @ApiMethod
    public CampaignTagsInfo[] getCampaignsTags(Long campaignIDS[]) {
        return null;
    }

    @ApiMethod
    public Long updateBannersTags(List<BannerTagsInfo> bannerTags) {
        return null;
    }

    @ApiMethod
    public CampaignTagsInfo[] updateCampaignsTags(List<CampaignTagsInfo> campaignTags) {
        return null;
    }


    @ApiMethod
    public Long createOrUpdateCampaign(CampaignInfo campaignInfo) {
        return null;
    }

    @ApiMethod
    public Long deleteCampaign(Long campaignID) {
        return null;
    }

    @ApiMethod
    public Long[] createOrUpdateBanners(List<? extends BannerInfo> bannersInfo) {
        return null;
    }

    @ApiMethod
    public Long deleteBanners(Long campaignID, Long[] bannerIDS) {
        return null;
    }


    @ApiMethod
    public BannerInfo[] getBanners(GetBannersInfo getBannersInfo) {
        return null;
    }

    @ApiMethod
    public BannerInfo[] getBanners(Long bannerIDS[]) {
        return null;
    }

    @ApiMethod(methodName = "GetBanners")
    public BannerInfo[] getCampaignBanners(Long campaignIDS[]) {
        return null;
    }

    @ApiMethod
    public Long moderateBanners(Long CampaignID, Long bannerIDS[]) {
        return null;
    }


    @ApiMethod
    public BannerPhraseInfo[] getBannerPhrasesFilter(BannerPhrasesFilterRequestInfo bannerPhrasesFilterRequestInfo) {
        return null;
    }

    @ApiMethod
    public BannerPhraseInfo[] getBannerPhrases(List<Long> bannerIDS) {
        return null;
    }

    @ApiMethod
    public KeywordResponse keyword(String action, Long[] keywordIDS) {
        return null;
    }

    @ApiMethod
    public KeywordResponse keyword(String action, String login, Long[] keywordIDS) {
        return null;
    }

    public ShortCampaignInfo[] getCampaignsList() {
        return getCampaignsList(null);
    }

    @ApiMethod
    public ShortCampaignInfo[] getCampaignsList(List<String> logins) {
        return null;
    }

    @ApiMethod
    public Long stopCampaign(Long campaignID) {
        return null;
    }

    @ApiMethod
    public Long resumeCampaign(Long campaignID) {
        return null;
    }

    @ApiMethod
    public Long archiveCampaign(Long campaignID) {
        return null;
    }

    @ApiMethod
    public Long unArchiveCampaign(Long campaignID) {
        return null;
    }

    @ApiMethod
    public Long stopBanners(Long campaignID, Long[] bannerIDS) {
        return null;
    }


    @ApiMethod
    public Long resumeBanners(Long campaignID, Long[] bannerIDS) {
        return null;
    }


    @ApiMethod
    public Long archiveBanners(Long campaignID, Long[] bannerIDS) {
        return null;
    }


    @ApiMethod
    public Long unArchiveBanners(Long campaignID, Long[] bannerIDS) {
        return null;
    }

    @ApiMethod
    public Long updatePrices(List<PhrasePriceInfo> phrasePriceInfo) {
        return null;
    }

    public PhrasePriceInfo[] setSinglePrice(SinglePriceInfo singlePriceInfo) {
        singlePriceInfo.setMode("SinglePrice");
        return setSinglePrice1(singlePriceInfo);
    }

    @ApiMethod(methodName = "SetAutoPrice")
    private PhrasePriceInfo[] setSinglePrice1(SinglePriceInfo singlePriceInfo) {
        return null;
    }

    public PhrasePriceInfo[] setWizardPrice(WizardPriceInfo wizardPriceInfo) {
        wizardPriceInfo.setMode("Wizard");
        return setWizardPrice1(wizardPriceInfo);
    }

    @ApiMethod(methodName = "SetAutoPrice")
    private PhrasePriceInfo[] setWizardPrice1(WizardPriceInfo wizardPriceInfo) {
        return null;
    }

    @ApiMethod
    public CampaignBalanceInfo[] getBalance(List<Long> campaignIDs) {
        return null;
    }

    @ApiMethod
    public long createNewReport(NewReportInfo newReportInfo) {
        return 0l;
    }

    @ApiMethod
    public ReportInfo[] getReportList() {
        return null;
    }

    @ApiMethod(withoutNane = true)
    public Long deleteReport(Long reportId) {
        return null;
    }

    @ApiMethod
    public StatItem[] getSummaryStat(GetSummaryStatRequest getSummaryStatRequest) {
        return null;
    }

    @ApiMethod
    public GetBannersStatResponse getBannersStat(NewReportInfo newReportInfo) {
        return null;
    }

    @ApiMethod
    public Long createNewWordstatReport(NewWordstatReportInfo newWordstatReportInfo) {
        return null;
    }

    @ApiMethod(withoutNane = true)
    public Long deleteWordstatReport(Long reportId) {
        return null;
    }

    @ApiMethod
    public WordstatReportStatusInfo[] getWordstatReportList() {
        return null;
    }

    @ApiMethod(withoutNane = true)
    public WordstatReportInfo[] getWordstatReport(Long reportId) {
        return null;
    }

    @ApiMethod
    public String[] getKeywordsSuggestion(String[] keywords) {
        return null;
    }

    @ApiMethod(methodName = "GetChanges")
    public GetChangesResponse getCampaignChanges(Long[] campaignIDS, String timestamp) {
        return null;
    }

    @ApiMethod(methodName = "GetChanges")
    public GetChangesResponse getBannerChanges(Long[] bannerIDS, String timestamp) {
        return null;
    }

    @ApiMethod
    public RegionInfo[] getRegions() {
        return null;
    }

    @ApiMethod
    public RubricInfo[] getRubrics() {
        return null;
    }

    @ApiMethod
    public TimeZoneInfo[] getTimeZones() {
        return null;
    }

    @ApiMethod
    public StatGoalInfo[] getStatGoals(Long[] campaignIDS) {
        return null;
    }

    @ApiMethod
    public Long pingAPI() {
        return null;
    }

    @ApiMethod
    public EventsLogItem[] getEventsLog(GetEventsLogRequest getEventsLogRequest) {
        return null;
    }

    public List<AdImageActionResult> uploadImage(List<AdImageURL> adImages) {
        AdImageRequest adImageRequest = new AdImageRequest("Upload", adImages);
        AdImageResponse adImageResponse = adImage(adImageRequest);
        List<AdImageActionResult> actionsResult = adImageResponse.getActionsResult();
        return actionsResult;
    }

    public List<AdImageActionResult> uploadRawData(List<Base64EncodedImage> images) {

        ArrayList<AdImageRaw> adImageRaws = new ArrayList<AdImageRaw>();

        for (Base64EncodedImage base64EncodedImage : images) {
            AdImageRaw adImageRaw
                    = new AdImageRaw(base64EncodedImage.getName(), base64EncodedImage.getBase64EncodedString());
            adImageRaws.add(adImageRaw);
        }

        AdImageRequest adImageRequest = new AdImageRequest("UploadRawData", adImageRaws);
        AdImageResponse adImageResponse = adImage(adImageRequest);
        List<AdImageActionResult> actionsResult = adImageResponse.getActionsResult();
        return actionsResult;
    }

    public List<AdImage> getImages(AdImageSelectionCriteria adImageSelectionsCriteria) {
        AdImageRequest adImageRequest = new AdImageRequest("Get", adImageSelectionsCriteria);
        AdImageResponse adImageResponse = adImage(adImageRequest);
        List<AdImage> actionsResult = adImageResponse.getAdImages();
        return actionsResult;
    }

    public List<AdImageUpload> checkUploadStatus(AdImageSelectionCriteria adImageSelectionsCriteria) {

        AdImageRequest adImageRequest = new AdImageRequest("CheckUploadStatus", adImageSelectionsCriteria);
        AdImageResponse adImageResponse = adImage(adImageRequest);
        List<AdImageUpload> actionsResult = adImageResponse.getAdImageUploads();
        return actionsResult;
    }

    public List<AdImageUpload> deleteImage(AdImageSelectionCriteria adImageSelectionsCriteria) {

        AdImageRequest adImageRequest = new AdImageRequest("Delete", adImageSelectionsCriteria);
        AdImageResponse adImageResponse = adImage(adImageRequest);
        List<AdImageUpload> actionsResult = adImageResponse.getAdImageUploads();
        return actionsResult;
    }

    public AdImageLimit getLimits() {
        AdImageRequest adImageRequest = new AdImageRequest("GetLimits",
                new AdImageSelectionCriteria());
        AdImageResponse adImageResponse = adImage(adImageRequest);
        List<AdImageLimit> actionsResult = adImageResponse.getAdImageLimits();
        return actionsResult.get(0);
    }

    @ApiMethod
    private AdImageResponse adImage(AdImageRequest adImageRequest) {
        return null;
    }

    public List<AdImageAssociation> getImageAssociation(AdImageAssociationSelectionCriteria selectionCriteria) {
        AdImageAssociationRequest adImageAssociationRequest = new AdImageAssociationRequest("Get", selectionCriteria);
        AdImageAssociationResponse adImageAssociationResponse = adImageAssociation(adImageAssociationRequest);
        return adImageAssociationResponse.getAdImageAssociations();
    }

    public List<AdImageAssociationActionResult> setImageAssociation(List<AdImageAssociation> adImageAssociations) {
        AdImageAssociationRequest adImageAssociationRequest
                = new AdImageAssociationRequest("Set", adImageAssociations);
        AdImageAssociationResponse adImageAssociationResponse = adImageAssociation(adImageAssociationRequest);
        return adImageAssociationResponse.getAdImageAssociationActionResult();
    }


    @ApiMethod
    private AdImageAssociationResponse adImageAssociation(AdImageAssociationRequest imageAssociationRequest) {
        return null;
    }


    public RetargetingGoal[] getRetargetingGoals() {
        return getRetargetingGoals(new String[]{"k"});
    }

    @ApiMethod
    private RetargetingGoal[] getRetargetingGoals(String[] logins) {
        return null;
    }


    public List<RetargetingConditionActionResult> addRetargetingCondition(List<RetargetingCondition> retargetingCondition) {
        RetargetingConditionRequest retargetingConditionRequest = new RetargetingConditionRequest("Add", retargetingCondition);
        return retargetingCondition(retargetingConditionRequest).getActionsResult();
    }


    public List<RetargetingConditionActionResult> updateRetargetingCondition(List<RetargetingCondition> retargetingCondition) {
        RetargetingConditionRequest retargetingConditionRequest = new RetargetingConditionRequest("Update", retargetingCondition);
        return retargetingCondition(retargetingConditionRequest).getActionsResult();
    }

    public List<RetargetingCondition> getRetargetingCondition(RetargetingConditionSelectionCriteria selectionCriteria) {
        RetargetingConditionRequest retargetingConditionRequest = new RetargetingConditionRequest("Get", selectionCriteria);
        return retargetingCondition(retargetingConditionRequest).getRetargetingConditions();
    }

    public RetargetingConditionResponse deleteRetargetingCondition(RetargetingConditionSelectionCriteria selectionCriteria) {
        RetargetingConditionRequest retargetingConditionRequest = new RetargetingConditionRequest("Delete", selectionCriteria);
        return retargetingCondition(retargetingConditionRequest);
    }

    @ApiMethod
    private RetargetingConditionResponse retargetingCondition(RetargetingConditionRequest retargetingConditionRequest) {
        return null;
    }


    public List<RetargetingActionResult> addRetargeting(List<Retargeting> retargeting) {
        RetargetingRequest retargetingRequest = new RetargetingRequest("Add", retargeting);
        return retargeting(retargetingRequest).getActionsResult();
    }


    public List<RetargetingActionResult> updateRetargeting(List<Retargeting> retargeting) {
        RetargetingRequest retargetingRequest = new RetargetingRequest("Update", retargeting);
        return retargeting(retargetingRequest).getActionsResult();
    }


    public List<RetargetingActionResult> deleteRetargeting(RetargetingSelectionCriteria selectionCriteria) {
        RetargetingRequest retargetingRequest = new RetargetingRequest("Delete", selectionCriteria);
        return retargeting(retargetingRequest).getActionsResult();
    }


    public List<Retargeting> getRetargeting(RetargetingSelectionCriteria selectionCriteria) {
        RetargetingRequest retargetingRequest = new RetargetingRequest("Get", selectionCriteria);
        return retargeting(retargetingRequest).getRetargetings();
    }

    @ApiMethod
    private RetargetingResponse retargeting(RetargetingRequest retargetingRequest) {
        return null;
    }

    @ApiMethod
    @FinancialMethod
    public CreditLimitsInfo getCreditLimits() {
        return null;
    }

    @ApiMethod
    @FinancialMethod
    public String createInvoice(CreateInvoiceInfo[] payments) {
        return null;
    }

    @ApiMethod
    @FinancialMethod
    public Long payCampaigns(PayCampaignsInfo payCampaignsInfo) {
        return null;
    }

    public Long transferMoney(List<PayCampElement> from, List<PayCampElement> to) {
        TransferMoneyInfo transferMoneyInfo = new TransferMoneyInfo(from, to);
        return transferMoney(transferMoneyInfo);
    }

    @ApiMethod
    @FinancialMethod
    private Long transferMoney(TransferMoneyInfo transferMoneyInfo) {
        return null;
    }

    @ApiMethod
    @FinancialMethod
    public EnableSharedAccountResponse enableSharedAccount(String login) {
        return null;
    }

    public List<AccountActionResult> deposit(List<Payment> payments) {
        AccountManagementRequest accountManagement = new AccountManagementRequest("Deposit", payments);
        return accountManagement(accountManagement).getActionsResult();
    }

    public List<AccountActionResult> invoice(List<Payment> payments) {
        AccountManagementRequest accountManagement = new AccountManagementRequest("Invoice", payments);
        return accountManagement(accountManagement).getActionsResult();
    }

    public List<AccountActionResult> transferMoney(List<Transfer> transfers) {
        AccountManagementRequest accountManagement = new AccountManagementRequest("TransferMoney", transfers);
        return accountManagement(accountManagement).getActionsResult();
    }

    public List<Account> getAccounts(AccountSelectionCriteria selectionCriteria) {
        AccountManagementRequest accountManagement = new AccountManagementRequest("Get", selectionCriteria);
        return accountManagement(accountManagement).getAccounts();
    }

    public List<AccountActionResult> update(List<Account> accounts) {
        AccountManagementRequest accountManagement = new AccountManagementRequest("Update", accounts);
        return accountManagement(accountManagement).getActionsResult();
    }


    @ApiMethod
    @FinancialMethod
    private AccountManagementResponse accountManagement(AccountManagementRequest accountManagementRequest) {
        return null;
    }


    @ApiMethod
    public ClientInfo getClientInfo() {
        return getClientInfo(new ArrayList<String>());
    }

    @ApiMethod
    public ClientInfo getClientInfo(List<String> logins) {
        return null;
    }

    public ClientInfo createNewSubclient(String login, String name, String surname) {
        CreateNewSubclientRequest createNewSubclientRequest = new CreateNewSubclientRequest(login, name, surname);
        return createNewSubclient(createNewSubclientRequest);
    }

    public ClientInfo createNewSubclient(String login, String name, String surname, String currency) {
        CreateNewSubclientRequest createNewSubclientRequest = new CreateNewSubclientRequest(login, name, surname, currency);
        return createNewSubclient(createNewSubclientRequest);
    }

    @ApiMethod
    private ClientInfo createNewSubclient(CreateNewSubclientRequest subclientRequest) {
        return null;
    }


    public ClientInfo[] getClientsList() {
        return getClientsList(new ClientInfoRequest(new ClientFilter("Yes")));
    }


    public ClientInfo[] getClientsList(boolean showArch) {
        if (showArch)
            return getClientsList(new ClientInfoRequest(new ClientFilter("Yes")));
        else
            return getClientsList(new ClientInfoRequest(new ClientFilter("No")));
    }


    @ApiMethod
    private ClientInfo[] getClientsList(ClientInfoRequest filter) {
        return null;
    }


    @ApiMethod
    public ClientsUnitInfo[] getClientsUnits(List<String> logins) {
        return null;
    }


    public ShortClientInfo[] getSubClients(String login) {
        GetSubClientsRequest getSubClientsRequest = new GetSubClientsRequest();
        getSubClientsRequest.setLogin(login);
        return getSubClients(getSubClientsRequest);
    }


    public ShortClientInfo[] getSubClients(String login, boolean showArch) {
        GetSubClientsRequest getSubClientsRequest = new GetSubClientsRequest();
        getSubClientsRequest.setLogin(login);

        if (showArch)
            getSubClientsRequest.setFilter(new ClientFilter("Yes"));
        else
            getSubClientsRequest.setFilter(new ClientFilter("No"));

        return getSubClients(getSubClientsRequest);
    }


    @ApiMethod
    private ShortClientInfo[] getSubClients(GetSubClientsRequest getSubClientsRequest) {
        return null;
    }

    @ApiMethod
    public Long updateClientInfo(List<ClientInfo> clientInfo) {
        return null;
    }

}
