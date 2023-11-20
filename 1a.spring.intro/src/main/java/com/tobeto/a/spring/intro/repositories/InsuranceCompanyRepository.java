package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.InsuranceCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceCompanyRepository extends JpaRepository<InsuranceCompany, Integer> {
}
