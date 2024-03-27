package com.hotel.backend.repository;

import com.hotel.backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUserEmail(String userEmail);

    Optional<Member> findByUserId(String userId);
}
