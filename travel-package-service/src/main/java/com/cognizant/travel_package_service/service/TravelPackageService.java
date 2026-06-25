package com.cognizant.travel_package_service.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.travel_package_service.model.TravelPackage;
import com.cognizant.travel_package_service.repository.TravelPackageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TravelPackageService {

    @Autowired
    private TravelPackageRepository repository;

    public List<TravelPackage> getAllPackages() {
        return repository.findAll();
    }

    public Optional<TravelPackage> getPackageById(Long id) {
        return repository.findById(id);
    }

    public TravelPackage createPackage(TravelPackage travelPackage) {
        return repository.save(travelPackage);
    }

    public TravelPackage updatePackage(Long id, TravelPackage updatedPackage) {
        return repository.findById(id).map(existing -> {
            existing.setName(updatedPackage.getName());
            existing.setDescription(updatedPackage.getDescription());
            existing.setPrice(updatedPackage.getPrice());
            existing.setAvailableFrom(updatedPackage.getAvailableFrom());
            existing.setAvailableTo(updatedPackage.getAvailableTo());
            return repository.save(existing);
        }).orElse(null);
    }

    public void deletePackage(Long id) {
        repository.deleteById(id);
    }
}