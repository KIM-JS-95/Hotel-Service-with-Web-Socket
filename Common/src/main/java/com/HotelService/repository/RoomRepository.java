package com.HotelService.repository;

import com.HotelService.entity.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    List<Room> findAll();

    void deleteByIdx(Long id);

    @Query(value ="SELECT * FROM ROOM WHERE ST = 'empty'", nativeQuery = true)
    List<Room> findByEmpty();

    Room findByRoomnum(String roomnum);
}
