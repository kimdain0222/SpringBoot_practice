package com.dain.demo_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dain.demo_api.dto.request.UserCreateRequest;
import com.dain.demo_api.dto.response.UserResponse;
import com.dain.demo_api.entity.User;
import com.dain.demo_api.repository.UserRepository;
import com.dain.demo_api.exception.DuplicateEmailException;


@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(UserCreateRequest request) {

        userRepository.findByEmail(request.getEmail()) //Service에 중복 검사 로직 추가
            .ifPresent(user -> {
                throw new DuplicateEmailException("이미 사용 중인 이메일이지롱~");
            });

        User user = new User(request.getName(), request.getEmail());
        User savedUser = userRepository.save(user);

        return new UserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );
    }

    public List<UserResponse> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getName(),
                        user.getEmail()
                ))
                .collect(Collectors.toList());
    }
}

// Service는 Controller와 Repository 사이에서 동작
// Service는 비즈니스 로직 담당
// Service는 “결정”만 한다
// Controller는 모른다

// users 리스트 = 임시 서랍
// POST = 서랍에 넣기
// GET = 서랍 열어보기

// Repository = DB 창구
// Service = 업무 담당자
// Entity = 실제 저장되는 물건