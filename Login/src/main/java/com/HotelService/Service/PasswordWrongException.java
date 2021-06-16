package com.HotelService.Service;

public class PasswordWrongException extends RuntimeException {
    public PasswordWrongException(String pwd) {
        super("Name is wrong : " + pwd);
    }

}
