package com.tobeto.a.spring.intro.services.dtos.optionalExpansions.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllExpansionsResponse {
    private  Integer id;
    private  String name;
    private Double price;
}
