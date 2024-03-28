package com.hotel.backend.service;

import com.hotel.backend.entity.Member;
import com.hotel.backend.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final HttpSession httpSession;

    // 로그인
    public Member login(String userId) {
        System.out.println("MemberService id() ==> " + userId);
        Optional<Member> optionalFindMember = memberRepository.findByUserId(userId);
        if (optionalFindMember.isPresent()) {
            Member findMember = optionalFindMember.get();
            System.out.println("MemberService findMember ==> " + findMember);

            httpSession.setAttribute("loggedInMember", findMember); // loggedInMember라는 이름으로 로그인 회원 정보를 세션에 저장
            return findMember;
        } else {
            // 회원을 찾지 못한 경우에 대한 처리
            throw new IllegalArgumentException("해당 아이디의 회원을 찾을 수 없습니다.");
        }
    }

    // 로그아웃
    public void logout() {
        httpSession.removeAttribute("loggedInMember");  // 세션에서 로그인 회원 정보 제거
    }

    // 세션에서 현재 로그인 상태 확인
    public boolean isLoggedIn() {
        return httpSession.getAttribute("loggedInMember") != null;
    }
    public boolean checkLoginStatus() {
        return isLoggedIn();
    }

    // 회원가입
    public void saveMember(Member member){
        memberRepository.save(member);
    }
    public boolean isUserIdDuplicate(String userId) {
        // 아이디가 이미 존재하는지를 검사하여 결과를 반환함.
        Optional<Member> existingMember = memberRepository.findByUserId(userId);    // 중복되는 Id가 없을 수 있으므로 optional로 작성
        return existingMember.isPresent();
    }
}
