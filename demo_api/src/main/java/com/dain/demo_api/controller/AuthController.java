package com.dain.demo_api.controller;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.dain.demo_api.dto.request.LoginRequest;
import com.dain.demo_api.dto.response.TokenResponse;
import com.dain.demo_api.dto.common.ApiResponse;
import com.dain.demo_api.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {   // Service 주입 (컨트롤러는 로직을 직접 안 한다)
        this.authService = authService;
    }

    @PostMapping("/login")   // 로그인 요청을 받는 엔드포인트
    public ApiResponse<TokenResponse> login(
            @Valid @RequestBody LoginRequest request
    ) {
        return new ApiResponse<>(authService.login(request)); // 실제 로그인 로직은 Service에게 위임
    }
}

//HTTP 요청을 받고 → 서비스에게 일 시키고 → 결과를 돌려주는 입구
//컨트롤러는 최대한 얇게 유지하고, 비즈니스 로직은 서비스에 위임하는 게 좋다.