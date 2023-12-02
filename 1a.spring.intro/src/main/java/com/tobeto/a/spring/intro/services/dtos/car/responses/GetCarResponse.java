package com.tobeto.a.spring.intro.services.dtos.car.responses;

import com.tobeto.a.spring.intro.entities.Brand;
import com.tobeto.a.spring.intro.entities.CarCategory;
import com.tobeto.a.spring.intro.entities.RentalCompany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarResponse {
    private Integer id;
    private Integer modelYear;
    private String modelName;
    private Double dailyPrice;
    private Brand brand;
    private String plateNumber;
    private Boolean status;
    private RentalCompany rentalCompany;
    private CarCategory carCategory;
}
