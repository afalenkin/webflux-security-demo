package com.afalenkin.webfluxsecuritydemo.exception;

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
public class ApiException extends RuntimeException {
    protected String errorCode;

    public ApiException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
