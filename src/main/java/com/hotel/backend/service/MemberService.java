package com.hotel.backend.service;

import com.hotel.backend.entity.Member;
import com.hotel.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
