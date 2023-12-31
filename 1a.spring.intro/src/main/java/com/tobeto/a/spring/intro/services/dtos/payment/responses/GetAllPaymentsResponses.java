package com.tobeto.a.spring.intro.services.dtos.payment.responses;

import com.tobeto.a.spring.intro.entities.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPaymentsResponses {
    private Integer id;
    private Reservation reservation;
    private Double amount;
    private LocalDate lastPaymentDate;
}
