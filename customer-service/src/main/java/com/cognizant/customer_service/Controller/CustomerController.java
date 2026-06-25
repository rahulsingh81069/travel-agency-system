package com.cognizant.customer_service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.customer_service.Service.CustomerService;
import com.cognizant.customer_service.model.Customer;

@RestController
@RequestMapping("/customers")

public class CustomerController {
	
	@Autowired
    private CustomerService service;
 
    @GetMapping
    public List getAll() {
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		Customer customer = service.getCustomerById(id).orElse(null);

		if (customer != null) {
			return ResponseEntity.ok(customer); // Return 200 OK with booking data
		} else {
			return ResponseEntity.notFound().build(); // Return 404 if not found
		}
	}
	
 
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody  Customer customer) {
        return new ResponseEntity<>(service.create(customer), HttpStatus.CREATED);
    }
 
    @PutMapping("/{id}/update")
    public Customer update(@PathVariable Long id, @RequestBody @Validated Customer customer) {
        return service.update(id, customer);
    }
 
    @DeleteMapping("/{id}/delete")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
