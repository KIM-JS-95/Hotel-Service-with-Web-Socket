package com.HotelService.entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{guest.email.notnull}")
    private String email;

    private String name;

    private String phonenum;

 //   @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String start;

  //  @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String end;


}
