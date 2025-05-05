package com.example.mtb.service.impl;

import com.example.mtb.DTO.UserRegistrationRequest;
import com.example.mtb.DTO.UserResponse;
import com.example.mtb.DTO.UserUpdationRequest;
import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.User;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.exception.UserExistByEmailException;
import com.example.mtb.exception.UserNotFoundByEmailException;
import com.example.mtb.mapper.UserDetailMapper;
import com.example.mtb.repository.UserRepository;
import com.example.mtb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDetailMapper userMapper;


    @Override
    public UserResponse addUser(UserRegistrationRequest user) {
        if (userRepository.existsByEmail(user.email()))
            throw new UserExistByEmailException("User with the Email is already exists");

        UserDetails userDetails = switch (user.userRole()) {
            case USER -> copy(new User(), user);
            case THEATER_OWNER -> copy(new TheaterOwner(), user);
        };
        return userMapper.userDetailsResponseMapper(userDetails);

    }


    @Override
    public UserResponse editUser(UserUpdationRequest userRequest, String email) {
        if (userRepository.existsByEmail(email)){
            UserDetails user = userRepository.findByEmail(email);

            if( userRepository.existsByEmail(userRequest.email()))
                throw new UserExistByEmailException("User with the email already exists");

            user = copy(user, userRequest);

            return userMapper.userDetailsResponseMapper(user);
        }


    private UserDetails copy(UserDetails userDetails, UserRegistrationRequest request) {
        userDetails.setUserRole(request.userRole());
        userDetails.setEmail(request.email());
        userDetails.setPassword(request.password());
        userDetails.setDateOfBirth(request.dateOfBirth());
        userDetails.setPhoneNumber(request.phoneNumber());
        userDetails.setUsername(request.username());

        throw new UserNotFoundByEmailException("Email not found in the Database");

    }

    @Override
    public UserResponse softDeleteUser(String email) {
        if (userRepository.existsByEmail(email)) {
            UserDetails user = userRepository.findByEmail(email);
            user.setDelete(true);
            user.setDeletedAt(Instant.now());
            userRepository.save(user);
            return userMapper.userDetailsResponseMapper(user);
        }
        throw new UserNotFoundByEmailException("Email not found in the Database");
    }

    private UserDetails copy(UserDetails userRole, UserRegistrationRequest user) {
        userRole.setUserRole(user.userRole());
        userRole.setPassword(user.password());
        userRole.setEmail(user.email());
        userRole.setDateOfBirth(user.dateOfBirth());
        userRole.setPhoneNumber(user.phoneNumber());
        userRole.setUsername(user.username());
        userRepository.save(userRole);
        return userRole;
    }
    private UserDetails copy(UserDetails userDetails, UserUpdationRequest user) {
        userDetails.setDateOfBirth(user.dateOfBirth());
        userDetails.setPhoneNumber(user.phoneNumber());
        userDetails.setEmail(user.email());
        userDetails.setUsername(user.username());
        userRepository.save(userDetails);
        return userDetails;
    }



}
