package com.example.team_project._core.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

public class ApiUtils {
    public static <T> ApiResult<T> success(String msg, T data){
        return new ApiResult<>(1, msg, data);
    }

    public static ApiResult<?> error(String msg, HttpStatus status){
        return new ApiResult<>(-1, null, new ApiError(msg, status.value()));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class ApiResult<T>{
        private final int code;
        private final String msg;
        private final T data;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class ApiError{
        private final String msg;
        private final int status;
    }
}
