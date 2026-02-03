package com.dain.demo_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dain.demo_api.dto.HelloResponse;

@RestController
public class ExperienceController {

    @GetMapping("/hello")
    public HelloResponse hello() {
        return new HelloResponse(
                "Spring Boot JSON 응답 성공!",
                "dain"
        );
    }
}
