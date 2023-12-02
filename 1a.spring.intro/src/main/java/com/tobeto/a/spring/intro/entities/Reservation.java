package com.tobeto.a.spring.intro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "reservations")
@Entity
@Getter
@Setter
public class Reservation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "order_date")
    private LocalDate orderDate;
    @Column(name = "pick_up_date")
    private LocalDate pickUpDate;
    @Column(name = "drop_off_date")
    private LocalDate dropOffDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne
    @JoinColumn(name= "customer_id")
    private Customer customer;
    @JsonIgnore
    @OneToMany(mappedBy = "reservation")
    private List<Payment> payments;
    @JsonIgnore
    @OneToMany(mappedBy = "reservation")
    private List<ReservationDetail> reservationDetails;
}
