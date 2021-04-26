package com.HotelService.controller;

import com.HotelService.service.RequestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(RequestController.class)
public class RequestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RequestService requestService;

    @Test
    public void list() throws Exception{
        mvc.perform(get("/request"))
                .andExpect(status().isOk());
    }

    @Test
    public void cancel() throws Exception{
        Long id = 1L;

        mvc.perform(delete("/request/1"))
                .andExpect(status().isOk());

        verify(requestService).cancel(id);
    }

}