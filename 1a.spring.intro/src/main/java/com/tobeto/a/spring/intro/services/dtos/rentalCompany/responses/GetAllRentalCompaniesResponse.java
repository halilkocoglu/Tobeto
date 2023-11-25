package com.tobeto.a.spring.intro.services.dtos.rentalCompany.responses;

import lombok.Data;

@Data
public class GetAllRentalCompaniesResponse {
    private Integer id;
    private String name;
    private String location;
}
