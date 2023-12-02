package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.reservationDetail.requests.AddReservationDetailRequest;
import com.tobeto.a.spring.intro.services.dtos.reservationDetail.requests.UpdateReservationDetailRequest;
import com.tobeto.a.spring.intro.services.dtos.reservationDetail.responses.GetAllReservationDetailsResponse;
import com.tobeto.a.spring.intro.services.dtos.reservationDetail.responses.GetReservationDetailByIdResponse;

import java.util.List;

public interface ReservationDetailService {
    void add(AddReservationDetailRequest request);
    void update(UpdateReservationDetailRequest request);
    void delete(Integer id);
    List<GetReservationDetailByIdResponse> getByReservationId(Integer id);
    List<GetReservationDetailByIdResponse> getByExpansionId(Integer id);
    List<GetReservationDetailByIdResponse> orderByQuantityDesc();
    List<GetReservationDetailByIdResponse> orderByDiscountDesc();
    List<GetAllReservationDetailsResponse> getAll();
}
