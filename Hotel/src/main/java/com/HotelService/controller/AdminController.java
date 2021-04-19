package com.HotelService.controller;


import com.HotelService.entity.Guest;
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
    public List<Guest> list() {
        List<Guest> users = adminService.getGuest();

        return users;
    }

    @PostMapping("/reservation")
    public ResponseEntity<?> create(@RequestBody Guest resource) throws URISyntaxException {
        String RoomNum = resource.getRoomNum();
        String email = resource.getEmail();
        String name = resource.getName();
        Guest user= adminService.addGuest(RoomNum, email, name);

        String url = "/reservation/" + user.getId();
        return ResponseEntity.created(new URI(url))
                .body("{}");
    }

    @DeleteMapping("/reservation/{RoomNum}")
    public String checkout(@PathVariable("RoomNum") String RoomNum){

        adminService.delete(RoomNum);
        return "successfully check out";
    }

}
