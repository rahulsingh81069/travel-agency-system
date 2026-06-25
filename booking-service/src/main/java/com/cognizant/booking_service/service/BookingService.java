package com.cognizant.booking_service.service;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.booking_service.client.CustomerClient;
import com.cognizant.booking_service.client.TravelPackageClient;
import com.cognizant.booking_service.dto.CustomerDTO;
import com.cognizant.booking_service.dto.TravelPackageDTO;
import com.cognizant.booking_service.exception.BookingNotFoundException;
import com.cognizant.booking_service.model.Booking;
import com.cognizant.booking_service.repository.BookingRepository;

import feign.FeignException;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private TravelPackageClient travelPackageClient;
	
	@Autowired
	private CustomerClient customerClient;

	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}

	public TravelPackageDTO fetchTravelPackage(Long id) {
		// Fetch package details using Feign
		Optional<Booking> booking = bookingRepository.findById(id);
		TravelPackageDTO travelpackageddto = null;
		if (booking.isPresent()) {
			Long pack_id = booking.get().getPackageId();
			if (pack_id != null) {
				travelpackageddto = travelPackageClient.getPackageById(pack_id);
			}
		}

		return travelpackageddto;
	}

	public List<TravelPackageDTO> getallpackage() {

		ResponseEntity<List<TravelPackageDTO>> response = travelPackageClient.getAllPackages();
		return response.getBody();
	}

	public Booking getBookingById(Long id) {
		return bookingRepository.findById(id)
				.orElseThrow(()->new BookingNotFoundException("Booking not found with id "+ id));
	}

	// public Booking createBooking(Booking booking) {
	// return bookingRepository.save(booking);
	// }
	
	// writng logic to update paymentsatatus from data coming from payment service using id and status
	
	public Booking updatePaymentStatus(Long id , String status) {
		Booking booking= getBookingById(id);
		
		booking .setPaymentStatus(status);
		return bookingRepository.save(booking);
	}

	public String createBooking(Booking booking) {

		try {

			TravelPackageDTO travelpackagedto = travelPackageClient.getPackageById(booking.getPackageId());

			if (travelpackagedto == null) {
				return "package is not avilable";
			}
			
			
			// Fetch customer
	        CustomerDTO customerDTO = customerClient.getCustomerById(booking.getCustomerId());
	        if (customerDTO == null) {
	            return "Customer not found";
	        }

			bookingRepository.save(booking);
			return "Booking saved successfully";

		} catch (FeignException.NotFound e) {
			return "Package or customer not found";
		} catch (Exception e) {
			return e.getMessage();
		}

	}
	
	
	//logic for connecting and acessing data from customer details
	
	public List<CustomerDTO> getallcustomer() {

		List<CustomerDTO> response = customerClient.getAll();
		return response;
	}
	
	


	public Booking updateBooking(Long id, Booking updatedBooking) {
		return bookingRepository.findById(id).map(existing -> {
			existing.setCustomerId(updatedBooking.getCustomerId());
			existing.setPackageId(updatedBooking.getPackageId());
			existing.setBookingDate(updatedBooking.getBookingDate());
			existing.setStatus(updatedBooking.getStatus());
			existing.setTotalAmount(updatedBooking.getTotalAmount());
			existing.setPaymentStatus(updatedBooking.getPaymentStatus());
			return bookingRepository.save(existing);
		}).orElse(null);
	}

	public void deleteBooking(Long id) {
		bookingRepository.deleteById(id);
	}
}