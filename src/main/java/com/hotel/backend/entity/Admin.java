package com.hotel.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="Admin")
@Getter
@Setter
@ToString
public class Admin {
    @Id
    @Column(nullable = false,length = 20)
    private String adminId;

    @Column(nullable = false,length = 20)
    private String adminPw;

    @Column(nullable = false,length = 50, unique = true)
    private String adminEmail;

    @Column(nullable = false)
    private int adminTel;

    @Column(nullable = false,length = 100)
    private String adminAddr;

    @Column(nullable = false,length = 20)
    private String adminName;

    @Column(nullable = false,length = 1)
    private String adminGender;

    @Column(nullable = false)
    private LocalDateTime adminBirth;

    @Column(nullable = false)
    private LocalDateTime adminJoin;


}
