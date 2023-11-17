package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;

@Table(name = "customer-phones")
@Entity
public class CustomerPhone {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "country_code_id")
    private PhoneCountryCode phoneCountryCode;
}
