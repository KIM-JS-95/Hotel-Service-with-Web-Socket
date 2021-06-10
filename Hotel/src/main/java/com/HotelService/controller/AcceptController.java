package com.HotelService.controller;


import com.HotelService.entity.Admin;
import com.HotelService.entity.Guest;
import com.HotelService.entity.Room;
import com.HotelService.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class AcceptController {

    @Autowired
    private AdminService adminService;

    // 체크인
    @RequestMapping("accept")
    @PostMapping(value = "{roomNum}")
    public String checkIn(@RequestBody Admin resource
                           ){

//        String email = resource.getEmail();
//        String name = resource.getName();
//        String phonenum = resource.getPhonenum();
//        String people = resource.getPeople();
//
//        Room room = adminService.addGuest(email, name, phonenum,people, roomNum);
//
//        Admin admin = Admin.builder()
//                .email(email)
//                .name(name)
//                .phonenum(phonenum)
//                .build();

        //String url = "/accept/" + roomNum;
            return "!";
        }

    // 빈방 리스트 조회
    @GetMapping("/accept/empty")
    public List<Room> EmptyRoom(){

        List<Room> room = adminService.Emptyroom();

        return room;
    }


   //  예약 취소
    @DeleteMapping("/accept/cancel/{id}")
    public Long cancel(@PathVariable("id") Long id) {
        adminService.cancel(id);
        return id;
    }

}
