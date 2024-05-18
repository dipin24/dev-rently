package com.example.rently.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rently.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
