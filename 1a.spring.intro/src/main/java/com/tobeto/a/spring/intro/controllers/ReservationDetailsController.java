package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.ReservationDetail;
import com.tobeto.a.spring.intro.repositories.ReservationDetailRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservations/details")
public class ReservationDetailsController {
    private final ReservationDetailRepository reservationDetailRepository;

    public ReservationDetailsController(ReservationDetailRepository reservationDetailRepository) {
        this.reservationDetailRepository = reservationDetailRepository;
    }

    @GetMapping
    public List<ReservationDetail> getAll() {
        return reservationDetailRepository.findAll();
    }
    @GetMapping("{id}")
    public ReservationDetail getById(@PathVariable Integer id) {
        return reservationDetailRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void addReservationDetail (@RequestBody ReservationDetail reservationDetail) {
        reservationDetailRepository.save(reservationDetail);
    }
    @DeleteMapping("{id}")
    public void deleteReservationDetail (@PathVariable Integer id){
        ReservationDetail reservationDetailToDelete = reservationDetailRepository.findById(id).orElseThrow();
        reservationDetailRepository.delete(reservationDetailToDelete);
    }
    @PutMapping("{id}")
    public void updateReservationDetail (@RequestBody ReservationDetail reservationDetail){
        ReservationDetail reservationDetailToUpdate = reservationDetailRepository.findById(reservationDetail.getId()).orElseThrow();
        reservationDetailToUpdate.setReservation(reservationDetail.getReservation());
        reservationDetailToUpdate.setOptionalExpansion(reservationDetail.getOptionalExpansion());
        reservationDetailToUpdate.setQuantity(reservationDetail.getQuantity());
        reservationDetailToUpdate.setDiscount(reservationDetail.getDiscount());
        reservationDetailRepository.save(reservationDetailToUpdate);
    }
}
