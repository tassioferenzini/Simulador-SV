/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.puc_rio.inf.les.med.dao;

import br.puc_rio.inf.les.med.db.PersistenceUtil;
import static br.puc_rio.inf.les.med.db.PersistenceUtil.closeEntityManager;
import br.puc_rio.inf.les.med.model.TbPatientData;
import java.util.List;
import javax.persistence.EntityManager;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author tassio
 */
public class TbPatientDataDAO {

    Logger logger = Logger.getLogger("DAO");
    public static TbPatientDataDAO patientDataDAO;

    public static TbPatientDataDAO getInstance() {
        if (patientDataDAO == null) {
            patientDataDAO = new TbPatientDataDAO();
        }
        return patientDataDAO;
    }

    public TbPatientData save(TbPatientData value) {
        logger.trace("Start Method");
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            value = em.merge(value);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            logger.error("Unexpected error", e);
        } finally {
            logger.trace("Ended Method");
        }
        return value;
    }

    public List<TbPatientData> getAll() {
        logger.trace("Start Method");
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            javax.persistence.Query query = em.createQuery("from TbPatientData As a");
            return query.getResultList();
        } catch (Exception ex) {
            logger.error("Unexpected error", ex);
        } finally {
            logger.trace("Ended Method");
            closeEntityManager();
        }
        return null;
    }

    private static Session session;

    public TbPatientData get(int value) {
        logger.trace("Start Method");
        try {
            session = PersistenceUtil.getSession();
            Query query = session.createQuery("select a from TbPatientData as a where  a.pkId=:value");
            query.setParameter("value", value);

            List<TbPatientData> instances = query.list();
            if (instances != null && instances.size() > 0) {
                return instances.get(0);
            }
            return null;
        } catch (Exception ex) {
            logger.error("Unexpected error", ex);
        } finally {
            logger.trace("Ended Method");
        }
        return null;
    }

    public void delete(TbPatientData value) {
        logger.trace("Start Method");
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            value = em.merge(value);
            em.remove(value);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            logger.error("Unexpected error", e);
        } finally {
            logger.trace("Ended Method");
            closeEntityManager();
        }
    }

    public void deleteAll() {
        logger.trace("Start Method");
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            javax.persistence.Query query = em.createQuery(" delete from TbPatientData");
            query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            logger.error("Unexpected error", e);
            em.getTransaction().rollback();
        } finally {
            logger.trace("Ended Method");
            closeEntityManager();
        }
    }
}
