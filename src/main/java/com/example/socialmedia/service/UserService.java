package com.example.socialmedia.service;

import com.example.socialmedia.dto.UserDto;

import java.util.List;



public interface UserService {

    UserDto addUser(UserDto userDto);
    UserDto getUserById(Long id);
    List<UserDto> getAllUser();
    void deleteUser(Long id);
    UserDto updateUser(Long id, UserDto userDto);
    List<UserDto> getUserByEmail(String email);
    List<UserDto> getUserByName(String name);
}