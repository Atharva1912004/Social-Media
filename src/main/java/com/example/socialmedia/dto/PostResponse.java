package com.example.socialmedia.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostResponse {
    private Long postId;
    private String title;
    private String description;
    private Date createdOn;
    private Long userId;
}
