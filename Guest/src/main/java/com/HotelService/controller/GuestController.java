package com.HotelService.controller;


import com.HotelService.Sse.SseEmitterController;
import com.HotelService.service.GuestService;
import com.HotelService.entity.Guest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@RestController
public class GuestController {

    @Autowired
    private GuestService guestService;

    @Autowired
    private SseEmitterController sseEmitterController;

    @PostMapping("/CheckIn")
    public ResponseEntity<?> reservation(
           @Valid @RequestBody Guest resource) throws URISyntaxException {

        String email = resource.getEmail();
        String name = resource.getName();
        String phonenum = resource.getPhonenum();

        Guest guest = guestService.CIrequest(email, name, phonenum);

        sseEmitterController.handleSse();

        String url = "/CheckIn/" + guest.getId();

        return ResponseEntity.created(new URI(url))
                .body("{}");
    }

    @DeleteMapping("/CheckIn/{id}")
    public String cancel(@PathVariable("id") Long id){

        guestService.CIcancel(id);
        return "delete";
    }

}