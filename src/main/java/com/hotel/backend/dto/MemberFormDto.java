package com.hotel.backend.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class MemberFormDto {

 @NotBlank(message = "아이디는 필수 입력 항목입니다.")
 private String userId;

 @NotEmpty(message = "비밀번호는 필수 입력 항목입니다.")
 @Length(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력하셔야 합니다.")
 private String userPwd;

 @NotEmpty(message = "이메일은 필수 입력 항목입니다.")
 @Email(message = "이메일 형식으로 입력하셔야 합니다.")
 private String userEmail;

 @NotEmpty(message = "전화번호는 필수 입력 항목입니다.")
 private int userTel;

 @NotEmpty(message = "주소는 필수 입력 항목입니다.")
 private String userAddr;

 @NotBlank(message = "이름은 필수 입력 항목입니다!")
 private String userName;

 @NotEmpty(message = "성별은 필수 선택 사항입니다.")
 private String userGender;

 @NotEmpty(message = "생일은 필수 입력 사항입니다.")
 private LocalDate userBirth;

 private LocalDateTime userJoin;
 private boolean  userPrivate;
 // userFlag 값을 설정하는 setter 메서드 추가
 @Setter
 private int  userFlag;


 @NotEmpty(message = "인증번호는 필수 입력 항목입니다.")
 private String verificationCode;

 @NotEmpty(message = "비밀번호 확인은 필수 입력 항목입니다.")
 private String passwordConfirm;

}
