package com.cognizant.booking_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.booking_service.dto.CustomerDTO;
import com.cognizant.booking_service.dto.TravelPackageDTO;
import com.cognizant.booking_service.model.Booking;
import com.cognizant.booking_service.service.BookingService;

@RestController
@RequestMapping("/bookings")

public class BookingController {

	@Autowired
	private BookingService bookingService;

	@GetMapping
	public List<Booking> getAllBookings() {
		return bookingService.getAllBookings();
	}
	
	@GetMapping("/{id}")
	public TravelPackageDTO travlling(@PathVariable Long id) {
		return bookingService.fetchTravelPackage(id);
	}

	@GetMapping("/t/{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
		Booking booking = bookingService.getBookingById(id);

		return ResponseEntity.ok(booking);
	}
	
	@GetMapping("/package")
	
	public List<TravelPackageDTO> getallpackages(){
		return bookingService.getallpackage();
	}
	
	
	
	//update payment status call after payment sucessful
	
	
	@PutMapping("/{id}/payment-status")
	
	public ResponseEntity<Booking> updatePaymentStatus(@PathVariable Long id,@RequestBody String status){
		Booking update=bookingService.updatePaymentStatus(id, status);
		
		return ResponseEntity.ok(update);
	}
	
@GetMapping("/customers")
	
	public List<CustomerDTO> getallcustomer(){
	
		return bookingService.getallcustomer();
	}
	

	@PostMapping
	public String createBooking(@RequestBody Booking booking) {
		
		return bookingService.createBooking(booking);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
		Booking updated = bookingService.updateBooking(id, booking);
		return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
		bookingService.deleteBooking(id);
		return ResponseEntity.noContent().build();
	}

}
