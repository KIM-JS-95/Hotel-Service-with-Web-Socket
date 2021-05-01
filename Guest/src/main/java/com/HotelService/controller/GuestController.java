package com.HotelService.controller;


import com.HotelService.service.GuestService;
import com.HotelService.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class GuestController {

    @Autowired
    private GuestService guestService;

    @PostMapping("/CheckIn")
    public ResponseEntity<?> reservation(
           @Valid @RequestBody Guest resource) throws URISyntaxException {

        String email = resource.getEmail();
        String name = resource.getName();
        String phonenum = resource.getPhonenum();

        Guest guest = guestService.CIrequest(email, name, phonenum);

        String url = "/CheckIn/" + guest.getId();

        return ResponseEntity.created(new URI(url))
                .body("{}");
    }

    @DeleteMapping("/CheckIn/{id}")
    public String cancel(@PathVariable("id") Long id){

        guestService.CIcancel(id);
        return "delete";
    }


}