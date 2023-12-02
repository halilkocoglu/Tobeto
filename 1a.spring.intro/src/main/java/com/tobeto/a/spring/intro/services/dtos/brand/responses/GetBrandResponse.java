package com.tobeto.a.spring.intro.services.dtos.brand.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBrandResponse {
    Integer id;
    String name;
}
