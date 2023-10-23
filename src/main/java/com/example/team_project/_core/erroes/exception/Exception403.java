package com.example.team_project._core.erroes.exception;

import com.example.team_project._core.utils.ApiUtils;
import lombok.Getter;
import org.springframework.http.HttpStatus;


// Forbidden
// 권한 없음
@Getter
public class Exception403 extends RuntimeException {
    public Exception403(String message) {
        super(message);
    }

    public ApiUtils.ApiResult<?> body(){
        return ApiUtils.error(getMessage(), HttpStatus.FORBIDDEN);
    }

    public HttpStatus status(){
        return HttpStatus.FORBIDDEN;
    }
}
