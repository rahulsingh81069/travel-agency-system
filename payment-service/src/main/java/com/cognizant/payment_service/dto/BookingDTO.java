package com.cognizant.payment_service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data 
public class BookingDTO {
	
	private Long id;
    private String customerId;
    private String packageId;
    private LocalDate bookingDate;
    private BigDecimal totalAmount;
    private String paymentStatus;
    private LocalDateTime createdAt;

}
