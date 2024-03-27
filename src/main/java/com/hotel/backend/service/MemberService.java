package com.hotel.backend.service;

import com.hotel.backend.entity.Member;
import com.hotel.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    // 로그인
    public Member login(String userEmail) {
        System.out.println("MemberService email() ==> " + userEmail);
        Member findMember = memberRepository.findByUserEmail(userEmail);
        if(findMember != null){
            // throw new IllegalStateException("이미 가입된 회원입니다.");
            System.out.println("MemberService findMember ==> " + findMember);
        }
        return findMember;
    }

    // 회원가입
    public void saveMember(Member member){
        memberRepository.save(member);
    }
    public boolean isUserIdDuplicate(String userId) {
        // 아이디가 이미 존재하는지를 검사하여 결과를 반환합니다.
        Optional<Member> existingMember = memberRepository.findByUserId(userId);
        return existingMember.isPresent();
    }
}
