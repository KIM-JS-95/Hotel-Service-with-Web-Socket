package com.HotelService.controller;


import com.HotelService.entity.Admin;
import com.HotelService.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    // 손님 전체 리스트
    @GetMapping("/stay")
    public List<Admin> list() {
        List<Admin> users = adminService.getGuest();

        return users;
    }

//    @PostMapping("/stay")
//    public ResponseEntity<?> checkIn(
//            @RequestBody Admin resource) throws URISyntaxException {
//
//        String RoomNum = resource.getRoom();
//        String email = resource.getEmail();
//        String name = resource.getName();
//        String phone = resource.getPhonenum();
//        Room room = resource.getRoomInfo();
//
//        Admin admin = adminService.addGuest(RoomNum, email, name, phone, room);
//
//        if(admin == null){
//            return ResponseEntity.badRequest().body("exist");
//        }
//        else {
//            String url = "/stay/" + admin.getId();
//            return ResponseEntity.created(new URI(url))
//                    .body("{}");
//        }
//    }


    @DeleteMapping("/stay/{RoomNum}")
    public String checkOut(@PathVariable("RoomNum") String RoomNum) {

        adminService.delete(RoomNum);
        return "successfully check out";
    }

    @PutMapping("/stay/{id}")
    public Admin update(@RequestBody Admin resource,
                        @PathVariable("id") Long id) {

        String email = resource.getEmail();
        String name = resource.getName();
        String phone = resource.getPhonenum();

        Admin admin = adminService.updateGuest(id, email, name, phone);
        return admin;
    }


}