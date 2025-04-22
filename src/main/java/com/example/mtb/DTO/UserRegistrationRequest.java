package com.example.mtb.DTO;

import com.example.mtb.enums.UserRole;

import java.time.LocalDate;

public record UserRegistrationRequest(
        String username,
        String password,
        String phoneNumber,
        UserRole userRole,
        String email,
        LocalDate dateOfBirth
){}