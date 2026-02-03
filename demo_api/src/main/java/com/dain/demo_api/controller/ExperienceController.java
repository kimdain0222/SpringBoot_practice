// Controller = 외부 요청(HTTP)을 처음 받는 ‘입구’ -ex)정문에서 “어디 부서로 보낼지” 정해주는 직원
// 요청 받기 (URL, HTTP Method), 요청에 맞는 로직 호출, 응답 반환


package com.dain.demo_api.controller; //controller 역할을 담당

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//이 클래스는 HTTP 요청을 처리하는 컨트롤러고, GET 요청을 받을 거야

import com.dain.demo_api.dto.HelloResponse;
import com.dain.demo_api.service.ExperienceService;
//HelloResponse DTO를 가져온다는 뜻.
//데이터를 직접 정의x, DTO 클래스를 통해 구조화된 데이터를 반환하는 것


@RestController // REST API 전용 컨트롤러
public class ExperienceController {
//JSON 데이터로 바로 응답을 반환하는 컨트롤러 클래스 = 이 컨트롤러는 REST API 전용이라는 뜻
    private final ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    // "/hello" 경로로 들어오는 GET 요청 처리
    @GetMapping("/hello")
    public HelloResponse hello(@RequestParam(required = false) String name) //name이 없어도 요청은 들어오게 허용
     {
        // 실제 데이터 생성 로직은 Service 계층에 위임
            if (name == null || name.isBlank()) { //우리가 직접 입력 검증하겠다
        throw new IllegalArgumentException("name 파라미터는 필수입니다");
    }    //“이 요청은 잘못됐다”라고 의도적으로 예외 발생시키는 것

        return experienceService.getHelloMessage(name);
        
    }
    
}



// <구조>
//브라우저
//  ↓ GET /hello
//Controller
//  ↓ 예외발생
//GlobalExceptionHandler
//  ↓ JSON 응답 에러
//브라우저

// <설명>
// Controller → 입구
// DTO → 데이터 모양
// Service → 로직
