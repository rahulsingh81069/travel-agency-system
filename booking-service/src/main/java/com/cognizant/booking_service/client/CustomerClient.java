package com.cognizant.booking_service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.booking_service.dto.CustomerDTO;




@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerClient {

    @GetMapping("/customers")
    List<CustomerDTO> getAll();

    @GetMapping("/customers/{id}") 
    CustomerDTO getCustomerById(@PathVariable("id") Long id);
}



