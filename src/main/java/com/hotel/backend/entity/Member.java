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
@Table(name="member")
@Getter
@Setter
@ToString
public class Member {

    @Id
    @Column(length = 20, nullable = false)
    private String user_id;

    @Column(length = 20, nullable = false)
    private String user_pwd;

    @Column(length = 50, nullable = false,unique = true)
    private String user_email;

    @Column(nullable = false)
    private int user_tel;

    @Column(length = 100, nullable = false)
    private String user_addr;

    @Column(nullable = false,length = 1)
    private String user_gender;

    @Column(nullable = false)
    private LocalDateTime user_birth;

    @Column(nullable = false)
    private LocalDateTime user_join;

    @Column(nullable = false,length = 1)
    private int  user_private;

    @Column(nullable = false,length = 1)
    private int  user_flag;
}
