package com.HotelService.repository;

import com.HotelService.entity.Room;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface RoomRepository extends CrudRepository<Room, Long> {

    List<Room> findAll();

    //Optional<Room> findByRoomnum(String roomnum);

    @Transactional
    void deleteByIdx(Long id);

    List<Room> findByStIsNull();
}
