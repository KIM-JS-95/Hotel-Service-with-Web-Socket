package com.HotelService.controller;

import com.HotelService.entity.Admin;
import com.HotelService.entity.Room;
import com.HotelService.entity.RoomDTO;
import com.HotelService.repository.RoomRepository;
import com.HotelService.service.AdminService;
import org.hamcrest.core.StringContains;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(AdminController.class)
public class AdminControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AdminService adminService;

    @Mock
    private RoomRepository roomRepository;


    // 고객 전체 리스트 조회
    @Test
    public void list() throws Exception {
        List<Admin> list = new ArrayList<>();

        Long id = 100L;
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

        given(adminService.GuestList()).willReturn(list);

        mvc.perform(get("/stay"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("kim")));

    }

    @Test
    public void checkout() throws Exception {
        Long id = 101L;

        mvc.perform(delete("/stay/101"))
                .andExpect(status().isOk());

        verify(adminService).delete(id);

    }

    @Test
    public void update() throws Exception {
        Long id = 100L;
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

    // 방 정보 추가
    @Test
    public void roomAdd() throws Exception {
        Room room = Room.builder()
                .roomnum("101")
                .bedtype("twin")
                .st("empty")
                .build();

        given(adminService.roomadd(room)).willReturn(room);

        mvc.perform(post("/room")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"roomnum\" : \"101\"}"))
                .andExpect(status().isOk());

    }

    // 방 정보 수정
    @Test
    public void roomupdate() throws Exception {
        Room room = Room.builder()
                .roomnum("101")
                .bedtype("twin")
                .st("empty")
                .build();

        given(adminService.roomadd(room)).willReturn(room);

        Room mockroom = Room.builder()
                .roomnum("201")
                .bedtype("single")
                .st("full")
                .build();

        given(adminService.roomupdate("101", mockroom)).willReturn(mockroom);
        mvc.perform(put("/room/101")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"roomnum\" : \"201\"}"))
                .andExpect(status().isOk());

    }

    // 삭제 기능 추가


}