package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.OptionalExpansion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionalExpansionRepository extends JpaRepository<OptionalExpansion,Integer> {
}
