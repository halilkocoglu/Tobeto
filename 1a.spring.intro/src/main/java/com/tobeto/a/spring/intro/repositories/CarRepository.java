package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.services.dtos.car.responses.GetCarResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByStatusTrue();
    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.car.responses.GetCarResponse "
            + "(c.id, c.modelYear, c.modelName, c.dailyPrice, c.brand, c.plateNumber, c.status, c.rentalCompany, c.carCategory) "
            + "FROM Car c ORDER BY modelYear DESC")
    List<GetCarResponse> orderByModelYear();
    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.car.responses.GetCarResponse "
            + "(c.id, c.modelYear, c.modelName, c.dailyPrice, c.brand, c.plateNumber, c.status, c.rentalCompany, c.carCategory ) "
            + "FROM Car c WHERE c.dailyPrice >= :price ")
    List<GetCarResponse> graterThanPrice(Double price);
}
