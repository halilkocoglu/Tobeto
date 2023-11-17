package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "customers")
@Entity
public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "email")
    private String email;
    @Column(name = "age")
    private Short age;

    @OneToMany(mappedBy = "customer")
    private List<CustomerPhone> customerPhones;
    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations;
}
