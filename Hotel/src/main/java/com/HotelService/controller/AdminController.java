package com.HotelService.controller;


import com.HotelService.entity.Admin;
import com.HotelService.entity.Room;
import com.HotelService.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;


    // 손님 전체 리스트
    @GetMapping("/stay")
    public List<Admin> list() {
        List<Admin> users = adminService.GuestList();

        return users;
    }

    @DeleteMapping("/stay/{roomnum}")
    public String checkOut(@PathVariable("roomnum") String RoomNum) {

        System.out.print(RoomNum);

        adminService.delete(RoomNum);
        return "successfully check out";
    }

    @PutMapping("/stay/{id}")
    public Admin update(@RequestBody Admin resource,
                        @PathVariable Long id) {

        String email = resource.getEmail();
        String name = resource.getName();
        String phone = resource.getPhonenum();

        Admin admin = adminService.updateGuest(id, email, name, phone);
        return admin;
    }



    // 방 정보 저장
    @PostMapping("/room")
    public Room roomadd(@RequestBody Room room){

        return adminService.roomadd(room);
    }

    // 방 정보 수정
    @PutMapping("/room/{roomnum}")
    public Room roomupdate(@PathVariable String roomnum, @RequestBody Room room){

        return adminService.roomupdate(roomnum, room);
    }




}