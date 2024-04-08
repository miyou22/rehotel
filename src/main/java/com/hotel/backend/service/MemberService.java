package com.hotel.backend.service;

import com.hotel.backend.entity.Member;
import com.hotel.backend.entity.Reservation;
import com.hotel.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    // 로그인
    public Member login(String userId) {
        System.out.println("MemberService id() ==> " + userId);
        Optional<Member> optionalFindMember = memberRepository.findByUserId(userId);
        if (optionalFindMember.isPresent()) {       // 아이디로 회원정보 찾기 결과 존재할 경우
            Member findMember = optionalFindMember.get();
            System.out.println("MemberService findMember ==> " + findMember.getUserId());

            // 로그인 한 회원의 정보 로그에 출력
            System.out.println("로그인 성공: 세션에 사용자 정보 저장됨. 사용자 정보: " + findMember );
            return findMember;
        } else {
            // 회원을 찾지 못한 경우에 대한 처리
            throw new IllegalArgumentException("해당 아이디의 회원을 찾을 수 없습니다.");
        }
    }

    // 이름, 이메일로 아이디 찾기
    public Optional<Member> findId(String userName, String userEmail) {
        return memberRepository.findByUserNameAndUserEmail(userName, userEmail);
    }

    // 아이디, 이름, 이메일로 비밀번호 찾기
    public Optional<Member> findPw(String userId, String userName, String userEmail) {
        return memberRepository.findByUserIdAndUserNameAndUserEmail(userId, userName, userEmail);
    }

    // 비밀번호 변경
    public void changePassword(String userId, String newPassword) {
        Optional<Member> optionalMember = memberRepository.findByUserId(userId);
        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            member.setUserPwd(passwordEncoder.encode(newPassword));     // 회원의 비밀번호를 새로운 비밀번호로 변경
            memberRepository.save(member);  // 변경된 데이터를 저장
        } else {
            throw new IllegalArgumentException("해당 아이디의 회원을 찾을 수 없습니다.");
        }
    }

    // 회원가입
    public void saveMember(Member member){
        memberRepository.save(member);
    }
    public boolean isUserIdDuplicate(String userId) {
        // 아이디가 이미 존재하는지를 검사하여 결과를 반환함.
        Optional<Member> existingMember = memberRepository.findByUserId(userId);    // 중복되는 Id가 없을 수 있으므로(Null) optional로 작성
        return existingMember.isPresent();
    }

//    public void update(MemberFormDto memberFormDto) {
//        memberRepository.save(MemberEntity.toUpdateEntity(memberFormDto));
//
//    }

    //Test
    public Member memberUpdate(String userId) {
        System.out.println("MemberUpdateService id() ==> " + userId);
        Optional<Member> optionalFindMember = memberRepository.findByUserId(userId);

        System.out.println("MemberService findMember ==> " + optionalFindMember);

        Member findMember = optionalFindMember.get();

        return findMember;
    }

    public void updateMember(Member member) {
        System.out.println(member);
        memberRepository.save(member);
    }


    // 회원 정보 완전 삭제
    @Deprecated
    public void deleteMember(List<String> memberIds) {

        System.out.println("MemberService deleteMember ==> " + memberIds);
        memberIds.forEach(userId -> {
            Optional<Member> selectMember = memberRepository.findByUserId(userId);
            System.out.println(selectMember);
            Member member = selectMember.get();
            System.out.println(member.getUserId());
            memberRepository.delete(member);
        });
    }
}
