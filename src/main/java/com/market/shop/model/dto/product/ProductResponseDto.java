package com.market.shop.model.dto.product;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record ProductResponseDto(UUID id, String name, BigDecimal price, Long quantity, String serialNumber, Boolean active) {
}
