package com.HotelService.controller;


import com.HotelService.entity.Guest;
import com.HotelService.entity.Room;
import com.HotelService.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RequestController {

    @Autowired
    private RequestService requestService;

    // All request List Print
//    @GetMapping("/request")
//    public String requestList(Model model) {
//
//        model.addAttribute("guests", requestService.list());
//
//        return "request";
//
//    }

    // Cancel request
    @RequestMapping(value = "/cancel/{id}",  method = RequestMethod.DELETE)
    public void cancel(@PathVariable("id") Long id) {
        requestService.cancel(id);
    }


    @PostMapping("/request/{id}")
    public String CheckIn(@RequestBody String resource,
                          @PathVariable("id") Long id){
        //TODO : construct check in service
        // 1. 빈방 찾아 추가해주는 controller 추가
        // 2. 빈방 번호 service 에 넘겨 Builer 에 추가

        String roomnum = resource;
        requestService.checkIn(id, roomnum);

        return "request Complete";
    }

    @GetMapping("/request/{id}")
    public List<Room> EmptyRoom(){

        List<Room> room = requestService.Emptyroom();

        return room;
    }

}
