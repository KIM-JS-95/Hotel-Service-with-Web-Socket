package com.AbstractCnS.controller;


import com.AbstractCnS.entity.Guest;
import com.AbstractCnS.entity.response.SessionResponseDto;
import com.AbstractCnS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @GetMapping("/reservation")
    public List<Guest> list() {
        List<Guest> users = userService.getUser();

        return users;
    }

    @PostMapping("/reservation")
    public ResponseEntity<?> create(@RequestBody Guest resource) throws URISyntaxException {
        String email = resource.getEmail();
        String name = resource.getName();
        Guest user= userService.addUser(email, name);


        String accessToken = jwtUtil.createToken(
                user.getId(),
                user.getName(),
                null);

        String url = "/reservation";
        return ResponseEntity.created(new URI(url)).body(SessionResponseDto.builder()
                .accessToken(accessToken)
                .build());
    }
}
