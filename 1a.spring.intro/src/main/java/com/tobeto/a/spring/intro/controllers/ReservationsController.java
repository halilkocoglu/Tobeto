package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Reservation;
import com.tobeto.a.spring.intro.repositories.ReservationRepository;
import com.tobeto.a.spring.intro.services.abstracts.ReservationService;
import com.tobeto.a.spring.intro.services.dtos.reservation.requests.AddReservationRequest;
import com.tobeto.a.spring.intro.services.dtos.reservation.requests.UpdateReservationRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservations")
public class ReservationsController {
    private final ReservationService reservationService;

    public ReservationsController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public void addReservation (@RequestBody AddReservationRequest request){
        reservationService.add(request);
    }
    @PutMapping("{id}")
    public void updateReservation(@RequestBody UpdateReservationRequest request) {
        reservationService.update(request);
    }
    @DeleteMapping("{id}")
    public void deleteReservation(@PathVariable Integer id) {
        reservationService.delete(id);
    }
}
