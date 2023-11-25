package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.reservation.requests.AddReservationRequest;
import com.tobeto.a.spring.intro.services.dtos.reservation.requests.UpdateReservationRequest;

public interface ReservationService {
    void add(AddReservationRequest request);
    void update(UpdateReservationRequest request);
    void delete(Integer id);
}
