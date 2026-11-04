package com.market.shop.controller;

import com.market.shop.mapper.UserMapper;
import com.market.shop.model.dao.User;
import com.market.shop.model.dto.UserResponseDto;
import com.market.shop.service.UserService;
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
    private final UserMapper userMapper;

    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable UUID id) {

        return userMapper.mapUserToUserResponse(userService.getUserById(id));
    }

    @PostMapping
    public UserResponseDto createUser(@RequestBody User user) {

        return userMapper.mapUserToUserResponse(userService.create(user));
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable UUID id) {

        userService.deleteUserById(id);
    }

    @PutMapping
    public UserResponseDto updateUser(@RequestBody User user) {

        return userMapper.mapUserToUserResponse(userService.updateUser(user));
    }

    @GetMapping
    public Page<UserResponseDto> getUserProducts(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userService.getPageProducts(pageable)
                .map(userMapper::mapUserToUserResponse);
    }
}
