//TODO: Guest 엔티티 정상 구동 먼저 확인
package com.HotelService.controller;


import com.HotelService.entity.Guest;
import com.HotelService.entity.Room;
import com.HotelService.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequestController {


    @Autowired
    private RequestService requestService;


    // All request List Print
    @GetMapping("/request")
    public List<Guest> requestList() {
        return requestService.list();

    }

    // Cancel request
    @DeleteMapping("/request/{id}")
    public String cancel(
            @PathVariable("id") Long id) {

        requestService.cancel(id);

        return "Canceled a reservation";
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
