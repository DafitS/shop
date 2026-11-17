package com.market.shop.model.dto.user;

import com.market.shop.validator.PasswordValid;
import com.market.shop.validator.groups.Create;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
@PasswordValid(groups = Create.class)
public record UserCreateDto(@NotBlank String firstName, @NotBlank String lastName, @NotBlank String password, @NotBlank String confirmPassword, @NotBlank @Email String email, @NotNull Boolean active) {
}
