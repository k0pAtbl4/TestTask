package com.example.TestTask.web;

import com.example.TestTask.entity.User;
import com.example.TestTask.entity.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface UserController {
    @GetMapping("/test")
    public String testFunction();
    @GetMapping("/notes")
    public List<UserDto> getAllUsers();

    @GetMapping("/notes/{id}")
    public UserDto getUser(@PathVariable Integer id) throws Exception;

    @PostMapping("/notes")
    public User createUser(@RequestBody User user);

    @PutMapping("/notes/{id}")
    public User updateUser(@PathVariable("id") Integer id, @RequestBody User user) throws Exception;

    @DeleteMapping("/notes/{id}")
    public void deleteUserById(@PathVariable Integer id) throws Exception;
}
