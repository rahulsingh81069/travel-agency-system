package com.cognizant.booking_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.booking_service.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
