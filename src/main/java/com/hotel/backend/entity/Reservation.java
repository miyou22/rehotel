package com.hotel.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="reservation")
@Getter
@Setter
@ToString
public class Reservation {
    // 예약 ID
    @Id
    @Column(nullable = false)
    private  Long resId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Member member;

    @Column(name = "userId", insertable=false, updatable=false)
    private String userId;

    // 방 이름
    private String roomName;
    // 방 + 연회장 가격
    private String roomPrice;

    // 유저이름
    private String userName;
    // 유저 전화번호
    private String userTel;
    // 유저 이메일
    private String userEmail;
    // 체크인 날짜
    @Column(nullable = false)
    private LocalDateTime resCheckin;
    // 체크아웃 날짜
    @Column(nullable = false)
    private LocalDateTime resCheckout;
    // 투숙 인원수
    @Column(nullable = false)
    private int resPerson;
    // 요청사항
    private String resRequest;
    // 예약한 날짜
    @Column(nullable = false)
    private LocalDateTime resDate;
    // 연회장 체크여부
    @Column(nullable = false, length = 1)
    private int facCheck;
    // 결제 여부
    @Column(nullable = false, length = 1)
    private int payCheck;
    @Column(nullable = false, length = 1)
    private int userFlag;

}
