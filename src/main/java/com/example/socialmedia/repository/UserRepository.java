package com.example.socialmedia.repository;

import com.example.socialmedia.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByName(String name);
    User findByEmail(String email);
    List<User> findByEmailContaining(String email);
    List<User> findByNameContainingIgnoreCase(String name);

}
