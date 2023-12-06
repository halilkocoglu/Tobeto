package com.tobeto.a.spring.intro.services.dtos.carInsurances.requests;

import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.entities.InsuranceCompany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddCarInsuranceRequest {
    @NotBlank
    private InsuranceCompany insuranceCompanyId;
    @NotBlank
    private Car carId;
    @NotBlank
    private LocalDate expirationDate;
}
