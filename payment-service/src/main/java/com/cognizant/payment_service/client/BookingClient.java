package com.cognizant.payment_service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.payment_service.dto.BookingDTO;





@FeignClient(
	    name = "BOOKING-SERVICE"
	)

public interface BookingClient {

    @GetMapping("bookings/t/{id}")
    BookingDTO getBookingById(@PathVariable("id") Long id);

    @PutMapping("bookings/{id}/payment-status") 
    BookingDTO updatePaymentStatus(@PathVariable("id") Long id,@RequestBody String status);
}



