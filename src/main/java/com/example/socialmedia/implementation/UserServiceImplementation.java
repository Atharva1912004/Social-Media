package com.example.socialmedia.implementation;

import com.example.socialmedia.dto.UserDto;
import com.example.socialmedia.entity.Role;
import com.example.socialmedia.entity.User;
import com.example.socialmedia.exception.UserNotFoundException;
import com.example.socialmedia.repository.UserRepository;
import com.example.socialmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto addUser(UserDto userDto) {
        String name = userDto.getName();
        String email = userDto.getEmail();
        String password = userDto.getPassword();
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setIsEnabled(true);
        user.setDateRegistered(LocalDate.now());
        user.setTimeRegistered(LocalTime.now());
        user.setRole(Role.USER);
        User savedUser = userRepository.save(user);
        UserDto response = new UserDto();
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        return response;
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User", "User Id", id));
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        return userDto;
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> all = userRepository.findAll();
        List<UserDto> dtos = new ArrayList<>();
        for (User user : all) {
            UserDto userDto = new UserDto();
            user.setEmail(user.getEmail());
            user.setName(user.getName());
            dtos.add(userDto);
        }
        return dtos;
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User", "User Id", id));
        userRepository.delete(user);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User", "User Id", id));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        User savedUser = userRepository.save(user);
        UserDto dto = new UserDto();
        dto.setEmail(savedUser.getEmail());
        dto.setName(savedUser.getName());
        dto.setPassword(savedUser.getPassword());
        return dto;
    }

    @Override
    public List<UserDto> getUserByEmail(String email) {
        List<User> byEmailContaining = userRepository.findByEmailContaining(email);
        List<UserDto> dtos = new ArrayList<>();
        for (User user : byEmailContaining) {
            UserDto userDto = new UserDto();
            user.setEmail(user.getEmail());
            user.setName(user.getName());
            dtos.add(userDto);
        }
        return dtos;
    }

    @Override
    public List<UserDto> getUserByName(String name) {
        List<User> byNameContainingIgnoreCase = userRepository.findByNameContainingIgnoreCase(name);
        List<UserDto> dtos = new ArrayList<>();
        for (User user : byNameContainingIgnoreCase) {
            UserDto userDto = new UserDto();
            user.setEmail(user.getEmail());
            user.setName(user.getName());
            dtos.add(userDto);
        }
        return dtos;
    }
}