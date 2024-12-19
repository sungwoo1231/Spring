package com.dw.jdbcapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus 역할은 사용자 정의예외의 기본 http 상태코드를 결정하는 것임
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidRequestException extends RuntimeException{
    private InvalidRequestException() {
        super();
    }
    public InvalidRequestException(String message){
        super(message);
    }
}
