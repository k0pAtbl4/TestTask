package com.example.TestTask.service;

import com.example.TestTask.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User getById(Integer id) throws Exception;
    List<User> getAllUsers();
    User updateById(Integer id, User user) throws Exception;
    void deleteById(Integer id) throws Exception;

}
