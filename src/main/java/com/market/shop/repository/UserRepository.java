package com.market.shop.repository;

import com.market.shop.model.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> deleteUserById(UUID id);
}
