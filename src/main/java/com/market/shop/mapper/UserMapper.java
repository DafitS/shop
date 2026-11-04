package com.market.shop.mapper;

import com.market.shop.model.dao.User;
import com.market.shop.model.dto.UserResponseDto;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public UserResponseDto mapUserToUserResponse(User user) {

        return UserResponseDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .active(user.getActive())
                .build();
    }
}
