package com.example.mtb.utility;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RestResponseBuilder {

    public static <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, String message, T data) {
        ResponseStructure<T> responseStructure = ResponseStructure.<T>builder()
                .statusCode(status.value())
                .message(message)
                .data(data)
                .build();
        return ResponseEntity.stat  us(status).body(responseStructure);
    }

    public <T> ResponseEntity<ErrorStructure<T>> error(HttpStatus errorCode, String errorMessage) {
        ErrorStructure<T> errorStructure = ErrorStructure.<T>builder()
                .errorCode(errorCode.value())
                .errorMessage(errorMessage)
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorStructure);
    }
}
