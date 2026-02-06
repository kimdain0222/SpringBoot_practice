package com.dain.demo_api.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.Conflict;

import com.dain.demo_api.dto.common.ApiError;
import com.dain.demo_api.dto.common.ApiResponse;

import org.springframework.http.HttpStatus;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(IllegalArgumentException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public ApiResponse<ApiError> handleIllegalArgument(IllegalArgumentException e) {
    return new ApiResponse<>(
        new ApiError("BAD_REQUEST", e.getMessage())
    );
}


@ExceptionHandler(DuplicateEmailException.class) //전역 예외 처리기 하나에 예외 핸들러 메서드만 늘리기
@ResponseStatus(HttpStatus.CONFLICT) //이 예외가 발생하면 409 상태 코드 반환하라는 뜻
public ApiResponse<ApiError> handleDuplicateEmail(DuplicateEmailException e) {
    return new ApiResponse<>(
        new ApiError("DUPLICATE_EMAIL", e.getMessage())
    );
}
// DuplicateEmailException 발생
// Spring이 이 핸들러 메서드로 이동
// HTTP Status = 409 Conflict (409오류가 중복오류를 뜻함)
// Body = ApiResponse<ApiError>

}
