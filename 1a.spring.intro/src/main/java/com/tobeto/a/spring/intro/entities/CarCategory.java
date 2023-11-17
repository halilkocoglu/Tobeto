package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "car-categories")
@Entity
public class CarCategory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "carCategory")
    private List<Car> cars;

}
