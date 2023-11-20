package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.ReservationDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationDetailRepository extends JpaRepository<ReservationDetail,Integer> {
}
