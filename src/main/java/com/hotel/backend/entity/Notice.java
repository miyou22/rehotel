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
    private int noticeSn;

    @Column(nullable = false,length = 50)
    private String noticeTit;

    @Column(nullable = false)
    private String noticeSub;

    private int noticeCnt;

    @OneToOne
    @JoinColumn(name = "adminId")
    private Admin adminId;
}
