package com.market.shop.validator;

import com.market.shop.validator.impl.PasswordsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordsValidator.class)
public @interface PasswordValid {

    String message() default"Passwords must be the same!";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload()default{};
}
