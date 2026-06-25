package com.cognizant.booking_service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.booking_service.dto.TravelPackageDTO;



@FeignClient(
    name = "TRAVELPACKAGESERVICE"
)


public interface TravelPackageClient {
    @GetMapping("/packages/{id}")
    TravelPackageDTO getPackageById(@PathVariable("id") Long id);
    @GetMapping("/packages")
    ResponseEntity<List<TravelPackageDTO>> getAllPackages();
    

}
