package com.market.shop.controller;

import com.market.shop.model.dao.User;
import com.market.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")

public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable UUID id) {

        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {

        return userService.create(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable UUID id) {

        userService.deleteUserById(id);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {

        return userService.updateUser(user);
    }
}
//peoduct contr0oller dwie metody zapisac pobrqc, aktualizacja  i uswanie spróbowac