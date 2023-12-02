package com.tobeto.a.spring.intro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "car-insurances")
@Entity
@Getter
@Setter
public class CarInsurance {
   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
   @Column(name = "expiration_date")
    private LocalDate expirationDate;
   @ManyToOne
   @JoinColumn(name = "car_id")
   private Car car;
   @ManyToOne
   @JoinColumn(name = "insurance_company_id")
   private InsuranceCompany insuranceCompany;
}
