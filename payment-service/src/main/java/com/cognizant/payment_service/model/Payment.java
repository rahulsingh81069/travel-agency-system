package com.cognizant.payment_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookingId;

    private String paymentMethod;

    private String paymentStatus;

    private BigDecimal amount;

    private LocalDateTime paymentDate;

    // Getters and Setters
}
