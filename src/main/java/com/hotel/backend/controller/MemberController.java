package com.hotel.backend.controller;

import com.hotel.backend.dto.MemberFormDto;
import com.hotel.backend.entity.Member;
import com.hotel.backend.repository.MemberRepository;
import com.hotel.backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/member")
@CrossOrigin
public class MemberController {
    @Autowired
    MemberService memberService;

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
                return ResponseEntity.ok("로그인 성공");
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

    // 로그아웃
    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
        memberService.logout();
        return ResponseEntity.ok("로그아웃 성공");
    }

    @GetMapping("/checkLoginStatus")
    public ResponseEntity<?> checkLoginStatus() {
        boolean isLoggedIn = memberService.isLoggedIn();
        Map<String, Boolean> response = new HashMap<>();
        response.put("isLoggedIn", isLoggedIn);
        return ResponseEntity.ok(response);
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




}
