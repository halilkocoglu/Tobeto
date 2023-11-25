package com.tobeto.a.spring.intro.services.dtos.payment.requests;

import com.tobeto.a.spring.intro.entities.Reservation;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddPaymentRequest {
    private Reservation reservation;
    private Double amount;
    private LocalDate lastPaymentDate;
}
