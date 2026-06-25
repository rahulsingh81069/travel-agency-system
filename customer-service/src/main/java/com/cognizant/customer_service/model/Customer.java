package com.cognizant.customer_service.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class Customer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(nullable = false, length = 100)
    private String firstName;
 
    @Column(nullable = false, length = 100)
    private String lastName;
 
    @Column(nullable = false, length = 100, unique = true)
    private String email;
 
    @Column(nullable = false, length = 20)
    private String phone;
 
    @Column(nullable = false, length = 250)
    private String address;
 
    @Column(nullable = false)
    private LocalDateTime createdAt;

}
