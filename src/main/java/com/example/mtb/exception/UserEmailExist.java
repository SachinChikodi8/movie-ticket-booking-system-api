package com.example.mtb.exception;

public class UserEmailExist extends RuntimeException {

    private String message;

    public String getMessage() {
        return message;
    }

    public UserEmailExist(String message) {
        this.message = message;
    }

}