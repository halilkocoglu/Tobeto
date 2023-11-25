package com.tobeto.a.spring.intro.services.dtos.rentalCompany.requests;

import lombok.Data;


@Data
public class UpdateRentalCompanyRequest {
    private Integer id;
    private String name;
    private String location;
}
