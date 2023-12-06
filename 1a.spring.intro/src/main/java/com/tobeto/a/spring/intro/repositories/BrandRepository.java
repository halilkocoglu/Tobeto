package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Brand;
import com.tobeto.a.spring.intro.services.dtos.brand.responses.GetBrandResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Generic typelar reference type olarak  belirtilir.
public interface BrandRepository  extends JpaRepository<Brand, Integer> {

    List<Brand> findByNameStartingWith(String name);
    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.brand.responses.GetBrandResponse(b.id, b.name)"+
    "FROM Brand b WHERE b.id = :id")
    GetBrandResponse findByID(Integer id);

    boolean existsByName(String name);
    boolean existsById(Integer id);

}
