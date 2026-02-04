package com.dain.demo_api.dto.request;

import jakarta.validation.constraints.NotBlank;

public class HelloRequest {

    @NotBlank(message = "name은 필수입니다")  //if문을 대체하는 선언적 검증
    private String name;

    // 기본 생성자 (Spring이 객체 만들 때 필요)객체를 먼저 만들고 → 값 채우기 위해
    public HelloRequest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) { //Spring은 요청 데이터를 setter를 통해 객체에 주입함
        this.name = name;
    }
}


