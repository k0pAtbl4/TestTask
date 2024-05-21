package com.example.TestTask.service;

import com.example.TestTask.entity.User;
import com.example.TestTask.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Slf4j
@Service
public class UserServiceBean implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(Integer id) throws Exception {
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found with id: " + id));

        if (user.isDeleted()) {
            throw new Exception("User was deleted");
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().filter(u -> !u.isDeleted()).collect(Collectors.toList());
    }

    @Override
    public User updateById(Integer id, User user) throws Exception {
        return userRepository.findById(id)
                .map(entity -> {
                    entity.setName(user.getName());
                    entity.setEmail(user.getEmail());
                    entity.setPassword(user.getPassword());
                    entity.setDeleted(user.isDeleted());
                    return userRepository.save(entity);
                })
                .orElseThrow(() -> new Exception("User not found with id: " + id));
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found with id: " + id));

        if (user.isDeleted()) {
            throw new Exception("User was deleted");
        } else {
            user.setDeleted(true);
            userRepository.save(user);
        }
    }
}
