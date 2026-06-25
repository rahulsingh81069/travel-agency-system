package com.cognizant.customer_service.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.customer_service.Repository.CustomerRepository;
import com.cognizant.customer_service.model.Customer;

@Service
public class CustomerService {
	
	@Autowired
    private CustomerRepository repository;
 
    public List getAll() {
        return repository.findAll();
    }
    
    public Optional<Customer> getCustomerById(Long id) {
		return repository.findById(id);
	}
 
    public Customer create(Customer customer) {
        customer.setCreatedAt(LocalDateTime.now());
        return repository.save(customer);
    }
 
    public Customer update(Long id, Customer updated) {
        Customer customer = repository.findById(id).orElseThrow();
        customer.setFirstName(updated.getFirstName());
        customer.setLastName(updated.getLastName());
        customer.setEmail(updated.getEmail());
        customer.setPhone(updated.getPhone());
        customer.setAddress(updated.getAddress());
        return repository.save(customer);
    }
 
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
