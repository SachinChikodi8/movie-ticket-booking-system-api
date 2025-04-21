package com.example.mtb.service.impl;

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
    public UserDetails addUser(UserDetails user) {
        if (!userRepository.existsByEmail(user.getEmail())) {
            if (user.getUserRole() == UserRole.USER) {
                User newUser = new User();
                newUser.setUserRole(user.getUserRole());
                newUser.setEmail(user.getEmail());
                newUser.setUsername(user.getUsername());
                newUser.setPassword(user.getPassword());
                newUser.setCreatedAt(user.getCreatedAt());
                newUser.setUpdatedAt(user.getUpdatedAt());
                newUser.setDateOfBirth(user.getDateOfBirth());
                newUser.setPhoneNumber(user.getPhoneNumber());

                return userRepository.save(newUser);
            } else {
                TheaterOwner theaterOwner = new TheaterOwner();
                theaterOwner.setUserRole(user.getUserRole());
                theaterOwner.setEmail(user.getEmail());
                theaterOwner.setUsername(user.getUsername());
                theaterOwner.setPassword(user.getPassword());
                theaterOwner.setCreatedAt(user.getCreatedAt());
                theaterOwner.setUpdatedAt(user.getUpdatedAt());
                theaterOwner.setDateOfBirth(user.getDateOfBirth());
                theaterOwner.setPhoneNumber(user.getPhoneNumber());

                return userRepository.save(theaterOwner);
            }
        }

        throw new UserEmailExist("Email already exists");
    }

}
