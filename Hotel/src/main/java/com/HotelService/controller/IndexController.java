//package com.HotelService.controller;
//
//
//import com.HotelService.entity.PostsResponseDto;
//import com.HotelService.service.AcceptService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@RequiredArgsConstructor
//@Controller
//public class IndexController {
//
//    @Autowired
//    private AcceptService acceptService;
//
//    // 메인화면
//    @GetMapping("/")
//    public String show(){
//        return "Welcome";
//    }
//
//    @GetMapping("/request/list")
//    public String request(Model model){
//        model.addAttribute("guests", acceptService.list());
//        return "request";
//    }
//
//    // 게스트 상세정보
//    @GetMapping("/request/list/{id}")
//    public String view(@PathVariable("id") Long id, Model model) {
//        PostsResponseDto guest = acceptService.view(id);
//
//        model.addAttribute("guest", guest);
//
//        return "view";
//    }
//
////    // 게스트 접수 및 추가 입력 화면
////    @GetMapping("/request/accept/{id}")
////    public String accept(){
////        return "accept";
////    }
//
//
//    @GetMapping("/request/status")
//    public String roomstatus(){
//        return "emptyroom";
//    }
//
//}
