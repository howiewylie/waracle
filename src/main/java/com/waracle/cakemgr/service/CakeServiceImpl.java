package com.waracle.cakemgr.service;

import com.waracle.cakemgr.CakeEntity;
import com.waracle.cakemgr.HibernateUtil;
import com.waracle.cakemgr.dao.CakeDao;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class CakeServiceImpl implements CakeService{

    private static Logger logger = LoggerFactory.getLogger(CakeServiceImpl.class);

    @Inject
    CakeDao cakeDao;

    @Override
    public List<CakeEntity> getCakes() {
        logger.debug("in CakeService getCakes");
        return cakeDao.findCakes();
    }

    public void addCake(CakeEntity cakeEntity) {
        logger.debug("in CakeService addCake");
        cakeDao.createCake(cakeEntity);
    }


}
