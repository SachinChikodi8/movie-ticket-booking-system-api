package com.example.mtb.service;

import com.example.mtb.DTO.UserRegistrationRequest;
import com.example.mtb.DTO.UserResponse;
import com.example.mtb.DTO.UserUpdationRequest;
import com.example.mtb.entity.UserDetails;

public interface UserService {

  UserResponse addUser(UserRegistrationRequest user);


  UserResponse editUser(UserUpdationRequest user, String email);

}
