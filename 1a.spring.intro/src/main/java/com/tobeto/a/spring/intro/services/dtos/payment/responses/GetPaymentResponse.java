package com.tobeto.a.spring.intro.services.dtos.payment.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPaymentResponse {
    private Integer id;
    private Integer reservationId;
    private Double amount;
    private LocalDate lastPaymentDate;
}
