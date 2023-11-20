package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "insurance-companies")
@Entity
@Getter
@Setter
public class InsuranceCompany {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "coverage_rate")
    private Double coverageRate;
    @Column(name = "price")
    private Double price;

    @OneToMany(mappedBy = "insuranceCompany")
    private List<CarInsurance> carInsurances;
}
