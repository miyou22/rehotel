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
    private String admin_id;

    @Column(nullable = false,length = 20)
    private String admin_pw;

    @Column(nullable = false,length = 20, unique = true)
    private String admin_email;

    @Column(nullable = false)
    private int admin_tel;

    @Column(nullable = false,length = 50)
    private String admin_addr;

    @Column(nullable = false,length = 20)
    private String admin_name;

    @Column(nullable = false,length = 1)
    private String admin_gender;

    @Column(nullable = false)
    private LocalDateTime admin_birth;

    @Column(nullable = false)
    private LocalDateTime admin_join;


}
