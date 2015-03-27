package com.HideoKuzeGits.YndexDirectAutobroker.xlsImport;

import com.HideoKuzeGits.YndexDirectAutobroker.SessionAttributeWrap;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.APIAccounts.YndexDirectAccount;
import com.HideoKuzeGits.YndexDirectAutobroker.utm.CampaignsWithUtmDao;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.CampaignInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;


/**
 * Created by root on 09.09.14.
 */

@Controller
public class XlsUploadController {


    public static final int MAX_FILES_UPLOADS_AT_ONCE = 10;

    @Autowired
    private SessionAttributeWrap sessionWrap;

    @Autowired
    public XlsDirectParserService xlsParser;

    @Autowired
    public CampaignsWithUtmDao campaignsWithUtmDao;


    @RequestMapping(value = "/uploadXls", method = RequestMethod.POST)
    @ResponseBody public String uploadXls(MultipartHttpServletRequest multipartRequest,
                                          HttpServletResponse response) {

        response.setHeader("ContentType", "application/json; charset=utf-8");


        if (sessionWrap.isEmpty())
            return "redirect:/directAccounts";

        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();

        if (fileMap.size() > MAX_FILES_UPLOADS_AT_ONCE)
            throw new XlsFileUploadException("To many files at once.");

        Collection<MultipartFile> files = fileMap.values();

        //Check file size. If at least if one file is too large then neither is being loaded.
        for (MultipartFile file : files) {
            if (file.getSize() > 1024 * 1024 * 2)
                throw new XlsFileUploadException("To large file" + file.getName());
        }

        for (MultipartFile file : files) {

            InputStream inputStream = null;

            try {
                inputStream = file.getInputStream();

                BannerCollection bannerCollection = xlsParser.parse(inputStream);
                bannerCollection.uploadToDirect(sessionWrap.getApi());
                CampaignInfo campaignInfo = bannerCollection.getCampaignInfo();
                YndexDirectAccount account = sessionWrap.getAccount();

                campaignsWithUtmDao.saveCampaignWithUtm(campaignInfo, account);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null)
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }

        return "{}";
    }

    @RequestMapping(value = "/loadXlsFile")
    public String loadXmlFilePage() {

        if (sessionWrap.isEmpty())
            return "redirect:/directAccounts";

        return "loadXlsFile";

    }

}
