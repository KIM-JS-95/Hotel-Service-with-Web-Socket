package HotelService.service;


import com.HotelService.entity.Admin;
import com.HotelService.entity.Guest;
import com.HotelService.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public Guest CIrequest(String email, String name, String phonenum) {

        Guest guest = Guest.builder()
                .email(email)
                .name(name)
                .phonenum(phonenum)
                .build();

        return guestRepository.save(guest);
    }

}
