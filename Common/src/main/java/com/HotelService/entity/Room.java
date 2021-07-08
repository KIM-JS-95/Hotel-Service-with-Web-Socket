package com.HotelService.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.time.LocalDate;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@EntityListeners(AuditingEntityListener.class)
public class Room {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    private String roomnum;

    private String bedtype;

    private String st;

//    @OneToOne
//    private Admin admin;
}
