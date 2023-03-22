package com.example.blog.controllers;

import com.example.blog.payloads.UserDto;
import com.example.blog.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<UserDto> createUser(
            @RequestBody UserDto userDto
            ){
        UserDto createUserDto = this.userService.creatUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

}
