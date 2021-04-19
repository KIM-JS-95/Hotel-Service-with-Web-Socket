package com.HotelService.entity;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GuestTest {


    @Test
    public void creation(){
        Guest guest = Guest.builder()
                .name("kim")
                .build();

        assertThat(guest.getName(), is("kim"));
    }
}