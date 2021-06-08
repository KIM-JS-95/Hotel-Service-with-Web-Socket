package com.HotelService.repository;


import com.HotelService.entity.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface AdminRepository extends CrudRepository<Admin, Long> {

    List<Admin> findAll();

    void deleteById(Long id);
}
