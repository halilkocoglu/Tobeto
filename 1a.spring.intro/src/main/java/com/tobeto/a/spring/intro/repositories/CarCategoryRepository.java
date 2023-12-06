package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.CarCategory;
import com.tobeto.a.spring.intro.services.dtos.carCategories.responses.GetCarCategoriesResponse;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarCategoryRepository extends JpaRepository<CarCategory, Integer> {
    List<CarCategory> findByNameStartingWith(String name);
    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.carCategories.responses.GetCarCategoriesResponse(c.id, c.name)"+
           "FROM CarCategory c WHERE c.id = :id")
    GetCarCategoriesResponse findByID(Integer id);
    boolean existsById(@NonNull Integer id);
    boolean existsByName(String name);
}
