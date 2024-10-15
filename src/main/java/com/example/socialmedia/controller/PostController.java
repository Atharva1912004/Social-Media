package com.example.socialmedia.controller;

import com.example.socialmedia.dto.PostRequest;
import com.example.socialmedia.dto.PostResponse;
import com.example.socialmedia.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@RestController
@RequestMapping("/post")
@Tag(name = "POST", description = "Controller for creating and getting the POST's")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/{userId}")
    @Operation(
            deprecated = true,
            summary = "Create POST",
            tags = "POST"
    )
    public PostResponse addPost(@RequestBody @Valid PostRequest postRequest, @PathVariable Long userId){
        return postService.addPost(postRequest, userId);
    }

}