package com.waracle.cakemgr.service;

import com.waracle.cakemgr.CakeEntity;
import java.util.List;

public interface CakeService {

    List<CakeEntity> getCakes();

    void addCake(CakeEntity cakeEntity);
}
