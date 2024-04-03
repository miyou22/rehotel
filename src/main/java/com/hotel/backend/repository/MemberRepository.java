package com.hotel.backend.repository;

import com.hotel.backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUserId(String userId); // 아이디로 회원 정보 찾기
    //  optional  = null일수도 있는 값도 포함

    // 이메일, 이름으로 아이디 찾기
    Optional<Member> findByUserNameAndUserEmail(String userName, String userEmail);

    // 비밀번호 찾기
    Optional<Member> findByUserIdAndUserNameAndUserEmail(String userId, String userName, String userEmail);


}
