package com.afalenkin.webfluxsecuritydemo.exception;

import lombok.Getter;

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
public class ApiException extends RuntimeException {
    @Getter
    protected String errorCode;

    public ApiException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
