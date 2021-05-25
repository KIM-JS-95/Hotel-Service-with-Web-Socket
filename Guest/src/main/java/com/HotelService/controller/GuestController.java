package com.HotelService.controller;


import com.HotelService.Sse.SessionResponseDTO;
import com.HotelService.Sse.SseEmitterController;
import com.HotelService.service.GuestService;
import com.HotelService.entity.Guest;
import com.HotelService.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RequiredArgsConstructor
@RestController
public class GuestController {

    @Autowired
    private GuestService guestService;

    @Autowired
    private SseEmitterController sseEmitterController;

    private JwtUtil jwtUtil;


    @PostMapping("/CheckIn")
    public ResponseEntity<?> reservation(
           @Valid @RequestBody Guest resource) throws URISyntaxException {

        String email = resource.getEmail();
        String name = resource.getName();
        String phonenum = resource.getPhonenum();

        Guest guest = guestService.CIrequest(email, name, phonenum);
        sseEmitterController.handleSse();

       // String accessToken = jwtUtil.createToken(email, name, phonenum);

        String url = "/CheckIn/" + guest.getId();
        return ResponseEntity.created(new URI(url)).body("{}");
               // SessionResponseDTO.builder()
                      //  .accessToken(accessToken)
                      //  .build());
    }

    @DeleteMapping("/CheckIn/{id}")
    public String cancel(@PathVariable("id") Long id){

        guestService.CIcancel(id);
        return "delete";
    }

}