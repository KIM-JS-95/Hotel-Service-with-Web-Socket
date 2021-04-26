package com.HotelService.repository;

import com.HotelService.entity.Guest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GuestRepository extends CrudRepository<Guest, Long> {

    List<Guest> findAll();

    void delete(Long id);
}
