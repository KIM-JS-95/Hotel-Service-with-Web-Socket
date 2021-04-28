package com.HotelService.repository;

import com.HotelService.entity.Admin;
import com.HotelService.entity.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends CrudRepository<Room, String> {

    List<Room> findAll();

    Optional<Admin> findByRoomnum(String roomnum);

    void deleteById(Long id);


    @qu
    List<Room> findByStaus();
}
