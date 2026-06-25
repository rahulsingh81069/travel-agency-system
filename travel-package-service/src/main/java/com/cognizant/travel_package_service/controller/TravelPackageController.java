package com.cognizant.travel_package_service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cognizant.travel_package_service.model.TravelPackage;
import com.cognizant.travel_package_service.service.TravelPackageService;

import java.util.List;

@RestController
@RequestMapping("/packages")
public class TravelPackageController {

    @Autowired
    private TravelPackageService service;

    @GetMapping
    public ResponseEntity<List<TravelPackage>> getAllPackages() {
        return ResponseEntity.ok(service.getAllPackages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TravelPackage> getPackageById(@PathVariable Long id) {
        TravelPackage travelPackage = service.getPackageById(id).orElse(null);
        if (travelPackage != null) {
            return ResponseEntity.ok(travelPackage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TravelPackage> createPackage(@RequestBody TravelPackage travelPackage) {
        TravelPackage created = service.createPackage(travelPackage);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TravelPackage> updatePackage(@PathVariable Long id, @RequestBody TravelPackage travelPackage) {
        TravelPackage updated = service.updatePackage(id, travelPackage);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackage(@PathVariable Long id) {
        service.deletePackage(id);
        return ResponseEntity.noContent().build();
    }
}
