package com.example.socialmedia.implementation;

import com.example.socialmedia.repository.PostRepository;
import com.example.socialmedia.repository.UserRepository;
import com.example.socialmedia.dto.PostRequest;
import com.example.socialmedia.dto.PostResponse;
import com.example.socialmedia.entity.Post;
import com.example.socialmedia.entity.User;
import com.example.socialmedia.exception.UserNotFoundException;
import com.example.socialmedia.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Service
public class PostImplementation implements PostService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostResponse addPost(PostRequest postRequest, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User", "User Id", userId));
        Post post = Post
                .builder()
                .title(postRequest.getTitle())
                .description(postRequest.getDescription())
                .dateCreated(new Date())
                .user(user)
                .build();
        Post savedPost = postRepository.save(post);



        return PostResponse
                .builder()
                .postId(savedPost.getPostId())
                .title(savedPost.getTitle())
                .description(savedPost.getDescription())
                .createdOn(savedPost.getDateCreated())
                .userId(savedPost.getUser().getUserId())
                .build();
    }

    @Override
    public PostResponse getPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new UserNotFoundException("Post", "Post Id", postId));

        // Convert to Post response
        return PostResponse
                .builder()
                .userId(post.getUser().getUserId())
                .createdOn(post.getDateCreated())
                .description(post.getDescription())
                .title(post.getTitle())
                .build();
    }

    @Override
    public List<PostResponse> getPosts() {
        List<Post> postList = postRepository.findAll();

        List<PostResponse> response = new ArrayList<>();
        for (Post post : postList) {
            PostResponse postResponse = PostResponse
                    .builder()
                    .userId(post.getUser().getUserId())
                    .createdOn(post.getDateCreated())
                    .description(post.getDescription())
                    .title(post.getTitle())
                    .build();
            response.add(postResponse);
        }
        return response;
    }

    @Override
    public PostResponse updatePost(PostRequest postRequest, Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new UserNotFoundException("Post", "Post Id", postId));
        post.setTitle(postRequest.getTitle());
        post.setDescription(postRequest.getDescription());
        Post savedPost = postRepository.save(post);
        return PostResponse
                .builder()
                .userId(savedPost.getUser().getUserId())
                .createdOn(savedPost.getDateCreated())
                .description(savedPost.getDescription())
                .title(savedPost.getTitle())
                .build();
    }

    @Override
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new UserNotFoundException("Post", "Post Id", postId));
        postRepository.delete(post);
    }

    @Override
    public List<PostResponse> getPostByUser(Long userId) {
        List<Post> postList = postRepository.findByUser_UserId(userId);
        List<PostResponse> response = new ArrayList<>();
        for (Post post : postList) {
            PostResponse postResponse = PostResponse
                    .builder()
                    .userId(post.getUser().getUserId())
                    .createdOn(post.getDateCreated())
                    .description(post.getDescription())
                    .title(post.getTitle())
                    .build();
            response.add(postResponse);
        }
        return response;
    }
}