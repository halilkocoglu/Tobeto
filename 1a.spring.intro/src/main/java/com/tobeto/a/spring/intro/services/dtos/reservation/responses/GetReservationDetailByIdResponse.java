package com.tobeto.a.spring.intro.services.dtos.reservation.responses;

import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.entities.Customer;
import lombok.Data;

import java.time.LocalDate;

@Data
public class GetReservationDetailByIdResponse {
    private Customer customer;
    private Car car;
    private LocalDate orderDate;
    private LocalDate pickUpDate;
    private LocalDate dropOffDate;
}
