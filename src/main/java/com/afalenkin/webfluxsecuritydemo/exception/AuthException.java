package com.afalenkin.webfluxsecuritydemo.exception;

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
public class AuthException extends ApiException {

    public AuthException(String message, String errorCode) {
        super(message, errorCode);
    }
}
