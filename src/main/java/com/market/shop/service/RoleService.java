package com.market.shop.service;


import com.market.shop.model.dao.Role;
import com.market.shop.repository.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@RequiredArgsConstructor

public class RoleService {

    private final RoleRepository roleRepository;

    public Role getRoleById(UUID id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Transactional
    public void deleteRoleById(UUID id) {
        roleRepository.deleteById(id);
    }

    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }
}
