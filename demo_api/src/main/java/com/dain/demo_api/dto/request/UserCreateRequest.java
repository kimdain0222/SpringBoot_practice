package com.dain.demo_api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserCreateRequest {

    @NotBlank(message = "name은 필수입니다")
    private String name;

    @Email(message = "email 형식이 아닙니다")
    @NotBlank(message = "email은 필수입니다")
    private String email;

    public UserCreateRequest() {}

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}


// @RequestBody는 JSON → 객체

// Validation은 DTO에만 둔다

// Controller는 다시 얇아짐