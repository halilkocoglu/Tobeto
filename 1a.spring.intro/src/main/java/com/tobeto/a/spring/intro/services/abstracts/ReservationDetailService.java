package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.reservationDetail.requests.AddReservationDetailRequest;
import com.tobeto.a.spring.intro.services.dtos.reservationDetail.requests.UpdateReservationDetailRequest;

public interface ReservationDetailService {
    void add(AddReservationDetailRequest request);
    void update(UpdateReservationDetailRequest request);
    void delete(Integer id);
}
