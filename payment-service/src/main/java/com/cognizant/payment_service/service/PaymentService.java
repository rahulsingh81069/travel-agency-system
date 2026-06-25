package com.cognizant.payment_service.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.payment_service.client.BookingClient;
import com.cognizant.payment_service.dto.BookingDTO;
import com.cognizant.payment_service.model.Payment;
import com.cognizant.payment_service.repository.PaymentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    
    @Autowired
    private BookingClient bookingClient;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Long id, Payment updatedPayment) {
        return paymentRepository.findById(id).map(existing -> {
            existing.setBookingId(updatedPayment.getBookingId());
            existing.setPaymentMethod(updatedPayment.getPaymentMethod());
            existing.setPaymentStatus(updatedPayment.getPaymentStatus());
            existing.setAmount(updatedPayment.getAmount());
            existing.setPaymentDate(updatedPayment.getPaymentDate());
            return paymentRepository.save(existing);
        }).orElse(null);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
    
    
    
    public String makePayment(Payment payment) {
        BookingDTO booking = bookingClient.getBookingById(payment.getBookingId());
     
        if (booking == null) {
            throw new RuntimeException("Booking not found");
        }
     
        if (payment.getAmount().compareTo(booking.getTotalAmount()) != 0) {
            return "Payment amount does not match booking amount";
        }
     
        payment.setPaymentStatus("sucess");
        paymentRepository.save(payment);
     
        // update booking status
        bookingClient.updatePaymentStatus(booking.getId(), "PAID");
     
        return "Payment successful for booking " + booking.getId();
    }
     
}
