package com.HotelService.controller;


import com.HotelService.service.GuestService;
import com.HotelService.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class GuestController {

    @Autowired
    private GuestService guestService;

    @PostMapping("/CheckIn")
    public ResponseEntity<?> checkIn(
            @RequestBody Guest resource) throws URISyntaxException {

        String email = resource.getEmail();
        String name = resource.getName();
        String phonenum = resource.getPhonenum();

        Guest guest = guestService.CIrequest(email, name, phonenum);

        String url = "/CheckIn/" + guest.getId();

        return ResponseEntity.created(new URI(url))
                .body("{}");
    }
}