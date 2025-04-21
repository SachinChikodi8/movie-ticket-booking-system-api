package com.example.mtb.exception.handler;

import com.example.mtb.exception.UserEmailExist;
import com.example.mtb.utility.ErrorStructure;
import com.example.mtb.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class UserExceptionHandler {

    private final RestResponseBuilder restResponseBuilder;

    @ExceptionHandler
    public ResponseEntity<ErrorStructure<Object>> handleUserExistByEmailException(UserEmailExist ex){
        return restResponseBuilder.error(HttpStatus.OK, ex.getMessage());
    }
}
