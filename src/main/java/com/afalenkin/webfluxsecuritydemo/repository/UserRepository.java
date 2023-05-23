package com.afalenkin.webfluxsecuritydemo.repository;

import com.afalenkin.webfluxsecuritydemo.entity.UserEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
public interface UserRepository extends R2dbcRepository<UserEntity, Long> {

    Mono<UserEntity> getByUsername(String userName);
}
