package com.market.shop.mapper;

import com.market.shop.model.dao.User;
import com.market.shop.model.dto.user.UserCreateDto;
import com.market.shop.model.dto.user.UserResponseDto;
import com.market.shop.model.dto.user.UserUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapStruct {

    UserResponseDto mapUserToUserResponseDto(User user);
    User mapUserResponseDtoToUser(UserResponseDto userResponseDto);
    User mapCreateUserDtoToUser(UserCreateDto userCreateDto);
    User mapUpdateUserDtoToUser(UserUpdateDto userUpdateDto);
}
