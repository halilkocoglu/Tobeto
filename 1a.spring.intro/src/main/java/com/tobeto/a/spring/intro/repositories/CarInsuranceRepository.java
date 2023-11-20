package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.CarInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarInsuranceRepository extends JpaRepository<CarInsurance, Integer> {
}
