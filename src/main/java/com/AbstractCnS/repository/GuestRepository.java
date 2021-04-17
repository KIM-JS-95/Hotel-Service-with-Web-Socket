package com.AbstractCnS.repository;

import com.AbstractCnS.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GuestRepository extends CrudRepository<Guest, Long> {
    List<Guest> findAll();

    Optional<Guest> findByEmail(String email);
}
