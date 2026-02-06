package com.dain.demo_api.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dain.demo_api.dto.common.ApiResponse;
import com.dain.demo_api.dto.request.UserCreateRequest;
import com.dain.demo_api.dto.response.UserResponse;
import com.dain.demo_api.service.UserService;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ApiResponse<UserResponse> createUser(
            @Valid @RequestBody UserCreateRequest request
    ) {
        UserResponse response = userService.createUser(request);
        return new ApiResponse<>(response);
    }
}
