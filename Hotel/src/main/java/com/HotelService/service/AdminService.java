package com.HotelService.service;


import com.HotelService.entity.Admin;
import com.HotelService.repository.AdminRepository;
import com.HotelService.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getGuest() {
        List<Admin> users = adminRepository.findAll();
        return users;
    }


    public Admin addGuest(String RoomNum, String email, String name, String phone, Room room) {
        //TODO : RoomNum overlap handling

        boolean flag =adminRepository.findByRoom(RoomNum).isPresent();

        System.out.println(flag);

        Admin admin = null;

        if(flag == false) {
            admin = Admin.builder()
                    .room(RoomNum)
                    .email(email)
                    .name(name)
                    .phonenum(phone)
                    .roomInfo(room)
                    .build();

            adminRepository.save(admin);
        }else{
            return null;
        }

        return admin;
    }


    public String delete(String roomNum) {
        Admin admin = adminRepository.findByRoom(roomNum).orElse(null);
        Long id = admin.getId();

        adminRepository.deleteById(id);

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
