package com.HotelService;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.HotelService"})
public class GuestApplication {
    public static void main(String[] args){
        SpringApplication.run(GuestApplication.class, args);
    }
}
