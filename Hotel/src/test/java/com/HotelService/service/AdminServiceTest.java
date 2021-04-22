package com.HotelService.service;

import com.HotelService.entity.Admin;
import com.HotelService.entity.AdminRepository;
import com.HotelService.entity.Room;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


public class AdminServiceTest {

    @MockBean
    private AdminService adminService;

    @Mock
    private AdminRepository adminRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        adminService = new AdminService(adminRepository);
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
                .phone(phonenum)
                .build());

        given(adminRepository.findAll()).willReturn(adminList);

        List<Admin> admins = adminService.getGuest();

        Admin admin = admins.get(0);

        assertThat(admin.getName(), is("Administrator"));
    }

    @Test
    public void addGuest() {
        Long id = 100L;
        String RoomNum = "100";
        String email = "admin@exmaple.com";
        String name = "Administrator";
        String phonenum = "010-1234-5678";

        Room room = null;

        Admin mockadmin = Admin.builder().email(email).name(name).phone(phonenum).build();


        given(adminRepository.save(any())).willReturn(mockadmin);

        Admin admin = adminService.addGuest(RoomNum, email, name, phonenum, room);

        assertThat(admin.getName(), is("Administrator"));

    }

    @Test
    public void update() {
        List<Admin> adminList = new ArrayList<>();

        Long id = 100L;
        String RoomNum = "100";
        String email = "admin@exmaple.com";
        String name = "Administrator";
        String phonenum = "010-1234-5678";

        Admin mockadmin = Admin.builder().email(email).name(name).phone(phonenum).build();

        given(adminRepository.findById(id)).willReturn(Optional.of(mockadmin));

        Admin admin = adminService.updateGuest(id, email, name, phonenum);

        verify(adminRepository).findById(id);

        assertThat(admin.getName(), is("Administrator"));
    }

    @Test
    public void delete() {

        Long id = 100L;
        String email = "admin@exmaple.com";
        String RoomNum = "100";
        String name = "Administrator";
        String phonenum = "010-1234-5678";

        Admin mockadmin = Admin.builder().room(RoomNum).email(email).name(name).phone(phonenum).build();

        given(adminRepository.save(any())).willReturn(mockadmin);

        given(adminRepository.findByRoom(RoomNum)).willReturn(Optional.of(mockadmin));

        String admin = adminService.delete(RoomNum);

        assertThat(admin, is("check out"));
    }

}