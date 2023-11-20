package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

// ORM => Object relations mapping
@Table(name = "cars")
@Entity
@Getter
@Setter
public class Car {
    @Id
    @Column(name = "id") //Tablodaki kolon adı
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // class içindeki  alan adı
    @Column(name = "model_year")
    private Integer modelYear;
    @Column(name = "model_name")
    private String modelName;
    @Column(name = "daily_price")
    private Double dailyPrice;
    @Column(name = "plate_number")
    private String plateNumber;
    @Column(name = "status")
    private Boolean status;



    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CarCategory carCategory;
    @ManyToOne
    @JoinColumn(name = "rental_company_id")
    private RentalCompany rentalCompany;
    @OneToMany(mappedBy = "car")
    private List<CarInsurance> carInsurances;
    @OneToMany(mappedBy = "car")
    private List<Reservation> reservations;

}
