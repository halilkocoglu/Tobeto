package com.tobeto.a.spring.intro.services.dtos.carInsurances.responses;

import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.entities.InsuranceCompany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarInsuranceResponse {
    private Integer id;
    private InsuranceCompany insuranceCompany;
    private LocalDate expirationDate;
    private Car car;
}
