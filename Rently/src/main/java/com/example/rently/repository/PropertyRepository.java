package com.example.rently.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rently.model.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
