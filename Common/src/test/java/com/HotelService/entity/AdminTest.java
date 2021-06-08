package com.HotelService.entity;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AdminTest {


    @Test
    public void creation(){

        Admin admin = Admin.builder()
                .email("gmail.com")
                .name("kim")
                .phonenum("010-1111-1234")
                .build();

        assertThat(admin.getName(), is("kim"));
    }
}