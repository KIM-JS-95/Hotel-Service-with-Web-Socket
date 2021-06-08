package com.HotelService;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.HotelService"})
public class HotelApplication {
    public static void main(String[] args){
        SpringApplication.run(HotelApplication.class, args);
    }
}
