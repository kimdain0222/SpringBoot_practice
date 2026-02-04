// Controller = 외부 요청(HTTP)을 처음 받는 ‘입구’
// ex) 정문에서 “어디 부서로 보낼지” 정해주는 직원
// 요청 받기 (URL, HTTP Method), 요청에 맞는 로직 호출, 응답 반환

package com.dain.demo_api.controller; // controller 역할을 담당

// Spring Web 관련 import
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

// DTO import
import com.dain.demo_api.dto.HelloRequest;
import com.dain.demo_api.dto.HelloResponse;

// Service import
import com.dain.demo_api.service.ExperienceService;

// 이 클래스는 HTTP 요청을 처리하는 컨트롤러고, GET 요청을 받을 거야
@RestController // REST API 전용 컨트롤러
public class ExperienceController {

    // JSON 데이터로 바로 응답을 반환하는 컨트롤러 클래스
    // = 이 컨트롤러는 REST API 전용이라는 뜻
    private final ExperienceService experienceService;

    // 생성자 주입 (Spring이 Service 객체를 주입해줌)
    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    // "/hello" 경로로 들어오는 GET 요청 처리
    @GetMapping("/hello")
    public HelloResponse hello(@Valid HelloRequest request) {
        // 실제 데이터 생성 로직은 Service 계층에 위임
        return experienceService.getHelloMessage(request.getName());
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
