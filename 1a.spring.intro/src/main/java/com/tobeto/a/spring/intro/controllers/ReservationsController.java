package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Reservation;
import com.tobeto.a.spring.intro.repositories.ReservationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservations")
public class ReservationsController {
    private final ReservationRepository reservationRepository;

    public ReservationsController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public List<Reservation> getAll () {
        return reservationRepository.findAll();
    }
    @GetMapping("{id}")
    public Reservation getById(@PathVariable Integer id) {
        return reservationRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void addReservation (@RequestBody Reservation reservation){
        reservationRepository.save(reservation);
    }
    @DeleteMapping("{id}")
    public void deleteReservation(@PathVariable Integer id) {
        Reservation reservationToDelete = reservationRepository.findById(id).orElseThrow();
        reservationRepository.delete(reservationToDelete);
    }
    @PutMapping("{id}")
    public void updateReservation(@RequestBody Reservation reservation) {
        Reservation reservationToUpdate = reservationRepository.findById(reservation.getId()).orElseThrow();
        reservationToUpdate.setCustomer(reservation.getCustomer());
        reservationToUpdate.setCar(reservation.getCar());
        reservationToUpdate.setOderDate(reservation.getOderDate());
        reservationToUpdate.setPickUpDate(reservation.getPickUpDate());
        reservationToUpdate.setDropOffDate(reservation.getDropOffDate());
        reservationRepository.save(reservationToUpdate);
    }
}
