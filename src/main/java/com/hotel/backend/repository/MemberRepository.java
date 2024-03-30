package com.hotel.backend.repository;

import com.hotel.backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
  //  Member findByUserEmail(String userEmail); // 이메일로 회원정보 찾기

    Optional<Member> findByUserId(String userId); // 아이디로 회원 정보 찾기
    //  optional  = null일수도 있는 값도 포함
}
