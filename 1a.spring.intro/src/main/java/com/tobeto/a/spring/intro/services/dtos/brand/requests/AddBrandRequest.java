package com.tobeto.a.spring.intro.services.dtos.brand.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AddBrandRequest {
    @NotBlank(message = "Marka adı boş olamaz.")
    private String name;
}
