package com.tobeto.a.spring.intro.services.dtos.rentalCompany.requests;

import lombok.Data;

@Data
public class AddRentalCompanyRequest {
    private String name;
    private String location;
}
