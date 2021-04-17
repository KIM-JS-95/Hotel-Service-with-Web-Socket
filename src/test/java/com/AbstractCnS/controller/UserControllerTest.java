package com.AbstractCnS.controller;

import com.AbstractCnS.entity.Guest;
import com.AbstractCnS.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private JwtUtil jwtUtil;

    @MockBean
    private UserService userService;


    @Test
    public void list() throws Exception {

        List<Guest> guset = new ArrayList<>();

        guset.add(Guest.builder()
                .email("tester@example.com")
                .name("Tester")
                .build());

        given(userService.getUser()).willReturn(guset);

        mvc.perform(get("/reservation"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Tester")));
    }

    @Test
    public void creat() throws Exception {
        Long id = 1004L;
        String email = "admin@exmaple.com";
        String name = "Administrator";
        String password = "test";

        Guest mockUser = Guest.builder().id(id).name(name).build();

        given(userService.authenticate(email, password)).willReturn(mockUser);

        given(jwtUtil.createToken(id, name, null))
                .willReturn("header.payload.signature");

        mvc.perform(post("/reservation")
        .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"admin@exmaple.com\",\"name\":\"Administrator\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", "/reservation"))
                .andExpect(content().string(
                        containsString("{\"accessToken\":\"header.payload.signature\"}")
                ));
    }

}