package com.HotelService.controller;

import com.HotelService.entity.Admin;
import com.HotelService.service.AdminService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@RunWith(SpringRunner.class)
@WebMvcTest(AdminController.class)
public class AdminControllerTest {

    @MockBean
    private AdminService adminService;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        //Init MockMvc Object and build
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void list() throws Exception {
        List<Admin> list = new ArrayList<>();

        Long id = 100L;
        String RoomNum = "100";
        String email = "baugh248730@gmail.com";
        String name = "kim";

        list.add(Admin.builder()
                .id(id)
                .email(email)
                .name(name)
                .build());

        given(adminService.getGuest()).willReturn(list);

        mvc.perform(get("/reservation"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("kim")));

    }

    @Test
    public void create() throws Exception {
        String RoomNum = "100";
        String email = "admin@exmaple.com";
        String name = "Administrator";
        String phone = "010-1234-5678";

        Admin mockadmin = Admin.builder().room(RoomNum).email(email).name(name).phone(phone).build();

        given(adminService.addGuest(RoomNum, email, name, phone)).willReturn(mockadmin);

        mvc.perform(post("/reservation")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"room\":\"100\" , \"email\":\"admin@exmaple.com\", \"name\":\"Administrator\",\"phone\" :\"010-1234-5678\"}"))
                .andExpect(status().isCreated());

        verify(adminService).addGuest(RoomNum, email, name, phone);
    }

    @Test
    public void checkout() throws Exception {
        String RoomNum = "100";

        mvc.perform(delete("/reservation/100"))
                .andExpect(status().isOk());

        verify(adminService).delete(RoomNum);

    }

    @Test
    public void update() throws Exception {
        Long id = 100L;
        String RoomNum = "100";
        String email = "admin@exmaple.com";
        String name = "Administrator";
        String phonenum = "010-1234-5678";

        Admin admin = Admin.builder().room(RoomNum).email(email).name(name).phone(phonenum).build();

        given(adminService.updateGuest(id, email, name, phonenum)).willReturn(admin);

        mvc.perform(patch("/reservation/100")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"email\":\"admin@exmaple.com\",\"name\":\"Administrator\"," +
                        "\"phone\":\"010-1234-5678\" }"))
                .andExpect(status().isOk());

        verify(adminService).updateGuest(id, email, name, phonenum);

    }


}