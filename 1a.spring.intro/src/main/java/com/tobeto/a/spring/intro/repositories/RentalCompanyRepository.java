package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.RentalCompany;
import com.tobeto.a.spring.intro.services.dtos.rentalCompany.responses.GetAllRentalCompaniesResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentalCompanyRepository extends JpaRepository<RentalCompany, Integer> {
    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.rentalCompany.responses.GetAllRentalCompaniesResponse"
            + "(rc.id, rc.name, rc.location)"
            + "FROM RentalCompany rc")
    List<GetAllRentalCompaniesResponse> findAllCompanies();
    List<RentalCompany> findByNameStartingWith(String name);
    List<RentalCompany> findByLocationStartingWith(String location);
}
