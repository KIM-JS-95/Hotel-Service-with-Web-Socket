//package com.HotelService.service;
//
//import com.HotelService.entity.Admin;
//import com.HotelService.entity.Room;
//import com.HotelService.repository.AdminRepository;
//import com.HotelService.repository.GuestRepository;
//import com.HotelService.repository.RoomRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
//@Service
//public class AcceptService {
//
//    private GuestRepository guestRepository;
//
//    private RoomRepository roomRepository;
//
//    private AdminRepository adminRepository;
//
//    @Autowired
//    public AcceptService(AdminRepository adminRepository, GuestRepository guestRepository, RoomRepository roomRepository) {
//        this.guestRepository= guestRepository;
//        this.adminRepository=adminRepository;
//        this.roomRepository=roomRepository;
//    }
//
//
//    public List<Admin> list() {
//        List<Admin> admins = adminRepository.findAll();
//
//        return admins;
//    }
//
////    public PostsResponseDto view(Long id) {
////        Guest guest = guestRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));
////
////        return new PostsResponseDto(guest);
////    }
//
//
//    public void cancel(Long id) {
////        Guest guest = guestRepository.findById(id)
////                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));
//        guestRepository.deleteById(id);
//    }
//
//
//    public Room addGuest(String email, String name,
//                         String phonenum,String people, String roomnum) {
//
//        //방 정보 가져와서
//        Room roominfo = roomRepository.findByRoomnum(roomnum);
//
//        Admin admin = Admin.builder()
//                .email(email)
//                .name(name)
//                .phonenum(phonenum)
//                .people(people)
//                .build();
//
//        // Merge 해주고 저장
//        Room room = Room.builder()
//                .roomnum(roominfo.getRoomnum())
//                .bedtype(roominfo.getBedtype())
//                .admin(admin)
//                .build();
//
//      //  roomRepository.save(room);
//
//        return room;
//
//    }
//
//    public List<Room> Emptyroom(){
//
//        List<Room> rooms = roomRepository.findByEmpty();
//
//        return rooms;
//    }
//}
