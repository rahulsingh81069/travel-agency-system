package com.cognizant.agency_service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.agency_service.model.Agency;
import com.cognizant.agency_service.repository.AgencyRepository;

@Service
public class AgencyService {
	
	@Autowired
    private AgencyRepository repository;
 
    public List getAll() { return repository.findAll(); }
 
    public Agency create(Agency agency) {
        agency.setCreatedAt(LocalDateTime.now());
        return repository.save(agency);
    }
 
    public Agency update(Long id, Agency updated) {
        Agency agency = repository.findById(id).orElseThrow();
        agency.setName(updated.getName());
        agency.setContactEmail(updated.getContactEmail());
        agency.setAddress(updated.getAddress());
        return repository.save(agency);
    }
 
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
