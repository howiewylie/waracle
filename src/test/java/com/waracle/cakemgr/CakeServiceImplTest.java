package com.waracle.cakemgr;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.waracle.cakemgr.dao.CakeDao;
import com.waracle.cakemgr.service.CakeService;
import com.waracle.cakemgr.service.CakeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CakeServiceImplTest {

    @Mock
    CakeDao cakeDao;

    @InjectMocks
    CakeService cakeService = new CakeServiceImpl();

    @Test
    public void testGetCakes() {
        when(cakeDao.findCakes()).thenReturn(new ArrayList<CakeEntity>());
        List<CakeEntity> cakeList = cakeService.getCakes();
        assertNotNull(cakeList);
        verify(cakeDao).findCakes();
    }

    @Test
    public void testAddCake() {

        CakeEntity cake = new CakeEntity();
        cake.setTitle("TestTitle");
        cake.setDescription("TestDescription");
        cake.setImage("ImgUrl");
        doNothing().when(cakeDao).createCake(cake);
        cakeService.addCake(cake);
        verify(cakeDao).createCake(cake);
    }

}
