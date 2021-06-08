package com.HotelService.controller;

import com.HotelService.entity.Admin;
import com.HotelService.service.AdminService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@SpringBootTest(classes = {AdminController.class})
@RunWith(SpringRunner.class)
@WebMvcTest(AdminController.class)
public class AdminControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AdminService adminService;

//    @Mock
//    private RoomRepository roomRepository;
//
//    @Mock
//    private AdminRepository adminRepository;
//
//    @Before
//    public void setUp(){
//        MockitoAnnotations.initMocks(this);
//        adminService = new AdminService(roomRepository, adminRepository);
//    }

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void list() throws Exception {
        List<Admin> list = new ArrayList<>();

        Long id = 100L;
        String RoomNum = "100";
        String people = "10";
        String email = "baugh248730@gmail.com";
        String name = "kim";
        String phonenum = "010-1234-4556";

        list.add(Admin.builder()
                .id(id)
                .email(email)
                .name(name)
                .phonenum(phonenum)
                .people(people)
                .build());

        given(adminService.Guestlist()).willReturn(list);

        mvc.perform(get("/stay"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("kim")));

    }


    @Test
    public void checkout() throws Exception {
        String RoomNum = "100";

        mvc.perform(delete("/stay/100"))
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
        String people = "10";

        Admin admin = Admin.builder().email(email).name(name).phonenum(phonenum).people(people).build();

        given(adminService.updateGuest(id, email, name, phonenum)).willReturn(admin);

        mvc.perform(put("/stay/100")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"email\":\"admin@exmaple.com\",\"name\":\"Administrator\",\"phonenum\":\"010-1234-5678\" }"))
                .andExpect(status().isOk());

        verify(adminService).updateGuest(id, email, name, phonenum);

    }


}