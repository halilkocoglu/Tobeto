package com.tobeto.a.spring.intro.services.dtos.optionalExpansions.requests;

import lombok.Data;

@Data
public class UpdateExpansionsRequest {
    private  Integer id;
    private  String name;
    private Double price;
}
