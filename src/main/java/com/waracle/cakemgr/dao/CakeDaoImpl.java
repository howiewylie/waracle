package com.waracle.cakemgr.dao;

import com.waracle.cakemgr.CakeEntity;
import com.waracle.cakemgr.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CakeDaoImpl implements CakeDao {

    private static Logger logger = LoggerFactory.getLogger(CakeDaoImpl.class);

    @Override
    public List<CakeEntity> findCakes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createCriteria(CakeEntity.class).list();
    }

    @Override
    public void createCake(CakeEntity cakeEntity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(cakeEntity);
            logger.debug("adding cake entity");
            session.getTransaction().commit();
        } catch (ConstraintViolationException ex) {
            logger.error("Could not add cake to table:" + ex.getMessage());
        }
        session.close();

    }
}
