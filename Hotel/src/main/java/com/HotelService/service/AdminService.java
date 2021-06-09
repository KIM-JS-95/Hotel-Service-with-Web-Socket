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

@Service
@Transactional
public class AdminService {

    private RoomRepository roomRepository;

    private AdminRepository adminRepository;

    private GuestRepository guestRepository;

    public AdminService(RoomRepository roomRepository,
                         AdminRepository adminRepository, GuestRepository guestRepository) {
        this.roomRepository = roomRepository;
        this.adminRepository = adminRepository;
        this.guestRepository =guestRepository;
    }


    public List<Admin> GuestList() {
        List<Admin> users = adminRepository.findAll();
        return users;
    }


    // 체크 아웃
    public String delete(String roomNum) {
        Room room = roomRepository.findByRoomnum(roomNum);
        Long id = room.getAdmin().getId();

        room.setSt("empty");

        adminRepository.deleteById(id);

        return "check out";
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
        public Room addGuest(String email, String name, String phonenum,String people, String roomnum) {

            //방 정보 가져와서
            Room roominfo = roomRepository.findByRoomnum(roomnum);

            Admin admin = Admin.builder()
                    .email(email)
                    .name(name)
                    .phonenum(phonenum)
                    .people(people)
                    .build();

            // Merge 해주고 저장
            Room room = Room.builder()
                    .roomnum(roominfo.getRoomnum())
                    .bedtype(roominfo.getBedtype())
                    .admin(admin)
                    .build();

            //  roomRepository.save(room);

            return room;

        }

        // 빈 방 조회
        public List<Room> Emptyroom(){

            List<Room> rooms = roomRepository.findByEmpty();

            return rooms;
        }
    }
