package com.HotelService.entity;


import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GuestRepository extends CrudRepository<Guest, Long> {
    List<Guest> findAll();


    Optional<Guest> findByRoomNum(String roomNum);

    void delete(Long id);
}
