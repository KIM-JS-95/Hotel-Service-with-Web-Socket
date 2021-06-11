package com.HotelService.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;



@Getter
@NoArgsConstructor
public class AcceptDTO {

    private String email;

    private String name;

    private String phonenum;

    private String people;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate start;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;
}
