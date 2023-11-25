package com.tobeto.a.spring.intro.services.dtos.insuranceCompany.responses;

import lombok.Data;

@Data
public class GetAllInsuranceCompaniesResponse {
    private Integer id;
    private String name;
    private Double coverageRate;
    private Double price;
}
