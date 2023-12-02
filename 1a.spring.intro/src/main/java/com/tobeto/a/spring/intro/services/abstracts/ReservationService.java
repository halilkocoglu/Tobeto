package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.entities.Reservation;
import com.tobeto.a.spring.intro.services.dtos.reservation.requests.AddReservationRequest;
import com.tobeto.a.spring.intro.services.dtos.reservation.requests.UpdateReservationRequest;
import com.tobeto.a.spring.intro.services.dtos.reservation.responses.GetAllReservationsResponse;
import com.tobeto.a.spring.intro.services.dtos.reservation.responses.GetReservationByIdResponse;

import java.util.List;

public interface ReservationService {
    void add(AddReservationRequest request);
    void update(UpdateReservationRequest request);
    void delete(Integer id);
    List<GetReservationByIdResponse> getByCustomerId(Integer id);
    List<GetReservationByIdResponse> getByCarId(Integer id);
    GetAllReservationsResponse getById(Integer id);
    List<GetAllReservationsResponse> getAll();
}
