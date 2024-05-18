package com.example.rently.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.rently.model.User;
import com.example.rently.repository.UserRepository;
import com.example.rently.util.JwtUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public ResponseEntity<?> registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Email is already in use.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully.");
    }

    public ResponseEntity<?> loginUser(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser == null || !passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid email or password.");
        }
        String token = jwtUtil.generateToken(existingUser);
        return ResponseEntity.ok(token);
    }
}
