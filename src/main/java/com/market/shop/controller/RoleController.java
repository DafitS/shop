package com.market.shop.controller;

import com.market.shop.mapper.RoleMapStruct;
import com.market.shop.model.dao.Role;
import com.market.shop.model.dto.role.RoleDto;
import com.market.shop.model.dto.role.RoleResponseDto;
import com.market.shop.model.dto.role.RoleUpdateDto;
import com.market.shop.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/roles")

public class RoleController {

    private final RoleService roleService;
    private final RoleMapStruct roleMapStruct;

    @GetMapping("/{id}")
    public RoleResponseDto getRoleById(@PathVariable UUID id) {
        return roleMapStruct.mapRoleToRoleResponseDto(roleService.getRoleById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoleResponseDto createRole(@RequestBody RoleDto dto) {
        Role role = roleMapStruct.mapRoleDtoToRole(dto);
        return roleMapStruct.mapRoleToRoleResponseDto(roleService.createRole(role));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoleById(@PathVariable UUID id) {
        roleService.deleteRoleById(id);
    }

    @PutMapping
    public RoleResponseDto updateRole(@RequestBody RoleUpdateDto roleUpdateDto) {
        Role role = roleMapStruct.mapRoleUpdateDtoToRole(roleUpdateDto);

        return roleMapStruct.mapRoleToRoleResponseDto(
                roleService.updateRole(role)
        );
    }

}
