package com.HotelService.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Admin {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String room;

    @NotEmpty
    private String email;

    @NotEmpty
    private String name;

    @NotEmpty
    private String phonenum;

//    @CreatedDate
//    private LocalDateTime checkinTime;
//
//    @CreatedDate
//    private LocalDateTime checkoutTIme;

//    @OneToOne
//   // @JoinColumn(name = "room_id")
//    private Room roomInfo;
}
