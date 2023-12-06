package com.tobeto.a.spring.intro.services.dtos.car.requests;

import com.tobeto.a.spring.intro.entities.Brand;
import com.tobeto.a.spring.intro.entities.CarCategory;
import com.tobeto.a.spring.intro.entities.RentalCompany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AddCarRequest {
    @NotBlank(message = "Model yılı boş olamaz.")
    @Min(value = 1900, message = "Model yılı en az 1900 olabilir.")
    private Integer modelYear;
    @NotBlank(message = "Model adı boş olamaz.")
    private String modelName;
    @NotBlank(message = "Fiyat boş olamaz.")
    @Min(1)
    private Double daily_price;
    @NotBlank(message = "Marka boş olamaz.")
    @NotBlank
    private Brand brand;
    @NotBlank(message = "Plaka boş olamaz.")
    @Length(min=6, message = "Plaka en az 6 harf uzunluğunda olmalıdır.")
    private String plateNumber;
    @NotBlank(message = "Kiralama şirketi boş olamaz.")
    private RentalCompany rentalCompanyId;
    @NotBlank(message = "Kategori boş olamaz.")
    private CarCategory categoryId;
}
