package com.afalenkin.webfluxsecuritydemo.security;

import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
public class UserAuthenticationBearer {

    public static Mono<Authentication> create(VerificationResult verificationResult) {
        Claims claims = verificationResult.getClaims();
        String subject = claims.getSubject();
        String role = claims.get("role", String.class);
        String username = claims.get("username", String.class);

        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(role));
        Long principalId = Long.parseLong(subject);
        CustomPrincipal principal = new CustomPrincipal(principalId, username);

        return Mono.justOrEmpty(new UsernamePasswordAuthenticationToken(principal, null, authorities));
    }
}
