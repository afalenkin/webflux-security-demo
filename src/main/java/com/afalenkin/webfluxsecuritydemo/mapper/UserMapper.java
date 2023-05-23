package com.afalenkin.webfluxsecuritydemo.mapper;

import com.afalenkin.webfluxsecuritydemo.dto.UserDto;
import com.afalenkin.webfluxsecuritydemo.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto map(UserEntity userEntity);

    @InheritInverseConfiguration
    UserEntity map(UserDto userDto);
}
