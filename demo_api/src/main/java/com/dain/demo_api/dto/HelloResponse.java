package com.dain.demo_api.dto;

public class HelloResponse {    //DTO 클래스 시작

    private String message;    //JSON의 key가 될 필드들
    private String author;     //JSON의 key가 될 필드들

    public HelloResponse(String message, String author) {
        this.message = message;
        this.author = author;
    }   //객체 만들 때 값 넣어주는 생성자

    public String getMessage() {
        return message;
    }   //JSON 변환의 핵심 역할을 하는 getter 메서드
        //so, Spring 내부 JSON 변환기(Jackson)는 getter 메서드를 호출하여 값을 읽어감

    public String getAuthor() {
        return author;
    }
}
