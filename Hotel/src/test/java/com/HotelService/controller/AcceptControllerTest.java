package com.HotelService.controller;

import com.HotelService.entity.Admin;
import com.HotelService.entity.Room;
import com.HotelService.service.AcceptService;
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

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AcceptController.class)
public class AcceptControllerTest {

    @MockBean
    private AcceptService acceptService;

    @Autowired
    private MockMvc mvc;

//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    @Before
//    public void setup() {
//        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }

//    @Test
//    public void list() throws Exception {
//        mvc.perform(get("/request"))
//                .andExpect(status().isOk());
//    }

//    @Test
//    public void cancel() throws Exception {
//        Long id = 1L;
//
//        mvc.perform(delete("/cancel/1"))
//                .andExpect(status().isOk());
//
//        verify(acceptService).cancel(id);
//    }

    @Test
    public void checkIn() throws Exception {
        String RoomNum = "101";
        String email = "admin@exmaple.com";
        String name = "Administrator";
        String phonenum = "010-1234-5678";

        Room roomInfo = Room.builder()
                .idx(1L)
                .roomnum(RoomNum)
                .bedtype("twin")
                .people("10")
                .build();

        Admin mockadmin = Admin.builder().room(RoomNum).email(email).name(name).phonenum(phonenum).roomInfo(roomInfo).build();

        given(acceptService.addGuest(RoomNum, email, name, phonenum, roomInfo)).willReturn(mockadmin);

        mvc.perform(post("/accept"))
//                .contentType(MediaType.APPLICATION_JSON)
//               .content("{\"room\":\"100\" , \"email\":\"admin@exmaple.com\", " +
//                        "\"name\":\"Administrator\",\"phonenum\" :\"010-1234-5678\"}"))
                .andExpect(status().isOk());

//        verify(acceptService).addGuest(RoomNum, email, name, phonenum, roomInfo);
    }

    @Test
    public void i1() throws Exception {
        mvc.perform(post("/accept")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}