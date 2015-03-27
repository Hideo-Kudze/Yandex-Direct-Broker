package com.HideoKuzeGits.YndexDirectAutobroker.xlsImport;

import com.HideoKuzeGits.yndexDirectAPI.YndexDirectAPI;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.AdImageAssociation;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.AdImageSelectionCriteria;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.AdImageUpload;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by root on 08.09.14.
 */
public class ImageAssociationTask implements Runnable {

    private YndexDirectAPI yndexDirectApi;
    private List<Long> adImagesTasksIDs;
    private Multimap<String, Long> imageUrlBannerIdMap;


    public ImageAssociationTask(YndexDirectAPI yndexDirectApi, List<Long> adImagesTasksIDs, Multimap<String, Long> imageUrlBannerIdMap) {
        this.yndexDirectApi = yndexDirectApi;
        this.adImagesTasksIDs = adImagesTasksIDs;
        this.imageUrlBannerIdMap = imageUrlBannerIdMap;
    }

    @Override
    public void run() {


        try {
            Thread.sleep(1000 *60 *60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        AdImageSelectionCriteria adImageSelectionsCriteria = new AdImageSelectionCriteria();
        adImageSelectionsCriteria.setAdImageUploadTaskIDS(adImagesTasksIDs);
        List<AdImageUpload> adImageUploads = yndexDirectApi.checkUploadStatus(adImageSelectionsCriteria);
        ArrayList<AdImageAssociation> imageAssociations = new ArrayList<AdImageAssociation>();

        for (AdImageUpload adImageUpload : adImageUploads) {

            String url = adImageUpload.getSourceURL();
            String adImageHash = adImageUpload.getAdImageHash();
            Collection<Long> bannersId = imageUrlBannerIdMap.get(url);

            if (adImageHash != null) {

                for (Long bannerId : bannersId) {
                    AdImageAssociation adImageAssociation = new AdImageAssociation(bannerId, adImageHash);
                    imageAssociations.add(adImageAssociation);
                }

            }
        }

        yndexDirectApi.setImageAssociation(imageAssociations);
    }
}
