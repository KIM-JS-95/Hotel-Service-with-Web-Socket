package com.HotelService.service;


import com.HotelService.entity.Admin;
import com.HotelService.entity.Guest;
import com.HotelService.entity.Room;
import com.HotelService.repository.GuestRepository;
import com.HotelService.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    private GuestRepository guestRepository;
    private RoomRepository roomRepository;


    public List<Guest> list() {
        List<Guest> guest = guestRepository.findAll();

        return guest;
    }

    public void cancel(Long id) {

        guestRepository.deleteById(id);
    }

    public void checkIn(Long id, String roomnum){

        // TODO : 비어있는 room 찾아서 추가해주기
        Guest guest = guestRepository.findById(id).orElse(null);

        Admin admin = Admin.builder()
                .email(guest.getEmail())
                .name(guest.getName())
                .phonenum(guest.getPhonenum())
                .room(roomnum)
                .build();

    }

    public List<Room> Emptyroom(){

        List<Room> rooms = roomRepository.findByStIsNull();

        return rooms;
    }
}
