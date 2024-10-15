package com.example.socialmedia.service;

import com.example.socialmedia.dto.PostRequest;
import com.example.socialmedia.dto.PostResponse;

import java.util.List;

public interface PostService {

    PostResponse addPost(PostRequest postRequest, Long userId);
    PostResponse getPost(Long postId);
    List<PostResponse> getPosts();
    PostResponse updatePost(PostRequest postRequest, Long postId);
    void deletePost(Long postId);
    List<PostResponse> getPostByUser(Long userId);
}