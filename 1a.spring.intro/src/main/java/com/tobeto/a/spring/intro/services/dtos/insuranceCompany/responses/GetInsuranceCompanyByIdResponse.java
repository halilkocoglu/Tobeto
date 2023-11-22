package com.tobeto.a.spring.intro.services.dtos.insuranceCompany.responses;

import lombok.Data;

@Data
public class GetInsuranceCompanyByIdResponse {
    private String name;
    private Double coverageRate;
    private Double price;
}
