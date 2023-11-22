package com.tobeto.a.spring.intro.services.dtos.insuranceCompany.requests;

import lombok.Data;

@Data
public class UpdateInsuranceCompanyRequest {
    private Integer id;
    private String name;
    private Double coverageRate;
    private Double price;
}
