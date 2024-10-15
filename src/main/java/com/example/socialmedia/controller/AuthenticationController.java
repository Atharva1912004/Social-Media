package com.example.socialmedia.controller;

import com.example.socialmedia.authentication.JwtGenerator;
import com.example.socialmedia.dto.ApiResponse;
import com.example.socialmedia.dto.LoginData;
import com.example.socialmedia.entity.User;
import com.example.socialmedia.exception.BadRequestException;
import com.example.socialmedia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginUser(@RequestBody LoginData loginData) {
        User user = userRepository.findByEmail(loginData.getEmail());

        if (Objects.isNull(user)) throw new BadRequestException("User not found with email");

        String password = user.getPassword(); // encoded
        boolean matches = passwordEncoder.matches(loginData.getPassword(), password);

        if (Boolean.FALSE.equals(matches)) throw new BadRequestException("Password is not correct");
        JwtGenerator jwtGenerator = new JwtGenerator();
        String token = jwtGenerator.generateToken(user);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(token);
       ;

        return ResponseEntity.ok(apiResponse);

    }
}