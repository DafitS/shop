package com.market.shop.validator.impl;

import com.market.shop.model.dto.user.UserCreateDto;
import com.market.shop.validator.PasswordValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordsValidator implements ConstraintValidator<PasswordValid, UserCreateDto> {
    @Override
    public boolean isValid(UserCreateDto userCreateDto, ConstraintValidatorContext constraintValidatorContext) {
        return userCreateDto.password().equals(userCreateDto.confirmPassword());
    }
}
