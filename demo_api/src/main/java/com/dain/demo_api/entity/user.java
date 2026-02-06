package com.dain.demo_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")  // 여기서 "users"는 DB에 생성될 “테이블 이름”
public class User { //클래스 이름의 User는 테이블의 “엔티티 클래스명”. 폴더명과 같아야함

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    protected User() {} // JPA용 기본 생성자

    public User(String name, String email) {
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

// Entity는 DB 테이블과 매핑되는 클래스
// Entity는 JPA가 관리

//비유
// Entity = DB 테이블 설계도
// DTO = 요청/응답용 종이 양식
// 절대 섞지 않는다.

// class User → 자바 세계
// User.java → 자바 규칙
// @Table(name = "users") → DB 세계
// 문자열 "users" → JPA가 DB에 쓰는 이름