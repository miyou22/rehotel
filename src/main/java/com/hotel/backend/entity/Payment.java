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
    private int pay_num;

    @Column(nullable = false, length = 50)
    private String pay_type;

    @Column(nullable = false)
    private LocalDateTime pay_time;

    @OneToOne
    @JoinColumn(name = "res_id")
    private int res_id;
}
