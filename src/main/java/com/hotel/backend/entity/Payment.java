package com.hotel.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="payment")
@Getter
@Setter
@ToString
public class Payment {
    @Id
    @Column(nullable = false)
    private int payNum;

    @Column(nullable = false, length = 50)
    private String payType;

    @Column(nullable = false)
    private LocalDateTime payTime;

    @OneToOne
    @JoinColumn(name = "resId")
    private Reservation resId;
}
