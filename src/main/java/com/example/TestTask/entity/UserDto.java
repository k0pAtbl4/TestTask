package com.example.TestTask.entity;

public class UserDto {
    private final Integer id;
    private final String name;
    private final String email;

    public UserDto(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
