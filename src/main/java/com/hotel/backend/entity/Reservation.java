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
    private  String resId;

//    @ManyToOne
//    @JoinColumn(name = "userId")
//    private Member userId;

    @ManyToOne
    @JoinColumn(name = "guestEmail")
    private Guest guestEmail;
    private String roomName;
    private String roomPrice;

    private String userName;
    private String userTel;
    private String userEmail;

    @Column(nullable = false)
    private LocalDateTime resCheckin;

    @Column(nullable = false)
    private LocalDateTime resCheckout;

    @Column(nullable = false)
    private int resPerson;
    private String resRequest;
    @Column(nullable = false)
    private LocalDateTime resDate;

    @Column(nullable = false, length = 1)
    private int facCheck;

    @Column(nullable = false, length = 1)
    private int payCheck;

//    @Column(nullable = false, length = 1)
//    private int userFlag;
}
