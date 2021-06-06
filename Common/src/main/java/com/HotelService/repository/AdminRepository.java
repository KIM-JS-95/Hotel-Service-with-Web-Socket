package com.HotelService.repository;


import com.HotelService.entity.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface AdminRepository extends CrudRepository<Admin, Long> {

    List<Admin> findAll();

    Optional<Admin> findByRoom(String room);

    void deleteById(Long id);
}
