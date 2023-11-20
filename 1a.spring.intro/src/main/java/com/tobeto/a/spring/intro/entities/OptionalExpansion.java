package com.tobeto.a.spring.intro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "optional-expansions")
@Entity
@Getter
@Setter
public class OptionalExpansion {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @JsonIgnore
    @OneToMany(mappedBy = "optionalExpansion")
    private List<ReservationDetail> reservationDetails;
}
