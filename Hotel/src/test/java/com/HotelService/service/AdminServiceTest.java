package com.HotelService.service;

import com.HotelService.entity.Admin;
import com.HotelService.entity.Room;
import com.HotelService.repository.AdminRepository;
import com.HotelService.repository.RoomRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@RunWith(SpringRunner.class)
public class AdminServiceTest {

    @MockBean
    private AdminService adminService;

    @Mock
    private AdminRepository adminRepository;

    @Mock
    private RoomRepository roomRepository;

//    @Mock
//    private GuestRepository guestRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        adminService = new AdminService(roomRepository,adminRepository);
    }

    @Test
    public void getGuest() {
        List<Admin> adminList = new ArrayList<>();

        String email = "admin@exmaple.com";
        String name = "Administrator";
        String phonenum = "010-1234-5678";

        adminList.add(Admin.builder()
                .email(email)
                .name(name)
                .phonenum(phonenum)
                .build());

        given(adminRepository.findAll()).willReturn(adminList);

        List<Admin> admins = adminService.Guestlist();

        Admin admin = admins.get(0);

        assertThat(admin.getName(), is("Administrator"));
    }


    @Test
    public void update() {

        Long id = 100L;
        String RoomNum = "100";
        String email = "admin@exmaple.com";
        String name = "Administrator";
        String phonenum = "010-1234-5678";

        Admin mockadmin = Admin.builder().email(email).name(name).phonenum(phonenum).build();

        given(adminRepository.findById(id)).willReturn(Optional.of(mockadmin));

        Admin admin = adminService.updateGuest(id, email, name, phonenum);

        verify(adminRepository).findById(eq(id));

        assertThat(admin.getName(), is("Administrator"));
    }

    @Test
    public void delete() {

        String email = "admin@exmaple.com";
        String RoomNum = "101";
        String name = "Administrator";
        String phonenum = "010-1234-5678";

        Admin mockadmin = Admin.builder()
                .email(email)
                .name(name)
                .phonenum(phonenum)
                .people("10")
                .build();

        Room mockroom = Room.builder()
                .roomnum(RoomNum)
                .bedtype("twin")
                .st("empty")
                .admin(mockadmin)
                .build();

      //  given(adminRepository.save(mockadmin)).willReturn(mockadmin);

        // 고객과 방 정보를 저장
        given(roomRepository.save(mockroom)).willReturn(mockroom);


        given(roomRepository.findByRoomnum(RoomNum)).willReturn(mockroom);

        adminService.delete(RoomNum);

    }

}