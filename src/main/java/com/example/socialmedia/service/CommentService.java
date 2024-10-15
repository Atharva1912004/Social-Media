
package com.example.socialmedia.service;

import com.example.socialmedia.dto.ApiResponse;
import com.example.socialmedia.dto.CommentRequest;
import com.example.socialmedia.entity.Comments;

import java.util.List;


public interface CommentService {

    ApiResponse addComment(CommentRequest commentRequest, Long userId, Long postId);
    Comments getComment(Long commentId);
    List<Comments> getAllComments();
    ApiResponse updateComment(CommentRequest commentRequest, Long commentId);
    ApiResponse deleteComment(Long commentId);
}
