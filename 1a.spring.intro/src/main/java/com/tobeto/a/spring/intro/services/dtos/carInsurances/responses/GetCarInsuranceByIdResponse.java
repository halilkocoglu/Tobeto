package com.tobeto.a.spring.intro.services.dtos.carInsurances.responses;

import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.entities.InsuranceCompany;
import lombok.Data;

import java.time.LocalDate;
@Data
public class GetCarInsuranceByIdResponse {
    private InsuranceCompany insuranceCompanyId;
    private Car carId;
    private LocalDate expirationDate;
}
