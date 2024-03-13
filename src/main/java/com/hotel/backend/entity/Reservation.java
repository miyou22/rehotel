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
    private  int resId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Member userId;

    @ManyToOne
    @JoinColumn(name = "roomNum")
    private Room roomNum;

    @ManyToOne
    @JoinColumn(name = "guestEmail")
    private Guest guestEmail;

    @OneToOne
    @JoinColumn(name = "facType")
    private Facility facType;

    @Column(nullable = false)
    private LocalDateTime resCheckin;

    @Column(nullable = false)
    private LocalDateTime resCheckout;

    @Column(nullable = false)
    private int resPerson;

    @Column(nullable = false)
    private LocalDateTime resDate;

    @Column(nullable = false, length = 1)
    private int facCheck;

    @Column(nullable = false, length = 1)
    private int payCheck;

    @Column(nullable = false, length = 1)
    private int userFlag;
}
