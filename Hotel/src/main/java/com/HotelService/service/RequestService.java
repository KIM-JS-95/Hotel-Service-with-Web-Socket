package com.HotelService.service;


import com.HotelService.entity.Guest;
import com.HotelService.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> list() {
        List<Guest> guest = guestRepository.findAll();

        return guest;
    }

    public void cancel(Long id) {

        guestRepository.delete(id);
    }
}
