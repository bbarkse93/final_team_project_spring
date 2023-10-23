package com.example.team_project._core.erroes.exception;

import com.example.team_project._core.utils.ApiUtils;
import lombok.Getter;
import org.springframework.http.HttpStatus;


// Not Found
// 자원을 찾을 수 없음
@Getter
public class Exception404 extends RuntimeException {
    public Exception404(String message) {
        super(message);
    }

    public ApiUtils.ApiResult<?> body() {
        return ApiUtils.error(getMessage(), HttpStatus.NOT_FOUND);
    }

    public HttpStatus status() {
        return HttpStatus.NOT_FOUND;
    }
}
