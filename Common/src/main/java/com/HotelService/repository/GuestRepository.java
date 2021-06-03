package com.HotelService.repository;

import com.HotelService.entity.Guest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GuestRepository extends CrudRepository<Guest, Long> {

    List<Guest> findAll();

    void deleteById(Long id);

    Optional<Guest> findByNameAndEmail(String name, String email);
}
