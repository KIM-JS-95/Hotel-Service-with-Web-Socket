package com.HotelService.service;

import com.HotelService.entity.Admin;
import com.HotelService.entity.Room;
import com.HotelService.repository.AdminRepository;
import com.HotelService.repository.GuestRepository;
import com.HotelService.repository.RoomRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
//@MockBean(JpaMetamodelMappingContext.class)
public class AcceptServiceTest {

    @MockBean
    private AcceptService acceptService;

//    @Mock
//    private GuestRepository guestRepository;
//
//    @Mock
//    private RoomRepository roomRepository;

    @Mock
    private AdminRepository adminRepository;

//    @Before
//    public void setUp(){
//        MockitoAnnotations.initMocks(this);
//        acceptService = new AcceptService(guestRepository,roomRepository,adminRepository);
//    }

    @Test
    public void addGuest() {
        Long id = 100L;
        String RoomNum = "101";
        String email = "admin@exmaple.com";
        String name = "Administrator";
        String phonenum = "010-1234-5678";

        Room room = Room.builder()
                .idx(1L)
                .roomnum("101")
                .bedtype("twin")
                .people("10")
                .build();

        Admin mockadmin = Admin.builder()
                .id(id)
                .room(RoomNum)
                .email(email)
                .name(name)
                .phonenum(phonenum)
                .roomInfo(room)
                .build();

        given(adminRepository.save(mockadmin)).willReturn(mockadmin);

        Admin admin = acceptService.addGuest(RoomNum, email, name, phonenum, room);
        assertThat(admin.getName(), is("Administrator"));

    }
}