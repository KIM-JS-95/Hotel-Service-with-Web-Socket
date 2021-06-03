package com.HotelService.controller;


import com.HotelService.entity.Guest;
import com.HotelService.entity.Room;
import com.HotelService.service.AcceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AcceptController {

    @Autowired
    private AcceptService acceptService;

     //All request List Print
    @GetMapping("/request")
    public List<Guest> list() {

        List<Guest> guests= acceptService.list();
        return guests;
    }


    @PostMapping("/request/{id}")
    public String CheckIn(@RequestBody String resource,
                          @PathVariable("id") Long id){

        // 1. 빈방 찾아 추가해주는 controller 추가
        // 2. 빈방 번호 service 에 넘겨 Builer 에 추가

        String roomnum = resource;
        acceptService.checkIn(id, roomnum);

        return "request Complete";
    }

    @GetMapping("/request/{id}")
    public List<Room> EmptyRoom(){

        List<Room> room = acceptService.Emptyroom();

        return room;
    }


    // Cancel request
    @DeleteMapping("/cancel/{id}")
    public Long cancel(@PathVariable("id") Long id) {
        acceptService.cancel(id);
        return id;
    }

}
