package com.example.demo.exception;

import com.example.demo.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = ServiceException.class)
    public Result serviceExceptionError(ServiceException exception){
        log.error("业务异常:",exception);
        return Result.error(exception.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Result exceptionError(Exception exception){
        log.error("系统异常:",exception);
        return Result.error("系统异常");
    }
}

