package HotelService.controller;


import HotelService.service.GuestService;
import com.HotelService.entity.Admin;
import com.HotelService.entity.Guest;
import com.HotelService.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class GuestController {


    @Autowired
    private GuestService guestService;

    @PostMapping("/CheckIn")
    public ResponseEntity<?> checkIn(
            @RequestBody Admin resource) throws URISyntaxException {
        String RoomNum = resource.getRoom();
        String email = resource.getEmail();
        String name = resource.getName();
        String phone = resource.getPhone();
        Room room = resource.getRoomInfo();

        Guest guest = guestService.CIrequest(RoomNum, email, name, phone, room);

        String url = "/reservation/" + guest.getId();

        return ResponseEntity.created(new URI(url))
                .body("{}");
    }
}