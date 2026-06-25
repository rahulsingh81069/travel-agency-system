package com.cognizant.customer_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.customer_service.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
