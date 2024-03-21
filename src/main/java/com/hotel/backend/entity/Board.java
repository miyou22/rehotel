package com.hotel.backend.entity;

import com.hotel.backend.constant.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="board")
@Getter
@Setter
@ToString
public class Board {
    @OneToOne
    @JoinColumn(name = "adminId")
    private Admin adminId;

    // QNA
    @Id
    @Column(nullable = false)
    private int qnaSn;

    @Column(nullable = false,length = 50)
    private String qnaTit;

    @Column(nullable = false)
    private String qnaSub;

    private int qnaCnt;

    @OneToOne
    @JoinColumn(name = "userId")
    private Member userId;

    // NOTICE
    @Id
    @Column(nullable = false)
    private int noticeSn;

    @Column(nullable = false,length = 50)
    private String noticeTit;

    @Column(nullable = false)
    private String noticeSub;

    private int noticeCnt;

    // 카테고리
    @Column(nullable = false, length = 1)
    private int categori;

}
