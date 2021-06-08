package com.HotelService.controller;


import com.HotelService.entity.Admin;
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

    @GetMapping("/request")
    public List<Admin> list() {

        return acceptService.list();
    }

    @PostMapping("/accept/{Roomnum}")
    public Room checkIn(
            @RequestBody Admin resource, @PathVariable("Roomnum") String roomnum) throws URISyntaxException {

        String email = resource.getEmail();
        String name = resource.getName();
        String phonenum = resource.getPhonenum();
        String people = resource.getPeople();;


        Room room = acceptService.addGuest(email, name, phonenum,people, roomnum);

//        Admin admin = Admin.builder()
//                .room(RoomNum)
//                .email(email)
//                .name(name)
//                .phonenum(phonenum)
//                .roomInfo(room)
//                .build();

        // 요부분 필요 없을것 같은데..
//        if (admin == null) {
//            return ResponseEntity.badRequest().body("exist");
//        } else {
//            String url = "/stay/" + admin.getId();
//            return ResponseEntity.created(new URI(url))
//                    .body("{}");


            return room;
        }


    // 빈방 리스트 조회
    @GetMapping("/accept/empty")
    public List<Room> EmptyRoom(){

        List<Room> room = acceptService.Emptyroom();

        return room;
    }


    // 예약 취소
    @DeleteMapping("/accept/cancel/{id}")
    public Long cancel(@PathVariable("id") Long id) {
        acceptService.cancel(id);
        return id;
    }

}
