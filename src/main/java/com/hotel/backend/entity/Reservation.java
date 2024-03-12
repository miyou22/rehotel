package com.hotel.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="reservation")
@Getter
@Setter
@ToString
public class Reservation {
    @Id
    @Column(nullable = false)
    private  int res_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private String user_id;

    @ManyToOne
    @JoinColumn(name = "room_num")
    private int room_num;

    @ManyToOne
    @JoinColumn(name = "guest_tel")
    private int guest_tel;

    @OneToOne
    @JoinColumn(name = "fac_type")
    private String fac_type;

    @Column(nullable = false)
    private LocalDateTime res_checkin;

    @Column(nullable = false)
    private LocalDateTime res_checkout;

    @Column(nullable = false)
    private int res_person;

    @Column(nullable = false)
    private LocalDateTime res_date;

    @Column(nullable = false, length = 1)
    private int fac_check;

    @Column(nullable = false, length = 1)
    private int pay_check;

    @Column(nullable = false, length = 1)
    private int user_flag;
}
