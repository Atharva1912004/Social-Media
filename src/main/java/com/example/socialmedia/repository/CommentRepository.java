package com.example.socialmedia.repository;

import com.example.socialmedia.entity.Comments;
import com.example.socialmedia.service.CommentService;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.stream.events.Comment;

public interface CommentRepository extends JpaRepository<Comments,Long> {

}
