package com.HotelService.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WellcomController {

    @GetMapping("/Hotelbanner")
    public String show(){
        return " *** 호텔에 오신걸 환영합니다.";
    }
}
