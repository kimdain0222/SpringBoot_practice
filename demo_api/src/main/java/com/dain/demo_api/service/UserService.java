package com.dain.demo_api.service;

import org.springframework.stereotype.Service;
import com.dain.demo_api.dto.request.UserCreateRequest;
import com.dain.demo_api.dto.response.UserResponse;

@Service
public class UserService {

    public UserResponse createUser(UserCreateRequest request) {
        // 아직 DB 없으니 가짜 ID 생성
        Long fakeId = System.currentTimeMillis();

        return new UserResponse(
                fakeId,
                request.getName(),
                request.getEmail()
        );
    }
}
// Service는 비즈니스 로직 담당
// Service는 “결정”만 한다
// Controller는 모른다