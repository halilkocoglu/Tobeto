package com.tobeto.a.spring.intro.services.dtos.car.requests;

import com.tobeto.a.spring.intro.entities.Brand;
import com.tobeto.a.spring.intro.entities.CarCategory;
import com.tobeto.a.spring.intro.entities.RentalCompany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateCarRequest {
    @NotBlank(message = "Id boş olamaz.")
    private Integer id;
    @NotBlank(message = "Model yılı boş olamaz.")
    private Integer modelYear;
    @NotBlank(message = "Model adı boş olamaz.")
    private String modelName;
    @NotBlank(message = "Fiyat boş olamaz.")
    @Min(value = 0, message = "Fiyat 0'dan büyük olmalı")
    private Double daily_price;
    @NotBlank(message = "Marka boş olamaz.")
    private Brand brand;
    @NotBlank(message = "Plaka boş olamaz.")
    private String plateNumber;
    private Boolean status;
    @NotBlank(message = "Kiralama şirketi boş olamaz.")
    private RentalCompany rentalCompanyId;
    @NotBlank(message = "Kategori boş olamaz.")
    private CarCategory category;
}
