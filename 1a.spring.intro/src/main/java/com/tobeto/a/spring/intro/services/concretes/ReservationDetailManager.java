package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.ReservationDetail;
import com.tobeto.a.spring.intro.repositories.ReservationDetailRepository;
import com.tobeto.a.spring.intro.services.abstracts.ReservationDetailService;
import com.tobeto.a.spring.intro.services.dtos.reservationDetail.requests.AddReservationDetailRequest;
import com.tobeto.a.spring.intro.services.dtos.reservationDetail.requests.UpdateReservationDetailRequest;
import org.springframework.stereotype.Service;

@Service
public class ReservationDetailManager implements ReservationDetailService {
    private final ReservationDetailRepository reservationDetailRepository;

    public ReservationDetailManager(ReservationDetailRepository reservationDetailRepository) {
        this.reservationDetailRepository = reservationDetailRepository;
    }

    @Override
    public void add(AddReservationDetailRequest request) {
        ReservationDetail reservationDetail = new ReservationDetail();
        reservationDetail.setReservation(request.getReservation());
        reservationDetail.setOptionalExpansion(request.getExpansion());
        reservationDetail.setQuantity(request.getQuantity());
        reservationDetail.setDiscount(request.getDiscount());
        reservationDetailRepository.save(reservationDetail);
    }

    @Override
    public void update(UpdateReservationDetailRequest request) {
        ReservationDetail detail = reservationDetailRepository.findById(request.getId()).orElseThrow();
        detail.setReservation(request.getReservation());
        detail.setOptionalExpansion(request.getExpansion());
        detail.setQuantity(request.getQuantity());
        detail.setDiscount(request.getDiscount());
        reservationDetailRepository.save(detail);

    }

    @Override
    public void delete(Integer id) {
        ReservationDetail reservationDetail = reservationDetailRepository.findById(id).orElseThrow();
        reservationDetailRepository.delete(reservationDetail);
    }
}
