package com.cognizant.booking_service.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class TravelPackageDTO {
	

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate availableFrom;
    private LocalDate availableTo;


}




