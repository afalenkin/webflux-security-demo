package com.afalenkin.webfluxsecuritydemo.security;

import com.afalenkin.webfluxsecuritydemo.exception.AuthException;
import com.afalenkin.webfluxsecuritydemo.exception.UnauthorizedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Base64;
import java.util.Date;

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
@RequiredArgsConstructor
public class JwtHandler {
    private final String secret;

    public Mono<VerificationResult> check(String accessToken) {
        return Mono.just(verify(accessToken))
                .onErrorResume(exception -> Mono.error(new UnauthorizedException(exception.getLocalizedMessage())));
    }

    private VerificationResult verify(String token) {
        Claims claims = extractClaims(token);
        final Date expirationDate = claims.getExpiration();

        if (expirationDate.before(new Date())) {
            throw new AuthException("Token expired!", "TOKEN_EXPIRED");
        }
        return VerificationResult.builder()
                .claims(claims)
                .token(token)
                .build();
    }

    private Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(Base64.getEncoder().encodeToString(secret.getBytes()))
                .parseClaimsJws(token)
                .getBody();
    }

}
