package com.HotelService.entity;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AdminTest {


    @Test
    public void creation(){

        Admin admin = Admin.builder()
                .room("202")
                .name("kim")
                .build();

        assertThat(admin.getRoom(), is("202"));
    }
}