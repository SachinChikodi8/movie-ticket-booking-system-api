package com.example.mtb.controller;

import com.example.mtb.DTO.UserRegistrationRequest;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.service.UserService;
import com.example.mtb.utility.ResponseStructure;
import com.example.mtb.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final RestResponseBuilder restResponseBuilder;

    @PostMapping
    public ResponseEntity<ResponseStructure<UserDetails>> addUser(@RequestBody UserRegistrationRequest user){
        UserDetails savedUser = userService.addUser(user);
        return RestResponseBuilder.success(HttpStatus.CREATED, "User created successfully", savedUser);
    }
}
