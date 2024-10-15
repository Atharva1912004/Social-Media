package com.example.socialmedia.controller;



import com.example.socialmedia.dto.ApiResponse;
import com.example.socialmedia.dto.CommentRequest;
import com.example.socialmedia.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Value("${application.version}")
    private String applicationVersion;
    @PostMapping
    public ApiResponse addComment(@RequestBody CommentRequest commentRequest, @RequestParam(name = "userId") Long userId, @RequestParam(name = "postId") Long postId) {
        return commentService.addComment(commentRequest, userId, postId);
    }

    @GetMapping
    public String getData() {
        return applicationVersion;
    }
}