package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "phone-country-codes")
@Entity
public class PhoneCountryCode {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "phoneCountryCode")
    private List<CustomerPhone> customerPhones;
}
