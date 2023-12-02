package com.tobeto.a.spring.intro.services.dtos.reservationDetail.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetReservationDetailByIdResponse {
    private Integer id;
    private Integer reservationId;
    private Integer expansionId;
    private Integer quantity;
    private Double discount;
}
