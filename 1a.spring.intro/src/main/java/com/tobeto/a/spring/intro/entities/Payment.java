package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "payments")
@Entity
public class Payment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "last_payment_date")
    private LocalDate lastPaymentDate;
    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

}
