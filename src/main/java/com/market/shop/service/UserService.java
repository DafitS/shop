package com.market.shop.service;

import com.market.shop.model.dao.User;
import com.market.shop.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;

    public User getUserById(UUID id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found"));//powtórzyc optional
    }

    public User create(User user) {

        return userRepository.save(user);
    }

    @Transactional
    public void deleteUserById(UUID id) {

        userRepository.deleteById(id);
    }

    public User updateUser(User user) {

        return userRepository.save(user);
    }
}
