package com.HideoKuzeGits.YndexDirectAutobroker.strategies;

import com.HideoKuzeGits.YndexDirectAutobroker.domain.strategies.ANYStrategy;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.strategies.ServiceStrategy;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.strategies.Strategy;
import com.HideoKuzeGits.yndexDirectAPI.YndexDirectAPI;
import com.HideoKuzeGits.yndexDirectAPI.YndexDirectApiFactory;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.BannerInfo;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.CampaignInfo;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.CampaignStrategy;
import com.google.common.collect.ArrayListMultimap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.*;

import static com.HideoKuzeGits.YndexDirectAutobroker.UsefulStaticMethods.convertToMultiMap;
import static com.HideoKuzeGits.YndexDirectAutobroker.UsefulStaticMethods.isNullOrEmpty;

/**
 * Created by root on 22.07.14.
 */
@Service
public class StrategiesDao {


    @PersistenceContext
    private EntityManager em;

    @Autowired
    protected YndexDirectApiFactory yndexDirectApiFactory;



    @Transactional
    public void saveStrategy(ServiceStrategy strategy) {

        String token = strategy.getYndexDirectAccount().getToken();
        YndexDirectAPI yndexDirectAPI = yndexDirectApiFactory.createYndexDirectApi(token);

        setStrategyCamaingId(yndexDirectAPI, strategy);
        makeCampaignControlled(strategy.getCampaignId(), yndexDirectAPI);

        removeStrategy(strategy.getId());

        em.merge(strategy);
    }

    protected Long setStrategyCamaingId(YndexDirectAPI yndexDirectAPI, ServiceStrategy strategy) {
        Long campaignID;
        if (strategy.getCampaignId() != null) {
            campaignID = strategy.getCampaignId();
            strategy.setId(campaignID);
        } else {
            Long bannerID = strategy.getBannerId();
            strategy.setId(bannerID);
            Long[] bannerIDS = new Long[]{bannerID};
            BannerInfo[] bannerPhrases = yndexDirectAPI.getBanners(bannerIDS);
            campaignID = bannerPhrases[0].getCampaignID();
            strategy.setCampaignId(campaignID);
        }
        return campaignID;
    }


    protected void makeCampaignControlled(Long campaignId, YndexDirectAPI yndexDirectAPI) {

        CampaignInfo campaignInfo = yndexDirectAPI.getCampaignsParams(new Long[]{campaignId})[0];
        campaignInfo.setStrategy(new CampaignStrategy("HighestPosition"));
        campaignInfo.setConsiderTimeTarget("Yes");
        yndexDirectAPI.createOrUpdateCampaign(campaignInfo);
    }


    public<T>  List<T> getAllStrategies(Class T) {

        Query query;

        if (T.equals(ANYStrategy.class))
            query = em.createQuery("SELECT a FROM ANYStrategy a", T);
        else{
            query = em.createQuery("SELECT a FROM ServiceStrategy a WHERE TYPE(a) =:strategyClass",
                    ServiceStrategy.class);
            query.setParameter("strategyClass", T);
        }




        return query.getResultList();
    }


    public ArrayListMultimap<Object, Strategy> getCampaignsStrategy(String userName) {

        TypedQuery query = em.createQuery("SELECT DISTINCT a FROM ServiceStrategy a " +
                "INNER JOIN a.yndexDirectAccount b WHERE b.normalized_user_name = :userName " +
                "AND a.id = a.campaignId " ,
                ServiceStrategy.class);
        query.setParameter("userName", userName);
        List<Strategy> resultList = query.getResultList();

        query = em.createQuery("SELECT DISTINCT a FROM ANYStrategy a " +
                "INNER JOIN a.yndexDirectAccount b WHERE b.normalized_user_name = :userName ",
                ANYStrategy.class);
        query.setParameter("userName", userName);
        resultList.addAll(query.getResultList());



        return strategyListToMultimap(resultList);
    }

    @Transactional
    public void removeStrategy(Long id) {

        ServiceStrategy strategy = em.find(ServiceStrategy.class, id);

        if (strategy != null)
            em.remove(strategy);


    }


    public static<T> ArrayListMultimap<Object, T> strategyListToMultimap(List<T> list) {

        if (isNullOrEmpty(list))
            return null;

        ArrayListMultimap<Object, T> map = null;

        try {
            map = convertToMultiMap(list, "id");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }


}
