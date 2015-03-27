package com.HideoKuzeGits.YndexDirectAutobroker.utm;

import com.HideoKuzeGits.YndexDirectAutobroker.domain.CampaignWithUTM;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.GoogleAnalytics.AnalyticsGoal;
import com.HideoKuzeGits.YndexDirectAutobroker.domain.APIAccounts.YndexDirectAccount;
import com.HideoKuzeGits.YndexDirectAutobroker.strategies.conversion.CampaignsGoalsWireService;
import com.HideoKuzeGits.yndexDirectAPI.YndexDirectApiFactory;
import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.CampaignInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static com.HideoKuzeGits.YndexDirectAutobroker.UsefulStaticMethods.*;

/**
 * Created by root on 15.08.14.
 */

@Service
public class CampaignsWithUtmDao {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private CampaignsGoalsWireService campaignsGoalsWireService;

    @Autowired
    private YndexDirectApiFactory yndexDirectApiFactory;


    public static void main(String[] args) {

        FileSystemXmlApplicationContext context
                = new FileSystemXmlApplicationContext("//home/hideo/IdeaProjects/YndexDirectAutobroker/src/main/webapp/WEB-INF/spring_hibernate.xml,//home/hideo/IdeaProjects/YndexDirectAutobroker/src/main/webapp/WEB-INF/dispatcher-servlet.xml".split(","));
        ScheduledUtmCampaignCleaner scheduledUtmCampaignCleaner = context.getBean(ScheduledUtmCampaignCleaner.class);
        scheduledUtmCampaignCleaner.removeDeletedCampaign();

     /*  FileSystemXmlApplicationContext context
                = new FileSystemXmlApplicationContext("//home/hideo/IdeaProjects/YndexDirectAutobroker/src/main/webapp/WEB-INF/spring_hibernate.xml,//home/hideo/IdeaProjects/YndexDirectAutobroker/src/main/webapp/WEB-INF/dispatcher-servlet.xml".split(","));
        CampaignsWithUtmDao utmDao = context.getBean(CampaignsWithUtmDao.class);
        utmDao.removeCampaignsWithUtm(Arrays.asList(10416621l));*/



    }


    @Transactional
    public void saveCampaignWithUtm(CampaignWithUTM campaignWithUTM) {

        em.merge(campaignWithUTM);
    }

    @Transactional
    public void saveCampaignWithUtm(CampaignInfo campaignInfo, YndexDirectAccount account) throws IOException {

        Long campaignID = campaignInfo.getCampaignID();
        String name = campaignInfo.getName();
        CampaignWithUTM campaignWithUTM = new CampaignWithUTM();
        campaignWithUTM.setCampaignId(campaignID);
        campaignWithUTM.setYndexDirectAccount(account);
        campaignWithUTM.setName(name);
        campaignsGoalsWireService.addGoalsToCampaign(campaignWithUTM);
        saveCampaignWithUtm(campaignWithUTM);

    }

    public List<CampaignWithUTM> getAllCampaigns() {

        TypedQuery<CampaignWithUTM> query
                = em.createQuery("SELECT b FROM CampaignWithUTM b", CampaignWithUTM.class);
        List<CampaignWithUTM> campaignList = query.getResultList();

        return campaignList;

    }

    public List<CampaignWithUTM> getCampaigns(String userName) {

        TypedQuery<CampaignWithUTM> query
                = em.createQuery("SELECT DISTINCT a FROM CampaignWithUTM a" +
                " INNER JOIN a.yndexDirectAccount b WHERE b.normalized_user_name = :userName"
                , CampaignWithUTM.class);
        query.setParameter("userName", userName);
        List<CampaignWithUTM> campaignList = query.getResultList();

        return campaignList;

    }



    @Transactional
    public void removeCampaignsWithUtm(List<Long> campaignsId) {

        if (isNullOrEmpty(campaignsId))
            return;

        Query query = em.createQuery("DELETE FROM CampaignWithUTM a WHERE a.campaignId in :campaignsId");
        query.setParameter("campaignsId", campaignsId);
        query.executeUpdate();
    }

    public List<AnalyticsGoal> getAllGoals() {

        TypedQuery<AnalyticsGoal> query
                = em.createQuery("SELECT b FROM AnalyticsGoal b", AnalyticsGoal.class);
        return query.getResultList();
    }

    public List<AnalyticsGoal> getGoalsList(Set<Long> goalsId) {

        if (isNullOrEmpty(goalsId))
            return null;

        TypedQuery<AnalyticsGoal> query
                = em.createQuery("SELECT b FROM AnalyticsGoal b WHERE b.id in :goalsId", AnalyticsGoal.class);
        query.setParameter("goalsId", goalsId);
        return query.getResultList();
    }

    @Transactional
    public void removeGoals(Collection<Long> goalsId) {

        if (isNullOrEmpty(goalsId))
            return;

        Query query = em.createQuery("DELETE  FROM AnalyticsGoal b WHERE b.id in :goalsId");
        query.setParameter("goalsId", goalsId);
        query.executeUpdate();
    }


}
