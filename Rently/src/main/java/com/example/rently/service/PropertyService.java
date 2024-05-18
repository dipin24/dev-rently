package com.example.rently.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.rently.model.Property;
import com.example.rently.repository.PropertyRepository;
import com.example.rently.util.MailUtil;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private MailUtil mailUtil;

    public ResponseEntity<?> addProperty(Property property) {
        propertyRepository.save(property);
        return ResponseEntity.ok("Property added successfully.");
    }

    public ResponseEntity<?> getAllProperties() {
        List<Property> properties = propertyRepository.findAll();
        return ResponseEntity.ok(properties);
    }

    public ResponseEntity<?> updateProperty(Long id, Property updatedProperty) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property == null) {
            return ResponseEntity.badRequest().body("Property not found.");
        }
        property.setPlace(updatedProperty.getPlace());
        property.setArea(updatedProperty.getArea());
        property.setBedrooms(updatedProperty.getBedrooms());
        property.setBathrooms(updatedProperty.getBathrooms());
        property.setNearbyFacilities(updatedProperty.getNearbyFacilities());
        propertyRepository.save(property);
        return ResponseEntity.ok("Property updated successfully.");
    }

    public ResponseEntity<?> deleteProperty(Long id) {
        if (!propertyRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Property not found.");
        }
        propertyRepository.deleteById(id);
        return ResponseEntity.ok("Property deleted successfully.");
    }

    public ResponseEntity<?> likeProperty(Long id) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property == null) {
            return ResponseEntity.badRequest().body("Property not found.");
        }
        property.setLikes(property.getLikes() + 1);
        propertyRepository.save(property);
        return ResponseEntity.ok("Property liked.");
    }

    public ResponseEntity<?> expressInterest(Long id) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property == null) {
            return ResponseEntity.badRequest().body("Property not found.");
        }
        // Send emails to buyer and seller
        mailUtil.sendInterestEmail(property);
        return ResponseEntity.ok("Interest expressed and emails sent.");
    }
}
