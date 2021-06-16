package com.HotelService.Service;


import com.HotelService.entity.Guest;
import com.HotelService.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    GuestRepository guestRepository;
    PasswordEncoder passwordEncoder;

//    @Autowired
//    public SessionService(GuestRepository guestRepository,
//                       PasswordEncoder passwordEncoder) {
//        this.guestRepository = guestRepository;
//        this.passwordEncoder = passwordEncoder;
//    }

    public Guest authenticate(String email, String password) {
        Guest user = guestRepository.findByEmail(email)
                .orElseThrow(() -> new EmailWrongException(email));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new PasswordWrongException(password);
        }

        return user;
    }

}
