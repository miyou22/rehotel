package com.hotel.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="guest")
@Getter
@Setter
@ToString
public class Guest {
    @Column(nullable = false,length = 50)
    private String guest_name;

    @Id
    @Column(nullable = false)
    private int guest_tel;

    @Column(nullable = false, length = 50)
    private String guest_email;

    @OneToMany
    @JoinColumn(name = "res_id")
    private int res_id;

    @Column(nullable = false,length = 1)
    private int user_flag;
}
