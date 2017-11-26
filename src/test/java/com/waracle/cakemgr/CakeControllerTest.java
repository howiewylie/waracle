package com.waracle.cakemgr;

import com.waracle.cakemgr.service.CakeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CakeControllerTest {

    @Mock
    private CakeService cakeService;

    @InjectMocks
    private CakeController cakeController;

    private MockMvc mockMvc;

    @Before
    public void setup() {

        // Process mock annotations
        MockitoAnnotations.initMocks(this);

        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(cakeController).build();

    }

    @Test
    public void testGetCakesSuccess() throws Exception {
        List<CakeEntity> cakeList = new ArrayList<CakeEntity>();
        CakeEntity cake1 = new CakeEntity();
        cake1.setTitle("Cake1");
        cake1.setDescription("Nice cake");
        cake1.setImage("cake1ImgUrl");
        CakeEntity cake2 = new CakeEntity();
        cake2.setTitle("Cake2");
        cake2.setDescription("Nice cake too");
        cake2.setImage("cake2ImgUrl");
        cakeList.add(cake1);
        cakeList.add(cake2);

        when(cakeService.getCakes()).thenReturn(cakeList);
        mockMvc.perform(get("/cakes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));

    }

    @Test
    public void testAddCakesSuccess() throws Exception {

        CakeEntity freshCake = new CakeEntity();
        freshCake.setTitle("Cake3");
        freshCake.setDescription("Nice cake number 3");
        freshCake.setImage("cake3ImgUrl");

        doNothing().when(cakeService).addCake(freshCake);
        mockMvc.perform(get("/cakes"))
                .andExpect(status().isOk());

    }

}
