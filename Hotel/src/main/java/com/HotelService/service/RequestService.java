package com.HotelService.service;


import com.HotelService.entity.Admin;
import com.HotelService.entity.Guest;
import com.HotelService.entity.PostsResponseDto;
import com.HotelService.entity.Room;
import com.HotelService.repository.GuestRepository;
import com.HotelService.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RequestService {


    private final GuestRepository guestRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Transactional(readOnly = true)
    public List<Guest> list() {
        List<Guest> guest = guestRepository.findAll();

        return guest;
    }

    @Transactional(readOnly = true)
    public PostsResponseDto view(Long id) {
        Guest guest = guestRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));

        return new PostsResponseDto(guest);
    }


    @Transactional
    public void cancel(Long id) {
        Guest guest = guestRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));
        guestRepository.delete(guest);
    }

    @Transactional
    public Admin checkIn(Long id, String roomnum) {

        // TODO : 비어있는 room 찾아서 추가해주기
        Guest guest = guestRepository.findById(id).orElse(null);

        Admin admin = Admin.builder()
                .email(guest.getEmail())
                .name(guest.getName())
                .phonenum(guest.getPhonenum())
                .room(roomnum)
                .build();
        return admin;
    }

    @Transactional
    public List<Room> Emptyroom(){

        List<Room> rooms = roomRepository.findByStIsNull();

        return rooms;
    }
}
