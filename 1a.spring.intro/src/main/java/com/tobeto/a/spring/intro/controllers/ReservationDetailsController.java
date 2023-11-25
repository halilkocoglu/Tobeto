package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.ReservationDetail;
import com.tobeto.a.spring.intro.repositories.ReservationDetailRepository;
import com.tobeto.a.spring.intro.services.abstracts.ReservationDetailService;
import com.tobeto.a.spring.intro.services.dtos.reservationDetail.requests.AddReservationDetailRequest;
import com.tobeto.a.spring.intro.services.dtos.reservationDetail.requests.UpdateReservationDetailRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservations/details")
public class ReservationDetailsController {
    private final ReservationDetailService reservationDetailService;

    public ReservationDetailsController(ReservationDetailService reservationDetailService) {
        this.reservationDetailService = reservationDetailService;
    }

    @PostMapping
    public void addReservationDetail (@RequestBody AddReservationDetailRequest request) {
        reservationDetailService.add(request);
    }
    @PutMapping("{id}")
    public void updateReservationDetail (@RequestBody UpdateReservationDetailRequest request){
        reservationDetailService.update(request);
    }
    @DeleteMapping("{id}")
    public void deleteReservationDetail (@PathVariable Integer id){
        reservationDetailService.delete(id);
    }
}
