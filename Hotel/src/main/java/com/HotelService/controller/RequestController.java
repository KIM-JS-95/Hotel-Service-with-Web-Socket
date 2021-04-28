package com.HotelService.controller;


import com.HotelService.entity.Guest;
import com.HotelService.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequestController {


    @Autowired
    private RequestService requestService;

    @GetMapping("/request")
    public List<Guest> requestlist() {
        requestService.list();
        return null;
    }

    @PostMapping
    public String CheckIn(){
        //TODO : construct check in service

        // requestService;
        return "Complete check in Guests";
    }

    @DeleteMapping("/request/{id}")
    public String cancel(
            @PathVariable("id") Long id) {

        requestService.cancel(id);

        return "Canceled a reservation";
    }



}
