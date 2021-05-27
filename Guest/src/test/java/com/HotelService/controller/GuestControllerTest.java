package com.HotelService.controller;

import com.HotelService.entity.Guest;
import com.HotelService.service.GuestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
        LocalDate start = LocalDate.of(2021,05, 20);
        LocalDate end = LocalDate.of(2021,05, 27);


        Guest guest = Guest.builder()
                .id(id)
                .email(email)
                .name(name)
                .phonenum(phonenum)
                .start(start)
                .end(end)
                .build();

        given(guestService.CIrequest(email, name, phonenum, start, end)).willReturn(guest);

        mvc.perform(post("/CheckIn")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"admin@exmaple.com\", \"name\":\"Administrator\",\"phonenum\":\"010-1234-5678\",\"start\":\"2021-05-20\",\"end\":\"2021-05-27\"}"))
                .andExpect(status().isCreated());


        verify(guestService).CIrequest(email, name, phonenum, start, end);
    }

    @Test
    public void createfaild() throws Exception {

        Long id = 1L;
        String email = "baugh247@gmail.com";
        String name = "Administrator";
        String phonenum = "010-1234-5678";
        LocalDate start = LocalDate.of(2021,05, 20);
        LocalDate end = LocalDate.of(2021,05, 27);

        Guest guest = Guest.builder()
                .id(id)
                .email(email)
                .name(name)
                .phonenum(phonenum)
                .start(start)
                .end(end)
                .build();

        given(guestService.CIrequest(email, name, phonenum,start,end)).willReturn(guest);

        mvc.perform(post("/CheckIn")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"\", \"name\":\"Administrator\",\"phonenum\":\"010-1234-5678\"}"))
                .andExpect(status().isBadRequest());

    }


}