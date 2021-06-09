package com.HotelService.controller;

import com.HotelService.entity.Admin;
import com.HotelService.entity.Room;
import com.HotelService.repository.RoomRepository;
import com.HotelService.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(AcceptController.class)
public class AcceptControllerTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    private RoomRepository roomRepository;

    @MockBean
    private AdminService adminService;


    @Test
    public void checkIn() throws Exception {
        String roomnum = "100";
        String email = "baugh248730@gmail.com";
        String name = "kim";
        String phonenum = "010-1234-4556";
        String people = "10";

        Room roominfo = Room.builder()
                .idx(1L)
                .roomnum(roomnum)
                .bedtype("twin")
                .st("full")
                .build();

        Admin mockadmin = Admin.builder()
                .email(email)
                .name(name)
                .phonenum(phonenum)
                .people(people)
                .build();

        // 먼저 방 정보를 저장 하고
        given(roomRepository.save(roominfo)).willReturn(roominfo);

        given(adminService.addGuest(email, name, phonenum, people, roomnum))
                .willReturn(roominfo);

        mvc.perform(post("/accept/100")
                .contentType(MediaType.APPLICATION_JSON)
               .content("{\"room\":\"100\" , \"email\":\"admin@exmaple.com\", " +
                        "\"name\":\"Administrator\",\"phonenum\" :\"010-1234-5678\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("kim"));

        verify(adminService).addGuest(email, name, phonenum, people,roomnum);
    }

//    @Test
//    public void emptycheck() throws Exception {
//        mvc.perform(post("/accept/empty")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }


}