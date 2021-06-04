package com.HotelService.service;


import com.HotelService.entity.Admin;
import com.HotelService.repository.AdminRepository;
import com.HotelService.entity.Room;
import com.HotelService.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AdminService {

    private AdminRepository adminRepository;

    private RoomRepository roomRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository, RoomRepository roomRepository) {
        this.adminRepository = adminRepository;
        this.roomRepository = roomRepository;
    }

    public List<Admin> getGuest() {
        List<Admin> users = adminRepository.findAll();
        return users;
    }


//    public Admin addGuest(String RoomNum, String email, String name, String phone, Room room) {
//        //TODO : 여기서는 이제 필요 없을 듯
//
//        boolean flag =adminRepository.findByRoom(RoomNum).isPresent();
//
//        System.out.println(flag);
//
//        Admin admin = null;
//
//        if(flag == false) {
//            admin = Admin.builder()
//                    .room(RoomNum)
//                    .email(email)
//                    .name(name)
//                    .phonenum(phone)
//                    .roomInfo(room)
//                    .build();
//
//            adminRepository.save(admin);
//        }else{
//            return null;
//        }
//
//        return admin;
//    }


    public String delete(String roomNum) {
        Admin admin = adminRepository.findByRoom(roomNum).orElse(null);
        Long id = admin.getId();
        admin.setRoomInfo(null);

        adminRepository.deleteById(id);
        roomRepository.deleteByIdx(id);

        return "check out";
    }

    public Admin updateGuest(Long id, String email, String name, String phone) {

        Admin admin = adminRepository.findById(id).orElse(null);

        admin.setEmail(email);
        admin.setName(name);
        admin.setPhonenum(phone);

        return admin;
    }
}
