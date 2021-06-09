//package com.HotelService.service;
//
//import com.HotelService.entity.Admin;
//import com.HotelService.entity.Guest;
//import com.HotelService.entity.Room;
//import com.HotelService.repository.AdminRepository;
//import com.HotelService.repository.GuestRepository;
//import com.HotelService.repository.RoomRepository;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.verify;
//
//public class AcceptServiceTest {
//
//    @MockBean
//    private AcceptService acceptService;
//
//    @Mock
//    private GuestRepository guestRepository;
//
//    @Mock
//    private RoomRepository roomRepository;
//
////    @Mock
////    private AdminRepository adminRepository;
//
//    // 필드 초기화
//    @Before
//    public void setUp(){
//        MockitoAnnotations.initMocks(this);
//        acceptService = new AcceptService(guestRepository , roomRepository);//, roomRepository);
//    }
//
//    @Test
//    public void addGuest() {
//        String roomnum = "101";
//        String email = "admin@exmaple.com";
//        String name = "Administrator";
//        String phonenum = "010-1234-5678";
//        String people = "10";
//
//        Room mockroom = Room.builder()
//                .roomnum("101")
//                .bedtype("twin")
//                .st("empty")
//                .build();
//
//        // 미리 방 정보를 저장
//        given(roomRepository.save(mockroom)).willReturn(mockroom);
//
//        Admin mockadmin = Admin.builder()
//                .email(email)
//                .name(name)
//                .phonenum(phonenum)
//                .people(people)
//                .build();
//
//        // guest 와 room 정보를 병합 저장
//        Room room = Room.builder()
//                .roomnum(mockroom.getRoomnum())
//                .bedtype(mockroom.getBedtype())
//                .st("full")
//                .admin(mockadmin)
//                .build();
//
//       given(roomRepository.save(room)).willReturn(room);
//
//       //verify(acceptService).addGuest(email, name, phonenum, people, roomnum);
//
//       // verify(adminRepository).save(mockadmin);
//
//    }
//
//    // 예약 거절
//    @Test
//    public void cancel(){
//
//        Long id = 100L;
//        String email = "admin@exmaple.com";
//        String name = "Administrator";
//        String phonenum = "010-1234-5678";
//
//        Guest mockadmin = Guest.builder()
//                .id(id)
//                .email(email)
//                .name(name)
//                .phonenum(phonenum)
//                .build();
//
//        // guest 정보 저장
//      //  given(guestRepository.save(mockadmin)).willReturn(mockadmin);
//
//        acceptService.cancel(100L);
//     //   verify(guestRepository).deleteById(any());
//      //  acceptService.cancel(id);
//
//    }
//}