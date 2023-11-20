package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.CarCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarCategoryRepository extends JpaRepository<CarCategory, Integer> {
}
