package com.market.shop.model.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record ProductUpdateDto(@NotBlank UUID id, @NotBlank String name, @NotBlank BigDecimal price, @NotBlank Long quantity, @NotBlank String serialNumber, @NotNull Boolean active) {
}
