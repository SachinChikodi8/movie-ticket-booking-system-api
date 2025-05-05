package com.example.mtb.utility;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RestResponseBuilder {

    public <T> ResponseEntity<ResponseStructure<T>> sucess(HttpStatus statusCode, String message, T data){
        return ResponseEntity.status(statusCode).body(ResponseStructure.<T>builder()
                .statusCode(statusCode.value())
                .message(message)
                .data(data)
                .build());
    }

    public ResponseEntity<ErrorStructure> error(HttpStatus statusCode, String message){
        return ResponseEntity.status(statusCode).body(ErrorStructure.builder()
                .statusCode(statusCode.value())
                .errorMessage(message)
                .build());
    }
}
