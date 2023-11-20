package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.CustomerPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerPhoneRepository extends JpaRepository<CustomerPhone, Integer> {
}
