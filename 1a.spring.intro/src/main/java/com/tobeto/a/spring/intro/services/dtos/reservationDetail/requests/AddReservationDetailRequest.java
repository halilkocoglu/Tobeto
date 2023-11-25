package com.tobeto.a.spring.intro.services.dtos.reservationDetail.requests;

import com.tobeto.a.spring.intro.entities.OptionalExpansion;
import com.tobeto.a.spring.intro.entities.Reservation;
import lombok.Data;

@Data
public class AddReservationDetailRequest {
    private Reservation reservation;
    private OptionalExpansion expansion;
    private Integer quantity;
    private Double discount;
}
