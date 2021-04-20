package com.HotelService.entity;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AdminTest {


    @Test
    public void creation(){
        Admin admin = Admin.builder()
                .name("kim")
                .build();

        assertThat(admin.getName(), is("kim"));
    }
}