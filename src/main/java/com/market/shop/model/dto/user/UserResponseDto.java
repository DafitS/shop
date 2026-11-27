package com.market.shop.model.dto.user;

import lombok.Builder;

import java.util.Set;
import java.util.UUID;

@Builder
public record UserResponseDto(UUID id, String firstName, String lastName, String email, Set<String> roles, Boolean active) {
}
