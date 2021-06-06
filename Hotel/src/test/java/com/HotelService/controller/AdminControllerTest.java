package com.HotelService.controller;

import com.HotelService.entity.Admin;
import com.HotelService.service.AdminService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(AdminController.class)
//@MockBean(JpaMetamodelMappingContext.class)
public class AdminControllerTest {

    @MockBean
    private AdminService adminService;

    @Autowired
    private MockMvc mvc;

//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    //Init MockMvc Object and build
//    @Before
//    public void setup() {
//        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }

    @Test
    public void list() throws Exception {
        List<Admin> list = new ArrayList<>();

        Long id = 100L;
        String RoomNum = "100";
        String email = "baugh248730@gmail.com";
        String name = "kim";
        String phonenum = "010-1234-4556";

        list.add(Admin.builder()
                .id(id)
                .room(RoomNum)
                .email(email)
                .name(name)
                .phonenum(phonenum)
                .build());

//        given(adminService.getGuest()).willReturn(list);
//
//        mvc.perform(get("/stay"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("kim")));

    }

//    @Test
//    public void create() throws Exception {
//        String RoomNum = "100";
//        String email = "admin@exmaple.com";
//        String name = "Administrator";
//        String phone = "010-1234-5678";
//        Room roomInfo = null;
//
//        Admin mockadmin = Admin.builder().room(RoomNum).email(email).name(name).phonenum(phone).roomInfo(roomInfo).build();
//
//        given(adminService.addGuest(RoomNum, email, name, phone, roomInfo)).willReturn(mockadmin);
//
//        mvc.perform(post("/reservation")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"room\":\"100\" , \"email\":\"admin@exmaple.com\", " +
//                        "\"name\":\"Administrator\",\"phonenum\" :\"010-1234-5678\"}"))
//                .andExpect(status().isCreated());
//
//        verify(adminService).addGuest(RoomNum, email, name, phone, roomInfo);
//    }

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

        Admin admin = Admin.builder().room(RoomNum).email(email).name(name).phonenum(phonenum).build();

        given(adminService.updateGuest(id, email, name, phonenum)).willReturn(admin);

        mvc.perform(put("/stay/100")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"email\":\"admin@exmaple.com\",\"name\":\"Administrator\"," +
                        "\"phonenum\":\"010-1234-5678\" }"))
                .andExpect(status().isOk());

        verify(adminService).updateGuest(id, email, name, phonenum);

    }


}