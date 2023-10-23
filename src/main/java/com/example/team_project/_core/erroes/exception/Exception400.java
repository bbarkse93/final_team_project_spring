package com.example.team_project._core.erroes.exception;

import com.example.team_project._core.utils.ApiUtils;
import lombok.Getter;
import org.springframework.http.HttpStatus;


// Bad Request
// 유효성 검사 실패 or 잘못된 매개변수 요청
@Getter
public class Exception400 extends RuntimeException {

    public Exception400(String message) {
        super(message);
    }

    public ApiUtils.ApiResult<?> body(){
        return ApiUtils.error(getMessage(), HttpStatus.BAD_REQUEST);
    }

    public HttpStatus status(){
        return HttpStatus.BAD_REQUEST;
    }
}