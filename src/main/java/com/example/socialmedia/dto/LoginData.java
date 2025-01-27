package com.example.socialmedia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Access;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginData {
    private String email;
    private String password;
}
