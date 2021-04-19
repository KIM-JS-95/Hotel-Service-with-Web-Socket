package com.HotelService.service;



import com.HotelService.entity.Guest;
import com.HotelService.entity.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> getGuest(){
        List<Guest> users = guestRepository.findAll();
        return users;
    }

    public Guest addGuest(String RoomNum, String email, String name){
        Guest user = Guest.builder().RoomNum(RoomNum).email(email).name(name).build();

        return guestRepository.save(user);
    }


    public void delete(String roomNum) {
        Guest guest = guestRepository.findByRoomNum(roomNum).orElse(null);

        Long id = guest.getId();

        guestRepository.delete(id);
    }
}
