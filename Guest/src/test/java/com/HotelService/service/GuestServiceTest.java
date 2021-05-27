package com.HotelService.service;

import com.HotelService.entity.Guest;
import com.HotelService.repository.GuestRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


public class GuestServiceTest {

    @MockBean
    private GuestService guestService;

    @Mock
    private GuestRepository guestRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        guestService = new GuestService(guestRepository);
    }

    @Test
    public void CIrequest() {

        String name = "kim";
        String email = "admin@email.com";
        String phonenum = "101-1111-1111";
        LocalDate start = LocalDate.of(2021,05, 20);
        LocalDate end = LocalDate.of(2021,05, 27);

        Guest mockguest = Guest.builder()
                .name(name)
                .email(email)
                .phonenum(phonenum)
                .build();

        given(guestRepository.save(any())).willReturn(mockguest);

        Guest guest = guestService.CIrequest(email,name,phonenum,start,end);

        assertThat(guest.getName(),is("kim"));
    }
}