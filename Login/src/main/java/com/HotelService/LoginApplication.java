package com.HotelService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.HotelService"})
public class LoginApplication {

    public static void main(String[] args){
        SpringApplication.run(LoginApplication.class, args);
    }
}
