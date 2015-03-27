package com.HideoKuzeGits.YndexDirectAutobroker.strategies.conversion.ANYStrategy;

import com.HideoKuzeGits.YndexDirectAutobroker.domain.strategies.ANYStrategy;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.strategies.ServiceStrategy;
import com.HideoKuzeGits.YndexDirectAutobroker.strategies.StrategiesDao;
import com.HideoKuzeGits.yndexDirectAPI.YndexDirectAPI;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 19.09.14.
 */
@Service
public class ANYStrategiesDao extends StrategiesDao {

    @PersistenceContext
    private EntityManager em;


    public List<ANYStrategy> getAllStrategies() {

        TypedQuery<ANYStrategy> query
                = em.createQuery("SELECT a FROM ServiceStrategy a WHERE TYPE(a) =:strategyClass", ANYStrategy.class);
        return query.getResultList();
    }

    @Transactional
    public void saveStrategy(ANYStrategy strategy) {

        String token = strategy.getYndexDirectAccount().getToken();
        YndexDirectAPI yndexDirectAPI = yndexDirectApiFactory.createYndexDirectApi(token);

        makeCampaignControlled(strategy.getId(), yndexDirectAPI);
        removeStrategy(strategy.getId());

        em.merge(strategy);

    }


    @Override
    @Transactional
    public void removeStrategy(Long id) {

        ANYStrategy strategy = em.find(ANYStrategy.class, id);

        if (strategy != null)
            em.remove(strategy);
    }
}
