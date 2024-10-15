package com.example.socialmedia.repository;

import com.example.socialmedia.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByUser_UserId(Long userId);
    List<Post> findByUser_Name(String name);

}
