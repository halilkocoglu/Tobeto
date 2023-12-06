package com.tobeto.a.spring.intro.services.dtos.brand.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UpdateBrandRequest {
    private Integer id;
    @NotBlank(message = "Ad boş olamaz.")
    private String name;
}
