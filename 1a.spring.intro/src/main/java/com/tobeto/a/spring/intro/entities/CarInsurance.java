package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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
