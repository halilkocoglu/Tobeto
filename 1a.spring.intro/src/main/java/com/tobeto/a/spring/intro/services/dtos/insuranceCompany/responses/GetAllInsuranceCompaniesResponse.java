package com.tobeto.a.spring.intro.services.dtos.insuranceCompany.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllInsuranceCompaniesResponse {
    private Integer id;
    private String name;
    private Double coverageRate;
    private Double price;
}
