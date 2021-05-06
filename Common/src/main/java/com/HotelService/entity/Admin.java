package com.HotelService.entity;


import com.HotelService.utils.BaseTimeEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(AuditingEntityListener.class)
public class Admin extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String room;

    @NotEmpty
    private String email;

    @NotEmpty
    private String name;

    @NotEmpty
    private String phonenum;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_idx")
    private Room roomInfo;
}
