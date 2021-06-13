package com.HotelService.service;


import com.HotelService.entity.Guest;
import com.HotelService.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class GuestService {

    private GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public Guest CIrequest(String email, String name, String phonenum, String people, LocalDate start, LocalDate end) {

        Guest guest = Guest.builder()
                .email(email)
                .name(name)
                .phonenum(phonenum)
                .people(people)
                .start(start)
                .end(end)
                .build();

        return guestRepository.save(guest);
    }

    public Guest CIinquire(String email, String name){
        Optional<Guest> guest = guestRepository.findByNameAndEmail(name, email);

        return guest.get();
    }

    public Guest CIcancel(Long id) {
        guestRepository.deleteById(id);
        return null;
    }


}
