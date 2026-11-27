package com.market.shop.model.dto.user;

import jakarta.validation.constraints.NotNull;

public record UpdateRole(@NotNull String roleName) {
}
