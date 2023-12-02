package com.tobeto.a.spring.intro.services.dtos.reservation.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetReservationByIdResponse {
    private Integer id;
    private Integer customerId;
    private Integer carId;
    private LocalDate orderDate;
    private LocalDate pickUpDate;
    private LocalDate dropOffDate;
}
