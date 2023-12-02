package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.ReservationDetail;
import com.tobeto.a.spring.intro.services.dtos.reservationDetail.responses.GetReservationDetailByIdResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationDetailRepository extends JpaRepository<ReservationDetail,Integer> {
    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.reservationDetail.responses.GetReservationDetailByIdResponse"
            + "(rd.id, r.id, oe.id, rd.quantity, rd.discount)"
            + "FROM ReservationDetail rd "
            + "JOIN rd.reservation r "
            + "JOIN rd.optionalExpansion oe "
            + "WHERE r.id = :id")
    List<GetReservationDetailByIdResponse> findByReservationId(Integer id);
    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.reservationDetail.responses.GetReservationDetailByIdResponse"
            + "(rd.id, r.id, oe.id, rd.quantity, rd.discount)"
            + "FROM ReservationDetail rd "
            + "JOIN rd.reservation r "
            + "JOIN rd.optionalExpansion oe "
            + "WHERE oe.id = :id ")
    List<GetReservationDetailByIdResponse> findByExpansionId(Integer id);
    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.reservationDetail.responses.GetReservationDetailByIdResponse"
            + "(rd.id, r.id, oe.id, rd.quantity, rd.discount)"
            + "FROM ReservationDetail rd "
            + "JOIN rd.reservation r "
            + "JOIN rd.optionalExpansion oe "
            + "ORDER BY rd.quantity DESC")
    List<GetReservationDetailByIdResponse> orderByQuantityDesc ();
    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.reservationDetail.responses.GetReservationDetailByIdResponse"
            + "(rd.id, r.id, oe.id, rd.quantity, rd.discount)"
            + "FROM ReservationDetail rd "
            + "JOIN rd.reservation r "
            + "JOIN rd.optionalExpansion oe "
            + "ORDER BY rd.discount DESC")
    List<GetReservationDetailByIdResponse> orderByDiscountDesc ();
}
