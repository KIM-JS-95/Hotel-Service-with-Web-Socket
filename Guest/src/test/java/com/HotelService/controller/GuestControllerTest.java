package com.HotelService.controller;

import com.HotelService.service.GuestService;
import com.HotelService.entity.Guest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GuestController.class)
public class GuestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private GuestService guestService;

    @Test
    public void create() throws Exception {

        Long id = 1L;
        String email = "admin@exmaple.com";
        String name = "Administrator";
        String phonenum = "010-1234-5678";

        Guest guest = Guest.builder()
                .id(id)
                .email(email)
                .name(name)
                .phonenum(phonenum)
                .build();

        given(guestService.CIrequest(email,name,phonenum)).willReturn(guest);

        mvc.perform(post("/CheckIn")
        .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"admin@exmaple.com\", \"name\":\"Administrator\",\"phonenum\":\"010-1234-5678\"}"))
                .andExpect(status().isCreated());


        verify(guestService).CIrequest(email,name,phonenum);
    }

    @Test
    public void createfaild() throws Exception {

        Long id = 1L;
        String email = " ";
        String name = "Administrator";
        String phonenum = "010-1234-5678";

        Guest guest = Guest.builder()
                .id(id)
                .email(email)
                .name(name)
                .phonenum(phonenum)
                .build();

        given(guestService.CIrequest(email,name,phonenum)).willReturn(guest);

        mvc.perform(post("/CheckIn")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"\", \"name\":\"Administrator\",\"phonenum\":\"010-1234-5678\"}"))
                .andExpect(status().isBadRequest());

    }


}