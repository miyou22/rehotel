package com.hotel.backend.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class MemberFormDto {
    @NotBlank(message = "이름은 필수 입력 항목입니다!")
    private String  userName;

    @NotEmpty(message = "이메일은 필수 입력 항목입니다.")
    @Email(message = "이메일 형식으로 입력하셔야 합니다.")
    private String  userEmail;

    @NotEmpty(message = "비밀번호는 필수 입력 항목입니다.")
    @Length(min=8, max=20, message="비밀번호는 8자 이상 16자 이하로 입력하셔야 합니다.")
    private String  userPwd;

    @NotEmpty(message = "주소는 필수 입력 항목입니다.")
    private String userAddr;
}