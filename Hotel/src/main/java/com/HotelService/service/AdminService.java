package com.HotelService.service;

import com.HotelService.entity.Admin;
import com.HotelService.repository.AdminRepository;
import com.HotelService.entity.Room;
import com.HotelService.repository.GuestRepository;
import com.HotelService.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AdminService {

    private RoomRepository roomRepository;

    private AdminRepository adminRepository;

    @Autowired
    public AdminService(RoomRepository roomRepository,
                         AdminRepository adminRepository) {
        this.roomRepository = roomRepository;
        this.adminRepository = adminRepository;
    }

    public List<Admin> Guestlist() {
        List<Admin> users = adminRepository.findAll();
        return users;
    }

    public String delete(String roomNum) {
        Room room = roomRepository.findByRoomnum(roomNum);
        Long id = room.getAdmin().getId();

        room.setSt("empty");

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
