package com.market.shop.controller;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class AdviceController {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    void handleConstraintViolationException(ConstraintViolationException constraintViolationException) {
        log.error("Validation error", constraintViolationException);
    }
}
//dodac reponse statusy i poczytac z dzisiaj, powórka crud dla category zrobic category jeden do wielu