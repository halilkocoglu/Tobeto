package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "brands")
@Entity
public class Brand {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Car> cars;
}
