package com.hotel.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="notice")
@Getter
@Setter
@ToString
public class Notice {
    @Id
    @Column(nullable = false)
    private int notice_sn;

    @Column(nullable = false,length = 20)
    private String notice_tit;

    @Column(nullable = false)
    private String notice_sub;

    private int notice_cnt;

    @OneToOne
    @JoinColumn(name = "admin_id")
    private String admin_id;
}
