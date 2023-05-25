package com.afalenkin.webfluxsecuritydemo.security;

import com.afalenkin.webfluxsecuritydemo.entity.UserEntity;
import com.afalenkin.webfluxsecuritydemo.exception.UnauthorizedException;
import com.afalenkin.webfluxsecuritydemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
@Component
@RequiredArgsConstructor
public class AuthenticationManager implements ReactiveAuthenticationManager {
    private final UserRepository userRepository;

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        CustomPrincipal principal = (CustomPrincipal) authentication.getPrincipal();
        return userRepository.findById(principal.getId())
                .filter(UserEntity::isEnabled)
                .switchIfEmpty(Mono.error(new UnauthorizedException("User is disabled!")))
                .map(user -> authentication);
    }
}
