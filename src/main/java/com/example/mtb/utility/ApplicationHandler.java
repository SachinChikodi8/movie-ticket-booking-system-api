package com.example.mtb.utility;

import com.example.mtb.exception.UserEmailExist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> handleEmailAlreadyRegistred(UserEmailExist ex) {
        ErrorStructure<String> errorStructure = ErrorStructure.<String>builder()
                .errorCode(HttpStatus.NOT_FOUND.value())
                .errorMessage(ex.getMessage())
                .build();

        return new ResponseEntity<>(errorStructure, HttpStatus.NOT_FOUND);
    }
}
