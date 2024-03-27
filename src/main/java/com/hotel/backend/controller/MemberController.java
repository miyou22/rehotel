package com.hotel.backend.controller;

import com.hotel.backend.dto.MemberFormDto;
import com.hotel.backend.entity.Member;
import com.hotel.backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/member")
@CrossOrigin
public class MemberController {
    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;



    //  로그인
    //---------------------------------------------------------------------------------------------------------------------
    @PostMapping("/login")
    public int login(@RequestBody MemberFormDto memberFormDto) {
//        System.out.println("로그인 전 정보 : " + memberFormDto.getEmail());
//        System.out.println("로그인 비밀번호 : " + passwordEncoder.encode(memberFormDto.getPassword()));

        Member findMember = memberService.login(memberFormDto.getUserEmail());
//        System.out.println("로그인 후 정보 : " + findMember);
        // System.out.println("저장된 비밀번호 : " + passwordEncoder.encode(memberFormDto.getPassword()));

//        System.out.println( "[ 비밀번호 ]\n" + memberFormDto.getPassword() + "\n" + findMember.getPassword() );
//        System.out.println( "비교 ==> " + passwordEncoder.matches(memberFormDto.getPassword(), findMember.getPassword()) );
//
//        boolean result = false;
//        result = passwordEncoder.matches(findMember.getPassword(), memberFormDto.getPassword());
//        System.out.println("result ==> " + result);

        int result = -9;
        if(passwordEncoder.matches(memberFormDto.getUserPwd(), findMember.getUserPwd())) {
            System.out.println("로그인 성공.");
            result = 0;
        } else {
            System.out.println("로그인 정보가 잘못되었습니다..");
            result = -1;
        }
        return result;
    }

    //---------------------------------------------------------------------------------------------------------------------
    //  회원가입
    //---------------------------------------------------------------------------------------------------------------------
    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    @PostMapping("/memberInsert")
    public void itemInsert(@RequestBody MemberFormDto memberFormDto) {
        System.out.println("회원가입 ==> " + memberFormDto);

        Member member = Member.createMember(memberFormDto, passwordEncoder);
        memberService.saveMember(member);

    }
    @PostMapping("/checkDuplicate")
    public ResponseEntity<?> checkDuplicate(@RequestBody Map<String, String> requestData) {
        // 클라이언트로부터 전달받은 아이디를 가져옵니다.
        String userId = requestData.get("userId");

        // 아이디 중복 여부를 검사합니다.
        boolean isDuplicate = memberService.isUserIdDuplicate(userId);

        // 결과를 JSON 형태로 반환합니다.
        Map<String, Boolean> response = new HashMap<>();
        response.put("isDuplicate", isDuplicate);
        return ResponseEntity.ok(response);
    }


}
