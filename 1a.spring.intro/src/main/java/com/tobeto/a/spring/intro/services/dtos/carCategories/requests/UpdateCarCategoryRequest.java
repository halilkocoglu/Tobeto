package com.tobeto.a.spring.intro.services.dtos.carCategories.requests;

import lombok.Data;

@Data
public class UpdateCarCategoryRequest {
    private Integer id;
    private String name;
}
