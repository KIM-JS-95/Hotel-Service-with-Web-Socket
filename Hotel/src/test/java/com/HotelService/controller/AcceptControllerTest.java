package com.HotelService.controller;

import com.HotelService.service.AcceptService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AcceptController.class)
@MockBean(JpaMetamodelMappingContext.class)
public class AcceptControllerTest {

    @MockBean
    private AcceptService acceptService;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    //Init MockMvc Object and build
    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void list() throws Exception {
        mvc.perform(get("/request"))
                .andExpect(status().isOk());
    }

//    @Test
//    public void cancel() throws Exception {
//        Long id = 1L;
//
//        mvc.perform(delete("/cancel/1"))
//                .andExpect(status().isOk());
//
//        verify(acceptService).cancel(id);
//    }

}