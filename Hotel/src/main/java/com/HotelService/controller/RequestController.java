package com.HotelService.controller;


import com.HotelService.entity.Guest;
import com.HotelService.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RequestController {


    @Autowired
    private RequestService requestService;

    @GetMapping("/request")
    public List<Guest> request() {
        requestService.list();
        return null;
    }

    @DeleteMapping("/request/{id}")
    public String cancel(
            @PathVariable("id") Long id) {

        requestService.cancel(id);

        return "Canceled a reservation";
    }



}
