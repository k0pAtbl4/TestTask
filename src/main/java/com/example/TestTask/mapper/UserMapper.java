package com.example.TestTask.mapper;

import com.example.TestTask.entity.User;
import com.example.TestTask.entity.UserDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User entity);

    @InheritInverseConfiguration
    User toUser(UserDto entity);

    List<UserDto> listToDto(List<User> entityList);

    @InheritInverseConfiguration
    List<User> listToDomain(List<UserDto> entityList);
}


