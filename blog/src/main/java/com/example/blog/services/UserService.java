package com.example.blog.services;

import com.example.blog.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto creatUser(UserDto user);

    UserDto updateUser(UserDto user, Integer userId);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();

    void deleteUser(Integer userId);

}
