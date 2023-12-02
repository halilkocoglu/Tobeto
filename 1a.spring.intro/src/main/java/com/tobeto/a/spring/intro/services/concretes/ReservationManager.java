package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Reservation;
import com.tobeto.a.spring.intro.repositories.ReservationRepository;
import com.tobeto.a.spring.intro.services.abstracts.ReservationService;
import com.tobeto.a.spring.intro.services.dtos.reservation.requests.AddReservationRequest;
import com.tobeto.a.spring.intro.services.dtos.reservation.requests.UpdateReservationRequest;
import com.tobeto.a.spring.intro.services.dtos.reservation.responses.GetAllReservationsResponse;
import com.tobeto.a.spring.intro.services.dtos.reservation.responses.GetReservationByIdResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationManager  implements ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationManager(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void add(AddReservationRequest request) {
        Reservation reservation = new Reservation();
        reservation.setCustomer(request.getCustomer());
        reservation.setCar(request.getCar());
        reservation.setOrderDate(request.getOrderDate());
        reservation.setPickUpDate(request.getPickUpDate());
        reservation.setDropOffDate(request.getDropOffDate());
        reservationRepository.save(reservation);

    }

    @Override
    public void update(UpdateReservationRequest request) {
        Reservation reservation = reservationRepository.findById(request.getId()).orElseThrow();
        reservation.setCustomer(request.getCustomer());
        reservation.setCar(request.getCar());
        reservation.setOrderDate(request.getOrderDate());
        reservation.setPickUpDate(request.getPickUpDate());
        reservation.setDropOffDate(request.getDropOffDate());
        reservationRepository.save(reservation);
    }

    @Override
    public void delete(Integer id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow();
        reservationRepository.delete(reservation);
    }

    @Override
    public List<GetReservationByIdResponse> getByCustomerId(Integer id) {
        return reservationRepository.findByCustomerId(id);
    }

    @Override
    public List<GetReservationByIdResponse> getByCarId(Integer id) {
        return reservationRepository.findByCarId(id);
    }

    @Override
    public GetAllReservationsResponse getById(Integer id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow();
        GetAllReservationsResponse response = new GetAllReservationsResponse();
        response.setId(reservation.getId());
        response.setCustomer(reservation.getCustomer());
        response.setCar(reservation.getCar());
        response.setOrderDate(reservation.getOrderDate());
        response.setPickUpDate(reservation.getPickUpDate());
        response.setDropOffDate(reservation.getDropOffDate());

        return response;
    }

    @Override
    public List<GetAllReservationsResponse> getAll() {
        List<Reservation> reservationList = reservationRepository.findAll();
        List<GetAllReservationsResponse> responseList = new ArrayList<>();
        for (Reservation reservation:reservationList) {
            GetAllReservationsResponse response = new GetAllReservationsResponse();
            response.setId(reservation.getId());
            response.setCustomer(reservation.getCustomer());
            response.setCar(reservation.getCar());
            response.setOrderDate(reservation.getOrderDate());
            response.setPickUpDate(reservation.getPickUpDate());
            response.setDropOffDate(reservation.getDropOffDate());
            responseList.add(response);
        }
        return responseList;
    }
}
