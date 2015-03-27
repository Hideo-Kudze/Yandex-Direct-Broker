package com.HideoKuzeGits.YndexDirectAutobroker.SavedMoney;

import com.HideoKuzeGits.YndexDirectAutobroker.domain.Statistic;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 * Created by root on 13.08.14.
 */
@Service
public class StatisticsDao {

    @PersistenceContext
    private EntityManager em;


    @Transactional
    public void save(Statistic statistic) {

        em.merge(statistic);
        em.flush();
    }

    public Statistic getStatistic() {
        TypedQuery<Statistic> query = em.createQuery("SELECT b FROM Statistic b", Statistic.class);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }
}
