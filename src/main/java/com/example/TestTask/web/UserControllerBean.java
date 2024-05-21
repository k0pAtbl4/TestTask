package com.example.TestTask.web;

import com.example.TestTask.entity.User;
import com.example.TestTask.entity.UserDto;
import com.example.TestTask.mapper.UserMapper;
import com.example.TestTask.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController
public class UserControllerBean implements UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public String testFunction() {
        return "Test function";
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userMapper.listToDto(userService.getAllUsers());
    }

    @Override
    public UserDto getUser(Integer id) throws Exception {
        return userMapper.toDto(userService.getById(id));
    }

    @Override
    public User createUser(User user) {
        return userService.create(user);
    }

    @Override
    public User updateUser(Integer id, User user) throws Exception {
        return userService.updateById(id, user);
    }

    @Override
    public void deleteUserById(Integer id) throws Exception {
        userService.deleteById(id);
    }
}
