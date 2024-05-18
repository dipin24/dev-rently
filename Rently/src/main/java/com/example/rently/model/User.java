package com.example.rently.model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String role; // 'buyer' or 'seller'

    // Getters and Setters
}
