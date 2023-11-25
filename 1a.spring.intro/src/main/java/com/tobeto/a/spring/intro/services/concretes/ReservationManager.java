package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Reservation;
import com.tobeto.a.spring.intro.repositories.ReservationRepository;
import com.tobeto.a.spring.intro.services.abstracts.ReservationService;
import com.tobeto.a.spring.intro.services.dtos.reservation.requests.AddReservationRequest;
import com.tobeto.a.spring.intro.services.dtos.reservation.requests.UpdateReservationRequest;
import org.springframework.stereotype.Service;

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
        reservation.setOderDate(request.getOrderDate());
        reservation.setPickUpDate(request.getPickUpDate());
        reservation.setDropOffDate(request.getDropOffDate());
        reservationRepository.save(reservation);

    }

    @Override
    public void update(UpdateReservationRequest request) {
        Reservation reservation = reservationRepository.findById(request.getId()).orElseThrow();
        reservation.setCustomer(request.getCustomer());
        reservation.setCar(request.getCar());
        reservation.setOderDate(request.getOrderDate());
        reservation.setPickUpDate(request.getPickUpDate());
        reservation.setDropOffDate(request.getDropOffDate());
        reservationRepository.save(reservation);
    }

    @Override
    public void delete(Integer id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow();
        reservationRepository.delete(reservation);
    }
}
