package com.tobeto.a.spring.intro.services.dtos.carCategories.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AddCarCategoryRequest {
    private Integer id;
    @NotBlank(message = "Kategori adı boş olamaz")
    @Length(min = 1, message = "Kategori adı en az bir harf uzunluğunda olmalıdır.")
    private String name;
}
