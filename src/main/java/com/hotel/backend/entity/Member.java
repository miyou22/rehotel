package com.hotel.backend.entity;

import com.hotel.backend.constant.Role;
import com.hotel.backend.dto.MemberFormDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="member")
@Getter
@Setter
@ToString
public class Member {

    @Id
    @Column(length = 20, nullable = false)
    private String userId;

    @Column(length = 100, nullable = false)
    private String userPwd;

    @Column(length = 50,  unique = true)
    private String userEmail;

    @Column(nullable = false)
    private int userTel;

    @Column(length = 100, nullable = false)
    private String userAddr;

    @Column(length = 20, nullable = false)
    private String userName;

    @Column(nullable = false,length = 1)
    private String userGender;

    @Column(nullable = false)
    private LocalDate userBirth;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime userJoin;

    @Column(nullable = false,length = 1)
    private boolean  userPrivate;

    @Column(nullable = false,length = 1)
    private boolean  userFlag;

    //  인증코드
    @Column(length = 6)
    private String verificationCode;

    // 사용자인지 관리자인지 구별
    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
        Member member = new Member();
        member.setUserId(memberFormDto.getUserId());
        member.setUserName(memberFormDto.getUserName());
        member.setUserEmail(memberFormDto.getUserEmail());
        member.setUserAddr(memberFormDto.getUserAddr());
        member.setUserGender(memberFormDto.getUserGender());
        member.setUserBirth(memberFormDto.getUserBirth());
        member.setUserTel(memberFormDto.getUserTel());
        member.setUserPrivate(false);   // 기본값 false로 설정
        member.setUserFlag(true);   // 기본값 true로 설정
        member.setVerificationCode(memberFormDto.getVerificationCode());
        String password = passwordEncoder.encode(memberFormDto.getUserPwd());
        member.setUserPwd(password);
        member.setRole(Role.USER);

        return member;
    }
}
