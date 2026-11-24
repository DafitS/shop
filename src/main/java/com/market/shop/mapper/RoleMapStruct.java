package com.market.shop.mapper;

import com.market.shop.model.dao.Role;
import com.market.shop.model.dto.role.RoleDto;
import com.market.shop.model.dto.role.RoleResponseDto;
import com.market.shop.model.dto.role.RoleUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapStruct {
    Role mapRoleDtoToRole(RoleDto roleDto);
    Role mapRoleUpdateDtoToRole(RoleUpdateDto roleUpdateDto);
    RoleResponseDto mapRoleToRoleResponseDto(Role role);
}
