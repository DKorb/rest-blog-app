package com.backend.blog.repository;

import com.backend.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByUsernameOrEmail(String username, String email);

    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);

}