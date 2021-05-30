package com.HotelService;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan(basePackages = {"com.HotelService"})
//@EnableJpaAuditing
public class HotelApplication {
    public static void main(String[] args){
        SpringApplication.run(HotelApplication.class, args);
    }
}
