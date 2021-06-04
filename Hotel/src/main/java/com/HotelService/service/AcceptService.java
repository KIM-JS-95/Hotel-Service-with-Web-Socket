package com.HotelService.service;

import com.HotelService.entity.Admin;
import com.HotelService.entity.Guest;
import com.HotelService.entity.PostsResponseDto;
import com.HotelService.entity.Room;
import com.HotelService.repository.AdminRepository;
import com.HotelService.repository.GuestRepository;
import com.HotelService.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AcceptService {

    private GuestRepository guestRepository;

    private RoomRepository roomRepository;

    private AdminRepository adminRepository;

    @Autowired
    public AcceptService(GuestRepository guestRepository, RoomRepository roomRepository,
                         AdminRepository adminRepository) {
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
        this.adminRepository=adminRepository;
    }


    @Transactional(readOnly = true)
    public List<Guest> list() {
        List<Guest> guest = guestRepository.findAll();

        return guest;
    }

    //@Transactional(readOnly = true)
    public PostsResponseDto view(Long id) {
        Guest guest = guestRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));

        return new PostsResponseDto(guest);
    }


    @Transactional
    public void cancel(Long id) {
        Guest guest = guestRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));
        guestRepository.delete(guest);
    }

    // 이제 필요 없을듯
  //  @Transactional
//    public Admin checkIn(Long id, String roomnum) {
//
//        // TODO : 비어있는 room 찾아서 추가해주기
//        Guest guest = guestRepository.findById(id).orElse(null);
//
//        Admin admin = Admin.builder()
//                .email(guest.getEmail())
//                .name(guest.getName())
//                .phonenum(guest.getPhonenum())
//                .room(roomnum)
//                .build();
//        return admin;
//    }

    public Admin addGuest(String RoomNum, String email, String name, String phone, Room room) {

        // boolean flag = roomRepository.findByRoomnum(RoomNum).isPresent();

        Admin admin = Admin.builder()
                .room(RoomNum)
                .email(email)
                .name(name)
                .phonenum(phone)
                .roomInfo(room)
                .build();

        adminRepository.save(admin);

        return admin;

        // 방이 비어있다면
//        if(flag == false) {
//          Admin  admin = Admin.builder()
//                    .room(RoomNum)
//                    .email(email)
//                    .name(name)
//                    .phonenum(phone)
//                    .roomInfo(room)
//                    .build();
//
//            adminRepository.save(admin);
//            return admin;
//        }else{
//            return null;
//        }
    }

    @Transactional
    public List<Room> Emptyroom(){

        List<Room> rooms = roomRepository.findByEmpty();

        return rooms;
    }
}
