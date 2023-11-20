package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
}
