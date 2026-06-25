package com.cognizant.agency_service.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "agencies")
@Data

public class Agency {
  
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(nullable = false, length = 150)
    private String name;
 
    @Column(nullable = false, length = 100)
    private String contactEmail;
 
    @Column(nullable = false, length = 250)
    private String address;
 
    @Column(nullable = false)
    private LocalDateTime createdAt;
}
