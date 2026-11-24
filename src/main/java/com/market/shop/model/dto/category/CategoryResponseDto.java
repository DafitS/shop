package com.market.shop.model.dto.category;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CategoryResponseDto(UUID id, String name) {
}
