package com.cognizant.travel_package_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.travel_package_service.model.TravelPackage;

public interface TravelPackageRepository extends JpaRepository<TravelPackage, Long> {

}
