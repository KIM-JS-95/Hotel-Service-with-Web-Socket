package com.HotelService.controller;


import com.HotelService.entity.DTO.AcceptDTO;
import com.HotelService.entity.Admin;
import com.HotelService.entity.Room;
import com.HotelService.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AcceptController {

    @Autowired
    private AdminService adminService;


    //체크 인
    @PostMapping("/accept/{roomnum}")
    public Admin checkIn(@PathVariable String roomnum, @RequestBody AcceptDTO resource){

        String email = resource.getEmail();
        String name = resource.getName();
        String phonenum = resource.getPhonenum();
        String people = resource.getPeople();

        Admin admin = adminService.addGuest(email, name, phonenum,people, roomnum);


            return admin;
        }

    // 빈방 리스트 조회
    @GetMapping("/accept/empty")
    public List<Room> EmptyRoom(){

        List<Room> room = adminService.Emptyroom();

        return room;
    }


   //  예약 취소
    @DeleteMapping("/accept/cancel/{id}")
    public String cancel(@PathVariable("id") Long id) {
        adminService.cancel(id);
        return "예약이 취소되었습니다.";
    }

}
