package com.dain.demo_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dain.demo_api.dto.request.UserCreateRequest;
import com.dain.demo_api.dto.response.UserResponse;

@Service
public class UserService {

    // 임시 저장소 (DB 대신)
    private final List<UserResponse> users = new ArrayList<>();

    public UserResponse createUser(UserCreateRequest request) {
        Long fakeId = System.currentTimeMillis();

        UserResponse user = new UserResponse(
                fakeId,
                request.getName(),
                request.getEmail()
        );

        users.add(user);
        return user;
    }

    public List<UserResponse> getUsers() {
        return users;
    }
}
// Service는 Controller와 Repository 사이에서 동작
// Service는 비즈니스 로직 담당
// Service는 “결정”만 한다
// Controller는 모른다

// users 리스트 = 임시 서랍
// POST = 서랍에 넣기
// GET = 서랍 열어보기