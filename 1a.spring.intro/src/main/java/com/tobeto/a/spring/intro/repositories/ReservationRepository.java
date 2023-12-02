package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Reservation;
import com.tobeto.a.spring.intro.services.dtos.reservation.responses.GetReservationByIdResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.reservation.responses.GetReservationByIdResponse"
            + "(r.id, c.id, ca.id, r.orderDate, r.pickUpDate, r.dropOffDate) "
            + "FROM Reservation r "
            + "JOIN r.customer c "
            + "JOIN r.car ca "
            + "WHERE c.id = :id ")
    List<GetReservationByIdResponse> findByCustomerId(Integer id);
    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.reservation.responses.GetReservationByIdResponse"
            + "(r.id, c.id, ca.id,r.orderDate, r.pickUpDate, r.dropOffDate)"
            + "FROM Reservation r "
            + "JOIN r.customer c "
            + "JOIN r.car ca "
            + "WHERE ca.id = :id ")
    List<GetReservationByIdResponse> findByCarId(Integer id);
}
