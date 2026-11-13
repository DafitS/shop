package com.market.shop.model.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record UserUpdateDto(@NotBlank UUID id, @NotBlank String firstName, @NotBlank String lastName, @NotBlank String password, @NotBlank @Email String email, @NotNull Boolean active) {
}
