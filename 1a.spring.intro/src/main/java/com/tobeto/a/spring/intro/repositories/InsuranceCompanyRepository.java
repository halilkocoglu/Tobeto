package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.InsuranceCompany;
import com.tobeto.a.spring.intro.services.dtos.insuranceCompany.responses.GetAllInsuranceCompaniesResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InsuranceCompanyRepository extends JpaRepository<InsuranceCompany, Integer> {
    List<InsuranceCompany> findByCoverageRateLessThan(Double rate);
    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.insuranceCompany.responses.GetAllInsuranceCompaniesResponse"
            + "(ic.id, ic.name, ic.coverageRate, ic.price)"
            + "FROM InsuranceCompany ic WHERE ic.price > :price")
    List<GetAllInsuranceCompaniesResponse> findByPriceGreaterThan(Double price);
}
