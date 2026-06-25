package com.cognizant.agency_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.agency_service.model.Agency;
import com.cognizant.agency_service.service.AgencyService;

@RestController
@RequestMapping("/agencies")
public class AgencyController {
	
	@Autowired
    private AgencyService service;
 
    @GetMapping
    public List getAll() { return service.getAll(); }
 
    @PostMapping
    public ResponseEntity create(@RequestBody  Agency agency) {
        return new ResponseEntity<>(service.create(agency), HttpStatus.CREATED);
    }
 
    @PutMapping("/{id}")
    public Agency update(@PathVariable Long id, @RequestBody  Agency agency) {
        return service.update(id, agency);
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
