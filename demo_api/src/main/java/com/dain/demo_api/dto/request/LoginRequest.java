package com.dain.demo_api.dto.request;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank // 이메일은 반드시 있어야 함
    private String email;

    @NotBlank  // 비밀번호도 반드시 있어야 함
    private String password;

    public String getEmail() {  // getter는 JSON → 객체 변환에 필요
        return email;
    }

    public String getPassword() {
        return password;
    }
}

//“입력 양식 (신청서)”= 클라이언트가 보내야 할 데이터의 ‘형식 + 규칙’
// email, password 필드를 정의
// 어떤 값이 필수인지 명시 (@NotBlank)
// 잘못된 요청은 컨트롤러까지 못 오게 차단
// Validation은 컨트롤러가 아니라 DTO에서 한다