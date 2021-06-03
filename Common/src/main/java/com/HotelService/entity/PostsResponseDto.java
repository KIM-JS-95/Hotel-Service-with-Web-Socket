package com.HotelService.entity;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Optional;

@Getter
public class PostsResponseDto {

    private Long id;
    private String email;
    private String name;
    private String phonenum;
    private LocalDate start;
    private LocalDate end;

    public PostsResponseDto(Guest guest) {
        this.id = guest.getId();
        this.email = guest.getEmail();
        this.name = guest.getName();
        this.phonenum = guest.getPhonenum();
        this.start = guest.getStart();
        this.end = guest.getEnd();
    }

}
