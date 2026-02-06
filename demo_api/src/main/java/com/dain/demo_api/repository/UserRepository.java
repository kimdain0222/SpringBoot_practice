package com.dain.demo_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dain.demo_api.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

// Repository는 Entity와 DB 사이의 데이터 접근 담당
// Repository는 JPA가 구현체를 자동 생성

// 구현 클래스 ❌
// 인터페이스만 ⭕
// Spring이 자동 구현