package com.afalenkin.webfluxsecuritydemo.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
@Component
@RequiredArgsConstructor
public class BearerTokenServerAuthenticationConverter implements ServerAuthenticationConverter {
    private final JwtHandler jwtHandler;
    private static final String BEARER_PREFIX = "Bearer ";
    private static final Function<String, Mono<String>> getBearerValue = authValue -> Mono.justOrEmpty(authValue.substring(BEARER_PREFIX.length()));

    @Override
    public Mono<Authentication> convert(ServerWebExchange exchange) {
        return extractHeader(exchange)
                .flatMap(getBearerValue)
                .flatMap(jwtHandler::check)
                .flatMap(UserAuthenticationBearer::create);
    }

    private Mono<String> extractHeader(ServerWebExchange serverWebExchange) {
        return Mono.justOrEmpty(serverWebExchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION));
    }
}
