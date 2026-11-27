package com.market.shop.service;

import com.market.shop.model.dao.Role;
import com.market.shop.model.dao.User;
import com.market.shop.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;
import java.util.UUID;
import java.util.function.BiConsumer;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;
    private RoleService roleService;

    public User getUserById(UUID id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found"));
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

    public Page<User> getPageProducts(Pageable pageable) {

        return userRepository.findAll(pageable);
    }

    @Transactional
    public void updateRoles(UUID userId, String roleName, BiConsumer<Set<Role>, Role> consumerOfRoles) {
        User founduser = getUserById(userId);
        Role foundRole = roleService.getRoleByName(roleName);

        consumerOfRoles.accept(founduser.getRoles(), foundRole);
    }
}
