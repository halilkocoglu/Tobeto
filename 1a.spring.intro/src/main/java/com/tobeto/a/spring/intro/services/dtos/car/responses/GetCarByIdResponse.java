package com.tobeto.a.spring.intro.services.dtos.car.responses;

import com.tobeto.a.spring.intro.entities.Brand;
import com.tobeto.a.spring.intro.entities.CarCategory;
import com.tobeto.a.spring.intro.entities.RentalCompany;
import lombok.Data;

@Data
public class GetCarByIdResponse {
    private Integer modelYear;
    private String modelName;
    private Double daily_price;
    private Brand brandId;
    private String plateNumber;
    private Boolean status;
    private RentalCompany rentalCompanyId;
    private CarCategory categoryId;
}
