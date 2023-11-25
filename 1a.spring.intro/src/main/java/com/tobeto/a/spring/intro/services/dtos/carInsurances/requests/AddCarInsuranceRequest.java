package com.tobeto.a.spring.intro.services.dtos.carInsurances.requests;

import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.entities.InsuranceCompany;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddCarInsuranceRequest {
    private InsuranceCompany insuranceCompanyId;
    private Car carId;
    private LocalDate expirationDate;
}
