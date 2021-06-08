//package com.HotelService.controller;
//
//import com.HotelService.entity.Admin;
//import com.HotelService.entity.Guest;
//import com.HotelService.entity.Room;
//import com.HotelService.service.AcceptService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.util.List;
//
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.assertThat;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.verify;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest(classes = {AcceptController.class})
//@RunWith(SpringRunner.class)
////@WebMvcTest(AcceptController.class)
//public class AcceptControllerTest {
//
//    @MockBean
//    private AcceptService acceptService;
//
//    //@Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    @Before
//    public void setup() {
//        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }
//
//    @Test
//    public void checkIn() throws Exception {
//        String RoomNum = "100";
//        String email = "baugh248730@gmail.com";
//        String name = "kim";
//        String phonenum = "010-1234-4556";
//
//        Room roomInfo = Room.builder()
//                .idx(1L)
//                .roomnum(RoomNum)
//                .bedtype("twin")
//                .people("10")
//                .build();
//
//        Admin mockadmin = Admin.builder().room(RoomNum).email(email).name(name).phonenum(phonenum).roomInfo(roomInfo).build();
//
//        given(acceptService.addGuest(RoomNum, email, name, phonenum, roomInfo)).willReturn(mockadmin);
//
//        mvc.perform(post("/accept")
//                .contentType(MediaType.APPLICATION_JSON)
//               .content("{\"room\":\"100\" , \"email\":\"admin@exmaple.com\", " +
//                        "\"name\":\"Administrator\",\"phonenum\" :\"010-1234-5678\"}"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("kim"));
//
//        verify(acceptService).addGuest(RoomNum, email, name, phonenum, roomInfo);
//    }
//
//    @Test
//    public void i1() throws Exception {
//        mvc.perform(post("/accept")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//
//}