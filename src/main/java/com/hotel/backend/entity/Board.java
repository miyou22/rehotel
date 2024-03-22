package com.hotel.backend.entity;

import com.hotel.backend.constant.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="board")
@Getter
@Setter
@ToString
public class Board {

    //관리자 id
    //사용자 or 관리자 여부s
    //게시판 카테고리
    //게시판 넘버 pk
    //글 제목
    //글 내용
    //조회수
    //작성일

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "board_sn", nullable = false)
    private Long boardSn;

//    @OneToOne
//    @JoinColumn(name = "adminId")
//    private Admin adminId;

    // 사용자인지 관리자인지 구별
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Member userId;


    @Column(nullable = false, name="board_category")
    private String boardCategory;

    @Column(nullable = false, length = 50, name = "board_title")
    private String boardTitle;

    @Column(nullable = false, name = "board_content")
    private String boardContent;

    @Column(name = "board_cnt")
    private int boardCnt;

    @Column(name="created_at")
    private LocalDateTime createdAt;

//    @Id
//    @SequenceGenerator(name="board_seq", sequenceName="BOARD_SEQ", allocationSize=1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="board_seq")
//    private String boardSn;
//
//    // QNA
//    @Id
//    @Column(nullable = false)
//    private int qnaSn;
//
//    @Column(nullable = false,length = 50)
//    private String qnaTit;
//
//    @Column(nullable = false)
//    private String qnaSub;
//
//    private int qnaCnt;
//
//    @OneToOne
//    @JoinColumn(name = "userId")
//    private Member userId;
//
//    // NOTICE
//    @Id
//    @Column(nullable = false)
//    private int noticeSn;
//
//    @Column(nullable = false,length = 50)
//    private String noticeTit;
//
//    @Column(nullable = false)
//    private String noticeSub;
//
//    private int noticeCnt;
//
//
//    // 카테고리
//    @Column(nullable = false, length = 1)
//    private int categori;

}
