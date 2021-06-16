package com.HotelService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/guest")
public class IndexController {

    @GetMapping("/welcome")
    public String hello() {
        return "Welcome";
    }

    @GetMapping("/save")
    public String postsSave(){
        return "save";
    }

    @GetMapping("/inquiry")
    public String inquiry(){
        return "inquiry";
    }

//    @GetMapping("/inquiry/result")
//    public String inquiryResult(){
//        return "inquiry-result";
//    }

}
