package com.example.socialmedia.implementation;

import com.example.socialmedia.dto.ApiResponse;
import com.example.socialmedia.dto.CommentRequest;
import com.example.socialmedia.entity.Comments;
import com.example.socialmedia.entity.Post;
import com.example.socialmedia.entity.User;
import com.example.socialmedia.exception.UserNotFoundException;
import com.example.socialmedia.repository.CommentRepository;
import com.example.socialmedia.repository.PostRepository;
import com.example.socialmedia.repository.UserRepository;
import com.example.socialmedia.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CommentServiceImplementation implements CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

//    public CommentServiceImplementation(CommentRepository commentRepository) {
//        this.commentRepository = commentRepository;
//    }

    @Override
    public ApiResponse addComment(CommentRequest commentRequest, Long userId, Long postId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User", "User Id", userId));
        Post post = postRepository.findById(postId).orElseThrow(() -> new UserNotFoundException("Post", "Post Id", postId));

        //Convert CommentRequest to Comments
        Comments comments = Comments
                .builder()
                .comment(commentRequest.getComment())
                .dateCommented(new Date())
                .user(user)
                .post(post)
                .build();
        commentRepository.save(comments);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Comment Added");
        return apiResponse;
    }

    @Override
    public Comments getComment(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(()-> new UserNotFoundException("Comment", "Comment Id", commentId));
    }

    @Override
    public List<Comments> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public ApiResponse updateComment(CommentRequest commentRequest, Long commentId) {
        Comments comments = commentRepository.findById(commentId)
                .orElseThrow(() -> new UserNotFoundException("Comment", "Comment Id", commentId));
        comments.setComment(commentRequest.getComment());
        commentRepository.save(comments);
        return new ApiResponse("Comment Edited");
    }

    @Override
    public ApiResponse deleteComment(Long commentId) {
        Comments comments = commentRepository.findById(commentId)
                .orElseThrow(() -> new UserNotFoundException("Comment", "Comment Id", commentId));
        commentRepository.delete(comments);
        return new ApiResponse("Comment Deleted");
    }
}