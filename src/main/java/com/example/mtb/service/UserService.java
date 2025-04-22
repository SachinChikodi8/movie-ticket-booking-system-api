package com.example.mtb.service;

import com.example.mtb.DTO.UserRegistrationRequest;
import com.example.mtb.entity.User;
import com.example.mtb.entity.UserDetails;

public interface UserService {

    UserDetails addUser(UserRegistrationRequest user);

}
