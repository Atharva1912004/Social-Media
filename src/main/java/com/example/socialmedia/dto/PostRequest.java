package com.example.socialmedia.dto;

import io.swagger.annotations.ApiKeyAuthDefinition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    @NotBlank(message = "Title cannot be Blank")
    @Size(min=2,max=40)
    private String title;

    @NotBlank(message = "Description cannot be Blank")
    @Size(min=2)
    private String description;
}
