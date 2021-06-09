//package com.HotelService.service;
//
//import com.HotelService.entity.Admin;
//import com.HotelService.entity.Room;
//import com.HotelService.repository.AdminRepository;
//import com.HotelService.repository.GuestRepository;
//import com.HotelService.repository.RoomRepository;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//
//@Service
//@Transactional
//public class AcceptService {
//
//    private GuestRepository guestRepository;
//
//    private RoomRepository roomRepository;
//
//  //  private AdminRepository adminRepository;
//
//    @Autowired
//    public AcceptService(GuestRepository guestRepository, RoomRepository roomRepository){//,AdminRepository adminRepository, RoomRepository roomRepository) {
//        this.guestRepository= guestRepository;
//        this.roomRepository=roomRepository;
//    }
//
//    // 예약 거절
//    public void cancel(Long id) {
//        guestRepository.deleteById(id);
//    }
//
//
//    // 예약 접수
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
//    // 빈 방 조회
//    public List<Room> Emptyroom(){
//
//        List<Room> rooms = roomRepository.findByEmpty();
//
//        return rooms;
//    }
//}
