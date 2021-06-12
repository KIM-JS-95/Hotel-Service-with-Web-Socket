package com.HotelService.service;

import com.HotelService.entity.Admin;
import com.HotelService.repository.AdminRepository;
import com.HotelService.entity.Room;
import com.HotelService.repository.GuestRepository;
import com.HotelService.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private RoomRepository roomRepository;

    private AdminRepository adminRepository;

    private GuestRepository guestRepository;

    public AdminService(RoomRepository roomRepository,
                        AdminRepository adminRepository, GuestRepository guestRepository) {
        this.roomRepository = roomRepository;
        this.adminRepository = adminRepository;
        this.guestRepository = guestRepository;
    }


    public List<Admin> GuestList() {
        List<Admin> users = adminRepository.findAll();
        return users;
    }


    // 체크 아웃
    public Room delete(Long id) {

        Admin admin = adminRepository.findById(id).orElse(null);

        String roomNum = admin.getRoom().getRoomnum();
        Room room = roomRepository.findByRoomnum(roomNum);
        room.setSt("empty");
        admin.setRoom(null);

        // 고객 삭제
        adminRepository.deleteById(id);

        return room;
    }

    // 인원 정보 변경
    public Admin updateGuest(Long id, String email, String name, String phone) {

        Admin admin = adminRepository.findById(id).orElse(null);

        admin.setEmail(email);
        admin.setName(name);
        admin.setPhonenum(phone);

        return admin;
    }
    ///////////////////////////////////////////////////////////////////////////////

    // 예약 거절
    public void cancel(Long id) {
        guestRepository.deleteById(id);
    }


    // 예약 접수
    public Admin addGuest(String email, String name, String phonenum, String people, String roomnum) {

        //방 정보 가져와서
        Room roominfo = roomRepository.findByRoomnum(roomnum);

        roominfo.setSt("full");

        // Merge 해주고 저장
//            Room room = Room.builder()
//                    .roomnum(roominfo.getRoomnum())
//                    .bedtype(roominfo.getBedtype())
//                    .build();

        Admin admin = Admin.builder()
                .email(email)
                .name(name)
                .phonenum(phonenum)
                .people(people)
                .room(roominfo)
                .build();

        adminRepository.save(admin);

        return admin;

    }


    // 방 정보 추가
    public Room roomadd(Room room) {

        roomRepository.save(room);

        return room;
    }

    // 빈 방 조회
    public List<Room> Emptyroom() {

        List<Room> rooms = roomRepository.findByEmpty();

        return rooms;
    }


    // 방 정보 수정
    public Room roomupdate(String roomnum, Room roompach) {

        Room room = roomRepository.findByRoomnum(roomnum);

        room.setBedtype(roompach.getBedtype());
        room.setBedtype(roompach.getBedtype());
        room.setBedtype(roompach.getSt());

        return room;
    }
}
