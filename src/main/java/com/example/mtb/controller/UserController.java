package com.example.mtb.controller;

import com.example.mtb.DTO.UserRegistrationRequest;
import com.example.mtb.DTO.UserResponse;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.service.UserService;
import com.example.mtb.utility.ResponseStructure;
import com.example.mtb.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final RestResponseBuilder restResponseBuilder;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody UserRegistrationRequest user){
        UserResponse userDetails = userService.addUser(user);
        return restResponseBuilder.success(HttpStatus.OK,"New User Details Has been added", userDetails);
    }
}
