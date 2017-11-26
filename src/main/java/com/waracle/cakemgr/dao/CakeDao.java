package com.waracle.cakemgr.dao;

import com.waracle.cakemgr.CakeEntity;

import java.util.List;

public interface CakeDao {

    List<CakeEntity> findCakes();

    void createCake(CakeEntity cakeEntity);
}
