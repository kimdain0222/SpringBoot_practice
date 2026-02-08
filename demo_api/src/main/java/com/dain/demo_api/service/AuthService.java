package com.dain.demo_api.service;

import org.springframework.stereotype.Service;

import com.dain.demo_api.dto.request.LoginRequest;
import com.dain.demo_api.dto.response.TokenResponse;
import com.dain.demo_api.security.JwtProvider;

@Service
public class AuthService {

    private final JwtProvider jwtProvider;

    public AuthService(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    public TokenResponse login(LoginRequest request) {

        // ⚠️ 지금은 DB 인증 생략 (다음 단계)
        if (!request.getPassword().equals("1234")) {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다");
        }

        String token = jwtProvider.generateToken(request.getEmail());
        return new TokenResponse(token);
    }
}
