package com.dain.demo_api.dto.response;

public class UserResponse {

    private Long id;
    private String name;
    private String email;

    public UserResponse(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
// @ResponseBody는 객체 → JSON
// Response DTO 만들기 코드임
// DTO는 Controller와 Service 사이의 데이터 교환을 담당