package com.HotelService.Controller;


import com.HotelService.Service.SessionService;
import com.HotelService.entity.DTO.SessionRequestDTO;
import com.HotelService.entity.Guest;
import com.HotelService.entity.DTO.SessionResponseDTO;
import com.HotelService.entity.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class SessionController {

    //@Autowired
    private JwtUtil jwtUtil;

    @Autowired
    SessionService sessionService;

    @PostMapping("/session")
    public ResponseEntity<SessionResponseDTO> create(
            @RequestBody SessionRequestDTO resource
    ) throws URISyntaxException {

        String email = resource.getEmail();
        String password = resource.getPassword();

        Guest guest = sessionService.authenticate(email, password);

        String accessToken = jwtUtil.createToken(
                guest.getName(),
                guest.getEmail());

        String url = "/session";
        return ResponseEntity.created(new URI(url)).body(
                SessionResponseDTO.builder()
                        .accessToken(accessToken)
                        .build());
    }
}
