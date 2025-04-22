package com.example.mtb.service.impl;

import com.example.mtb.DTO.UserRegistrationRequest;
import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.User;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.enums.UserRole;
import com.example.mtb.exception.UserEmailExist;
import com.example.mtb.repository.UserRepository;
import com.example.mtb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails addUser(UserRegistrationRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.email())) {
            throw new UserEmailExist("User with the Email already exists");
        }

        UserDetails newUser = switch (userRequest.userRole()) {
            case USER -> copy(new User(), userRequest);
            case THEATER_OWNER -> copy(new TheaterOwner(), userRequest);
        };

        System.out.println(newUser);
        return newUser;
    }

    private UserDetails copy(UserDetails userDetails, UserRegistrationRequest request) {
        userDetails.setUserRole(request.userRole());
        userDetails.setEmail(request.email());
        userDetails.setPassword(request.password());
        userDetails.setDateOfBirth(request.dateOfBirth());
        userDetails.setPhoneNumber(request.phoneNumber());
        userDetails.setUsername(request.username());

        return userRepository.save(userDetails);
    }
}
