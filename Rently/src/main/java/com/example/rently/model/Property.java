package com.example.rently.model;

import javax.persistence.*;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String place;
    private int area;
    private int bedrooms;
    private int bathrooms;
    private String nearbyFacilities; // Hospitals, Colleges, etc.
    private int likes;

    // Getters and Setters
}
