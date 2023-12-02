package com.tobeto.a.spring.intro.services.dtos.rentalCompany.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllRentalCompaniesResponse {
    private Integer id;
    private String name;
    private String location;
}
