package com.example.mtb.mapper;

import com.example.mtb.DTO.UserResponse;
import com.example.mtb.entity.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserDetailMapper {

    public UserResponse userDetailsResponseMapper(UserDetails userDetails){
        if(userDetails == null)
            return null;
        return new UserResponse(
                userDetails.getUserId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getPhoneNumber(),
                userDetails.getUserRole()

        );
    }

}
