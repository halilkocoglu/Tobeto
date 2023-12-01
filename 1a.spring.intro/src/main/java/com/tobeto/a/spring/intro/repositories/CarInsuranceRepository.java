package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.CarInsurance;
import com.tobeto.a.spring.intro.services.dtos.carCategories.responses.GetCarCategoriesResponse;
import com.tobeto.a.spring.intro.services.dtos.carInsurances.responses.GetCarInsuranceResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarInsuranceRepository extends JpaRepository<CarInsurance, Integer> {
    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.carInsurances.responses.GetCarInsuranceResponse(c.id, insuranceCompany, c.expirationDate, car)"+
         ("FROM CarInsurance c WHERE c.id = :id"))
    GetCarInsuranceResponse findByID(Integer id);
}
