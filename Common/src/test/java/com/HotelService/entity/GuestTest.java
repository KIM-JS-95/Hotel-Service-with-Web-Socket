package com.HotelService.entity;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GuestTest {


    @Test
    public void create() {

        String name = "kim";
        String email = "admin@email.com";
        String phonenum = "101-1111-1111";

        Guest guest = Guest.builder()
                .name(name)
                .email(email)
                .phonenum(phonenum)
                .build();

        assertThat(guest.getName(), is("kim"));

    }
}