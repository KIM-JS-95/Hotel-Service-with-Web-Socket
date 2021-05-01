package com.HotelService.service;


import com.HotelService.entity.Admin;
import com.HotelService.entity.Guest;
import com.HotelService.repository.AdminRepository;
import com.HotelService.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestService {

    private GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }


    public Guest CIrequest(String email, String name, String phonenum) {

        Guest guest = Guest.builder()
                .email(email)
                .name(name)
                .phonenum(phonenum)
                .build();

        return guestRepository.save(guest);
    }

    public Guest CIcancel(Long id) {

        guestRepository.deleteById(id);

        return null;
    }

}
