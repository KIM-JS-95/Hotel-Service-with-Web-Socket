package com.HotelService.controller;


import com.HotelService.entity.Admin;
import com.HotelService.entity.Guest;
import com.HotelService.entity.Room;
import com.HotelService.service.AcceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class AcceptController {

    @Autowired
    private AcceptService acceptService;

     //All request List Print
//    @GetMapping("/request1")
//    public List<Guest> list() {
//
//        List<Guest> guests= acceptService.list();
//        return guests;
//    }


//    @PostMapping("/accept/{id}")
//    public String CheckIn(@RequestBody String resource,
//                          @PathVariable("id") Long id){
//
//        // 1. 빈방 찾아 추가해주는 controller 추가
//        // 2. 빈방 번호 service 에 넘겨 Builer 에 추가
//
//        String roomnum = resource;
//        acceptService.checkIn(id, roomnum);
//
//        return "request Complete";
//    }

    @PostMapping("/accept")
    public ResponseEntity<?> checkIn(
            @RequestBody Admin resource) throws URISyntaxException {

//        String RoomNum = resource.getRoom();
//        String email = resource.getEmail();
//        String name = resource.getName();
//        String phonenum = resource.getPhonenum();
//        Room room = resource.getRoomInfo();
//
//        Admin admin = acceptService.addGuest(RoomNum, email, name, phonenum, room);


//        // 요부분 필요 없을것 같은데..
//        if(admin == null){
//            return ResponseEntity.badRequest().body("exist");
//        }
//        else {
//           String url = "/stay/" + admin.getId();
//            return ResponseEntity.created(new URI(url))
//                    .body("{}");
        return null;
        }

    @GetMapping("/accept/empty")
    public List<Room> EmptyRoom(){

        List<Room> room = acceptService.Emptyroom();

        return room;
    }


    // Cancel request
    @DeleteMapping("/accept/cancel/{id}")
    public Long cancel(@PathVariable("id") Long id) {
        acceptService.cancel(id);
        return id;
    }

}
