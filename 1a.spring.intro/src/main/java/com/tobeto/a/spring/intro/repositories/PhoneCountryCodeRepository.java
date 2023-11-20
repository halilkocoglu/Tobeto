package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.PhoneCountryCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneCountryCodeRepository extends JpaRepository<PhoneCountryCode, Integer> {
}
