package com.market.shop.model.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record UserResponseDto(UUID id, String firstName, String lastName, String email, Boolean active) {
}
