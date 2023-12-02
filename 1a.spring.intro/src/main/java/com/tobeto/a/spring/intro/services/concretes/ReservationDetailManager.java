package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.ReservationDetail;
import com.tobeto.a.spring.intro.repositories.ReservationDetailRepository;
import com.tobeto.a.spring.intro.services.abstracts.ReservationDetailService;
import com.tobeto.a.spring.intro.services.dtos.reservationDetail.requests.AddReservationDetailRequest;
import com.tobeto.a.spring.intro.services.dtos.reservationDetail.requests.UpdateReservationDetailRequest;
import com.tobeto.a.spring.intro.services.dtos.reservationDetail.responses.GetAllReservationDetailsResponse;
import com.tobeto.a.spring.intro.services.dtos.reservationDetail.responses.GetReservationDetailByIdResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<GetReservationDetailByIdResponse> getByReservationId(Integer id) {
        return reservationDetailRepository.findByReservationId(id);
    }

    @Override
    public List<GetReservationDetailByIdResponse> getByExpansionId(Integer id) {
        return reservationDetailRepository.findByExpansionId(id);
    }

    @Override
    public List<GetReservationDetailByIdResponse> orderByQuantityDesc() {
        return reservationDetailRepository.orderByQuantityDesc();
    }

    @Override
    public List<GetReservationDetailByIdResponse> orderByDiscountDesc() {
        return reservationDetailRepository.orderByDiscountDesc();
    }

    @Override
    public List<GetAllReservationDetailsResponse> getAll() {
        List<ReservationDetail> reservationDetailList = reservationDetailRepository.findAll();
        List<GetAllReservationDetailsResponse> responseList = new ArrayList<>();
        for (ReservationDetail resDetail:reservationDetailList) {
            GetAllReservationDetailsResponse response = new GetAllReservationDetailsResponse();
            response.setId(resDetail.getId());
            response.setReservation(resDetail.getReservation());
            response.setExpansion(resDetail.getOptionalExpansion());
            response.setQuantity(resDetail.getQuantity());
            response.setDiscount(resDetail.getDiscount());
            responseList.add(response);
        }
        return responseList;
    }
}
