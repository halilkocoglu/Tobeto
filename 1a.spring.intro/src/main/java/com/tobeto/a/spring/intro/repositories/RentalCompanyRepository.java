package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.RentalCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalCompanyRepository extends JpaRepository<RentalCompany, Integer> {
}
