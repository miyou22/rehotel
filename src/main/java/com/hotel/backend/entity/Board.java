package com.hotel.backend.entity;

import com.hotel.backend.constant.Role;
import com.hotel.backend.dto.BoardDto;
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

//    @ManyToOne
//    @JoinColumn(name = "userId")
//    private Member userId;

    @Column(nullable = false, name="board_category")
    private String boardCategory;

    @Column(nullable = false, length = 50, name = "board_title")
    private String boardTitle;

    @Column(name = "board_content")
    private String boardContent;

    @Column(name = "board_cnt")
    private int boardCnt;

    @Column(name="created_at")
    private LocalDateTime createdAt;
}
