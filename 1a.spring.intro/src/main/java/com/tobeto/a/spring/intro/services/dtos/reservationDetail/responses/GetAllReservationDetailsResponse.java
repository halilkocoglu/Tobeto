package com.tobeto.a.spring.intro.services.dtos.reservationDetail.responses;

import com.tobeto.a.spring.intro.entities.OptionalExpansion;
import com.tobeto.a.spring.intro.entities.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllReservationDetailsResponse {
    private Integer id;
    private Reservation reservation;
    private OptionalExpansion expansion;
    private Integer quantity;
    private Double discount;
}
