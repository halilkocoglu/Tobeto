package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.OptionalExpansion;
import com.tobeto.a.spring.intro.services.dtos.optionalExpansions.responses.GetAllExpansionsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OptionalExpansionRepository extends JpaRepository<OptionalExpansion,Integer> {
    List<OptionalExpansion> findByNameStartingWith(String name);
    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.optionalExpansions.responses.GetAllExpansionsResponse"
            + "(oe.id, oe.name, oe.price)"
            + "FROM OptionalExpansion oe ORDER BY oe.price DESC")
    List<GetAllExpansionsResponse> orderByPriceDesc();
}
