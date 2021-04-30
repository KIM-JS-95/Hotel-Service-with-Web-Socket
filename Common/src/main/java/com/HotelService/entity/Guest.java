package com.HotelService.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Guest {

    @Id
    @GeneratedValue
    @Column(name = "room_id")
    private Long id;

    private String email;

    private String name;

    private String phonenum;


}
