package com.market.shop.mapper;

import com.market.shop.model.dao.Role;
import com.market.shop.model.dao.User;
import com.market.shop.model.dto.user.UserCreateDto;
import com.market.shop.model.dto.user.UserResponseDto;
import com.market.shop.model.dto.user.UserUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapStruct {

    @Mapping(source = "user.roles", target = "roles", qualifiedByName = "mapRoleToString")
    UserResponseDto mapUserToUserResponseDto(User user);
    User mapCreateUserDtoToUser(UserCreateDto userCreateDto);
    User mapUpdateUserDtoToUser(UserUpdateDto userUpdateDto);

    @Named("mapRoleToString")
    default Set<String> mapRoleToString(Set<Role> userRoles) {
        return userRoles.stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
    }
}
