package com.HotelService.controller;


import com.HotelService.Sse.SseEmitterController;
import com.HotelService.service.GuestService;
import com.HotelService.entity.Guest;
import com.HotelService.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Optional;

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
        LocalDate start = resource.getStart();
        LocalDate end = resource.getEnd();

        Guest guest = guestService.CIrequest(email, name, phonenum, start, end);
        sseEmitterController.handleSse();

        // String accessToken = jwtUtil.createToken(email, name, phonenum);

        String url = "/CheckIn/" + guest.getId();
        return ResponseEntity.created(new URI(url)).body("{}");
        // SessionResponseDTO.builder()
        //  .accessToken(accessToken)
        //  .build());
    }

    @GetMapping("/CheckInInquire/{email}/{name}")
    public Optional<Guest> CIinquire(@PathVariable String email,@PathVariable String name){
        Optional<Guest> guest = guestService.CIinquire(email,name);

        return guest;
    }


    @DeleteMapping("/CheckIn/{id}")
    public String cancel(@PathVariable("id") Long id) {

        guestService.CIcancel(id);
        return "delete";
    }

}