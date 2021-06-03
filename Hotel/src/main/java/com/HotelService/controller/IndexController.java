package com.HotelService.controller;


import com.HotelService.entity.Guest;
import com.HotelService.entity.PostsResponseDto;
import com.HotelService.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final RequestService requestService;

    @GetMapping("/")
    public String show(){
        return "Welcome";
    }

    @GetMapping("/request/detail")
    public String request(Model model){
        model.addAttribute("guests", requestService.list());
        return "request";
    }

    @GetMapping("/request/detail/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        PostsResponseDto guest = requestService.view(id);

        model.addAttribute("guest", guest);

        return "view";
    }

}
