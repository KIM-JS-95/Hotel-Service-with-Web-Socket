package com.HotelService.entity;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    @Id
    @GeneratedValue
    private Long id;

    private String fruits;

    private String price;
}
