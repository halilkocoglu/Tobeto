package com.tobeto.a.spring.intro.services.dtos.brand.requests;

import lombok.Data;

@Data
public class UpdateBrandRequest {
    private Integer id;
    private String name;
}
