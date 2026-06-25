package com.cognizant.agency_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.agency_service.model.Agency;

public interface AgencyRepository extends JpaRepository<Agency, Long> {

}
