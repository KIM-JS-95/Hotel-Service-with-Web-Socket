package com.HotelService.repository;

import com.HotelService.entity.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends CrudRepository<Room, String> {

    List<Room> findAll();

    Optional<Room> findByRoomnum(String roomnum);

    void deleteById(Long id);


    List<Room> findByStausIsNull();
}
