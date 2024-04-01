package com.hotel.backend.controller;

import com.hotel.backend.dto.MemberFormDto;
import com.hotel.backend.entity.Member;
import com.hotel.backend.entity.Reservation;
import com.hotel.backend.repository.MemberRepository;
import com.hotel.backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/member")
@CrossOrigin
public class MemberController {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MemberFormDto memberFormDto) {
        try {
            Member findMember = memberService.login(memberFormDto.getUserId());
            if (findMember != null && passwordEncoder.matches(memberFormDto.getUserPwd(), findMember.getUserPwd())) {
                // 로그인 성공
                System.out.println("11로그인 성공");
                return ResponseEntity.ok(findMember.getUserId());
            } else {
                // 아이디나 비밀번호가 맞지 않는 경우
                System.out.println("22아이디나 비밀번호가 맞지 않습니다.");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("아이디나 비밀번호가 맞지 않습니다.");
            }
        } catch (IllegalArgumentException e) {
            // 회원을 찾지 못한 경우
            System.out.println("33해당 아이디의 회원을 찾을 수 없습니다.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("해당 아이디의 회원을 찾을 수 없습니다.");
        }
    }

    // DB에 저장되어있는 데이터들 가져오기
    @GetMapping("/memInfo")
    public List<Member> memInfo(Model model) {
        System.out.println("Vue Gethering Test.....");
        List<Member> memInfo = memberRepository.findAll();
        System.out.println("아이템 리스트 ==> " + memInfo);

        model.addAttribute("checkList", memInfo);
        return memInfo;
    }
    //---------------------------------------------------------------------------------------------------------------------
    //  회원가입
    //---------------------------------------------------------------------------------------------------------------------
    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    @PostMapping("/memberInsert")
    public void memberInsert(@RequestBody MemberFormDto memberFormDto) {
        System.out.println("Member 비밀번호 ==> " + memberFormDto.getUserPwd() + " : " + memberFormDto.getUserPwd().length());
        System.out.println("Member Insert ==> " + memberFormDto.getUserName() + " : " + memberFormDto.getUserBirth());

        try {
            System.out.println("회원가입 ==> " + memberFormDto);
            Member member = Member.createMember(memberFormDto, passwordEncoder);
            memberService.saveMember(member);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/checkDuplicate")
    public ResponseEntity<?> checkDuplicate(@RequestBody Map<String, String> requestData) {
        // 클라이언트로부터 전달받은 아이디를 가져오기.
        String userId = requestData.get("userId");

        // 아이디 중복 여부를 검사.
        boolean isDuplicate = memberService.isUserIdDuplicate(userId);
        System.out.println("회원가입 ==> " + userId);

        // 결과를 JSON 형태로 반환.
        Map<String, Boolean> response = new HashMap<>();
        response.put("isDuplicate", isDuplicate);
        return ResponseEntity.ok(response);
    }

    //Test
    @PostMapping("/memberUpdate")
    public ResponseEntity<?> memberUpdate(@RequestBody Map<String, String> requestData) {
        String userId = requestData.get("userId");
        System.out.println("memberUpdate UserId == " + userId);
        Member findMember = memberService.memberUpdate(userId);
        return ResponseEntity.ok(findMember);
    }

    @PostMapping("/memberUpdatePost")
    public void memberUpdatePost(@RequestBody MemberFormDto memberFormDto) {
        Member member = Member.updateMember(memberFormDto, passwordEncoder);
        memberService.updateMember(member);
    }


}
