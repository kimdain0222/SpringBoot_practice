package com.dain.demo_api.service;

import org.springframework.stereotype.Service;

import com.dain.demo_api.dto.response.HelloResponse;

@Service
public class ExperienceService {

    public HelloResponse getHelloMessage(String name) {
        return new HelloResponse(
                "안녕하세요 " + name + "!",
            "service"
        );
    }
}


// controller → 요청/응답
// service → 로직
// dto → 데이터 모양