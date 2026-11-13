package com.market.shop.controller;

import com.market.shop.mapper.UserMapStruct;
import com.market.shop.model.dao.User;
import com.market.shop.model.dto.user.UserCreateDto;
import com.market.shop.model.dto.user.UserResponseDto;
import com.market.shop.model.dto.user.UserUpdateDto;
import com.market.shop.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")

public class UserController {

    private final UserService userService;
    private final UserMapStruct userMapper;

    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable UUID id) {

        return userMapper.mapUserToUserResponseDto(userService.getUserById(id));
    }

    @PostMapping
    public UserResponseDto createUser(@RequestBody @Valid UserCreateDto user) {
        User newUser = userMapper.mapCreateUserDtoToUser(user);
        return userMapper.mapUserToUserResponseDto(userService.create(newUser));
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable UUID id) {

        userService.deleteUserById(id);
    }

    @PutMapping
    public UserResponseDto updateUser(@RequestBody UserUpdateDto user) {
        User updateUser = userMapper.mapUpdateUserDtoToUser(user);
        return userMapper.mapUserToUserResponseDto(userService.updateUser(updateUser));
    }

    @GetMapping
    public Page<UserResponseDto> getPageUsers(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userService.getPageProducts(pageable)
                .map(userMapper::mapUserToUserResponseDto);
    }
}
