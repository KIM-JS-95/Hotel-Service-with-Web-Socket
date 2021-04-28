package com.HotelService.repository;

import com.HotelService.entity.Guest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GuestRepository extends CrudRepository<Guest, Long> {

    List<Guest> findAll();

    Optional<Guest> findById(Long id);

    void delete(Long id);
}
