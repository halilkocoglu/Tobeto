package com.tobeto.a.spring.intro.services.dtos.reservation.responses;

import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllReservationsResponse {
    private Integer id;
    private Customer customer;
    private Car car;
    private LocalDate orderDate;
    private LocalDate pickUpDate;
    private LocalDate dropOffDate;
}
