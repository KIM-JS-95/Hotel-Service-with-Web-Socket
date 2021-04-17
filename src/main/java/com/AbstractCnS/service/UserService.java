package com.AbstractCnS.service;


import com.AbstractCnS.entity.Guest;
import com.AbstractCnS.repository.GuestRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> getUser(){
        List<Guest> users = guestRepository.findAll();
        return users;
    }

    public Guest addUser(String email, String name){
        Guest user = Guest.builder().email(email).name(name).build();

        return guestRepository.save(user);
    }

    public Guest authenticate(String email, String password) {
        Guest user = (Guest) guestRepository.findByEmail(email)
                .orElseThrow(null);


        return user;
    }

}
