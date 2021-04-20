package com.HotelService.controller;


import com.HotelService.entity.Admin;
import com.HotelService.service.AdminService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/reservation")
    public List<Admin> list() {
        List<Admin> users = adminService.getGuest();

        return users;
    }

    @PostMapping("/reservation")
    public ResponseEntity<?> create(
            @RequestBody Admin resource) throws URISyntaxException {
        String RoomNum = resource.getRoom();
        String email = resource.getEmail();
        String name = resource.getName();
        String phone = resource.getPhone();

        Admin admin = adminService.addGuest(RoomNum, email, name, phone);

        String url = "/reservation/" + admin.getId();

        return ResponseEntity.created(new URI(url))
                .body("{}");
    }

    @DeleteMapping("/reservation/{RoomNum}")
    public String checkout(@PathVariable("RoomNum") String RoomNum) {

        adminService.delete(RoomNum);
        return "successfully check out";
    }

    @PatchMapping("/reservation/{id}")
    public Admin update(@RequestBody Admin resource,
                        @PathVariable("id") Long id) {

        String email = resource.getEmail();
        String name = resource.getName();
        String phone = resource.getPhone();

        return adminService.updateGuest(id, email, name, phone);
    }


}