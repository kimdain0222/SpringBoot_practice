package com.dain.demo_api.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

}
