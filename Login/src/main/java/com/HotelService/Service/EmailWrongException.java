package com.HotelService.Service;

public class EmailWrongException extends RuntimeException {
    public EmailWrongException(String email){
        super("Email is wrong : " + email);
    }
}
