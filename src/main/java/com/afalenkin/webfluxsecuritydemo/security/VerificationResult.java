package com.afalenkin.webfluxsecuritydemo.security;

import io.jsonwebtoken.Claims;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
@Getter
@Setter
@Builder
public class VerificationResult {
    private Claims claims;
    private String token;
}
