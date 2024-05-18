package com.example.rently.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.rently.model.Property;
import com.example.rently.service.PropertyService;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping
    public ResponseEntity<?> addProperty(@RequestBody Property property) {
        return propertyService.addProperty(property);
    }

    @GetMapping
    public ResponseEntity<?> getAllProperties() {
        return propertyService.getAllProperties();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProperty(@PathVariable Long id, @RequestBody Property property) {
        return propertyService.updateProperty(id, property);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProperty(@PathVariable Long id) {
        return propertyService.deleteProperty(id);
    }

    @PostMapping("/{id}/like")
    public ResponseEntity<?> likeProperty(@PathVariable Long id) {
        return propertyService.likeProperty(id);
    }

    @PostMapping("/{id}/interest")
    public ResponseEntity<?> expressInterest(@PathVariable Long id) {
        return propertyService.expressInterest(id);
    }
}
