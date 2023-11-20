package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
//Generic typelar reference type olarak  belirtilir.
public interface BrandRepository  extends JpaRepository<Brand, Integer> {

}
