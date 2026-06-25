package com.cognizant.travel_package_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TravelPackageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelPackageServiceApplication.class, args);
	}

}
