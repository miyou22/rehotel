package com.hotel.backend.repository;

import com.hotel.backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUserEmail(String userEmail);
}
