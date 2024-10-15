package com.example.socialmedia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @NotBlank(message = "Name should not be empty")
    @Size(min=2,max=20,message = "Name should be greater than 2 character and less than 20 characters")
    private String name;
    @NotBlank(message="Email cannot be blank")
    @Email(message="Email should be in correct format")
    private String email;
    @NotBlank
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,}$",message = "Password should be correct format")
    private String password;
}
