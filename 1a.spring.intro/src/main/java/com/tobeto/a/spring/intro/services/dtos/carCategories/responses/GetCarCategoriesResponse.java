package com.tobeto.a.spring.intro.services.dtos.carCategories.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarCategoriesResponse {
    private Integer id;
    private String name;
}
