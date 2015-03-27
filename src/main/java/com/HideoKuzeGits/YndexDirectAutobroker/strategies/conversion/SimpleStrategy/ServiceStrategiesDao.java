package com.HideoKuzeGits.YndexDirectAutobroker.strategies.conversion.SimpleStrategy;

import com.HideoKuzeGits.YndexDirectAutobroker.domain.strategies.ServiceStrategy;
import com.HideoKuzeGits.YndexDirectAutobroker.strategies.StrategiesDao;
import com.google.common.collect.ArrayListMultimap;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

import static com.HideoKuzeGits.YndexDirectAutobroker.UsefulStaticMethods.convertToMap;
import static com.HideoKuzeGits.YndexDirectAutobroker.UsefulStaticMethods.convertToMultiMap;
import static com.HideoKuzeGits.YndexDirectAutobroker.UsefulStaticMethods.isNullOrEmpty;

/**
 * Created by root on 19.09.14.
 */
@Service
public class ServiceStrategiesDao extends StrategiesDao{


    @PersistenceContext
    private EntityManager em;



    public Map<Long, ServiceStrategy> getBannersStrategy(Long campaignID) {
        Query query = em.createQuery("SELECT a FROM ServiceStrategy a " +
                "WHERE a.campaignId = :campaignID " +
                "AND a.id = a.bannerId " +
                "AND TYPE(a) = ServiceStrategy");
        query.setParameter("campaignID", campaignID);
        List<ServiceStrategy> resultList = (List<ServiceStrategy>) query.getResultList();


        Map<Long, ServiceStrategy> strategiesMap = null;

        try {
            strategiesMap = convertToMap(resultList, "id");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return strategiesMap;
    }


    @Transactional
    public void removeCampaignBannersStrategy(Long campaignID) {

        TypedQuery<ServiceStrategy> query = em.createQuery("SELECT a FROM ServiceStrategy a " +
                "WHERE a.campaignId = :campaignID and a.id = a.bannerId", ServiceStrategy.class);
        query.setParameter("campaignID", campaignID);

        List<ServiceStrategy> serviceStrategies = query.getResultList();

        for (ServiceStrategy serviceStrategy : serviceStrategies)
            em.remove(serviceStrategy);

    }
}
