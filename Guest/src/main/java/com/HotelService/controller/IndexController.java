package com.HotelService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/")
    public String hello() {
        return "index";
    }

    @GetMapping("/save")
    public String postsSave(){
        return "save";
    }

    @GetMapping("/inquiry")
    public String inquiry(){
        return "inquiry";
    }

    @GetMapping("/inquiry/result")
    public String inquiryResult(){
        return "inquiry-result";
    }

}
