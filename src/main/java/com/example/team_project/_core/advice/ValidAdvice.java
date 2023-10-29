package com.example.team_project._core.advice;

import com.example.team_project._core.erroes.exception.Exception400;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.List;

@Aspect
@Component
public class ValidAdvice {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void PostMapping() {

    }


    @Before("PostMapping()")
    public void validationAdvice(JoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            if(arg instanceof Errors) {
                Errors errors = (Errors) arg;

                if(errors.hasErrors()) {
                    List<FieldError> filedErrors = errors.getFieldErrors();
                    throw new Exception400(
                            filedErrors.get(0).getDefaultMessage() + " : " + filedErrors.get(0).getField()
                    );
                }
            }
        }

    }

}
