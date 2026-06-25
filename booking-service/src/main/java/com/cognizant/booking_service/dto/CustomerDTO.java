package com.cognizant.booking_service.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data 
public class CustomerDTO {
	
	private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private LocalDateTime createdAt;

}
