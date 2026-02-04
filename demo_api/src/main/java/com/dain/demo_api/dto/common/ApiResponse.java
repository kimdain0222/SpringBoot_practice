package com.dain.demo_api.dto.common;

public class ApiResponse<T> {

    private boolean success;
    private T data;
    private ApiError error;

    // 성공 응답용 생성자
    public ApiResponse(T data) {
        this.success = true;
        this.data = data;
        this.error = null;
    }

    // 실패 응답용 생성자
    public ApiResponse(ApiError error) {
        this.success = false;
        this.data = null;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public ApiError getError() {
        return error;
    }
}
