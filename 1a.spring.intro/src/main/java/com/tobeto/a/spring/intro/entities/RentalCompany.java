package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;
import lombok.extern.apachecommons.CommonsLog;

import java.util.List;

@Table(name = "rental-companies")
@Entity
public class RentalCompany {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "rentalCompany")
    private List<Car> cars;


}
