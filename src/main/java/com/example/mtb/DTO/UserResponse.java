package com.example.mtb.DTO;

import com.example.mtb.enums.UserRole;

public record UserResponse(
        String userId,
        String username,
        String email,
        UserRole userRole,
        String phoneNumber
){}
