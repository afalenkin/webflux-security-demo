package com.afalenkin.webfluxsecuritydemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends ApiException {

    public UnauthorizedException(String message) {
        super(message, "UNAUTHORIZED");
    }
}
