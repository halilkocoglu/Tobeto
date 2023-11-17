package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;

@Table(name = "reservation-details")
@Entity
public class ReservationDetail {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "discount")
    private Double discount;
    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
    @ManyToOne
    @JoinColumn(name = "expansion_id")
    private  OptionalExpansion optionalExpansion;
}
