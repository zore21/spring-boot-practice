package com.example.blog.services.impl;

import com.example.blog.entities.User;
import com.example.blog.payloads.UserDto;
import com.example.blog.repositories.UserRepository;
import com.example.blog.services.UserService;
import com.example.blog.excepttions.ResourceNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto creatUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepository.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotfoundException("User", "id", userId)
        );

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updatedUser = this.userRepository.save(user);
        return this.userToDto(updatedUser);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotfoundException("User", "id", userId)
        );
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepository.findAll();

        // here single user comes from a stream which is on list of Users
        // so single user is passed and also used as parameter to userToDto
        // so we use method reference here

        return users.stream().map( this::userToDto ).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotfoundException("User", "id", userId)
        );
        this.userRepository.delete(user);
    }

    private User dtoToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        return user;
    }

    public UserDto userToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());
        return userDto;
    }

}
