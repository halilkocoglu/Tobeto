package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Payment;
import com.tobeto.a.spring.intro.services.dtos.payment.responses.GetAllPaymentsResponses;
import com.tobeto.a.spring.intro.services.dtos.payment.responses.GetPaymentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.payment.responses.GetPaymentResponse"
            + "(p.id,r.id, p.amount, p.lastPaymentDate)"
            + "FROM Payment p JOIN p.reservation r WHERE r.id = :id ")
    GetPaymentResponse findByReservationId(Integer id);
    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.payment.responses.GetAllPaymentsResponses"
            + "(p.id, p.reservation, p.amount, p.lastPaymentDate)"
            + "FROM Payment p")
    List<GetAllPaymentsResponses> findAllPayments();
}
