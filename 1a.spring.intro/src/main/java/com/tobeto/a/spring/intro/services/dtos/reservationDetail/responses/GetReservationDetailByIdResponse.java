package com.tobeto.a.spring.intro.services.dtos.reservationDetail.responses;

import com.tobeto.a.spring.intro.entities.OptionalExpansion;
import com.tobeto.a.spring.intro.entities.Reservation;
import lombok.Data;

@Data
public class GetReservationDetailByIdResponse {
    private Reservation reservation;
    private OptionalExpansion expansion;
    private Integer quantity;
    private Double discount;
}
