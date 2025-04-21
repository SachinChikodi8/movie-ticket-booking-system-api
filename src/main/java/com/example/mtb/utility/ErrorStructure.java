package com.example.mtb.utility;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorStructure<T> {
    private int errorCode;
    private String errorMessage;
    private T error;

}
