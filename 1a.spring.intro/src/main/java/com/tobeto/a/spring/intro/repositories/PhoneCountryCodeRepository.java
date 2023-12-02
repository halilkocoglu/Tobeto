package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.PhoneCountryCode;
import com.tobeto.a.spring.intro.services.dtos.phoneCountryCode.responses.GetAllCountryCodesResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhoneCountryCodeRepository extends JpaRepository<PhoneCountryCode, Integer> {
    List<PhoneCountryCode> findByNameStartingWith(String name);
    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.phoneCountryCode.responses.GetAllCountryCodesResponse"
            + "(pcc.id, pcc.name, pcc.code)"
            + "FROM PhoneCountryCode pcc ORDER BY pcc.code")
    List<GetAllCountryCodesResponse> orderByCode();
    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.phoneCountryCode.responses.GetAllCountryCodesResponse"
            + "(pcc.id, pcc.name, pcc.code)"
            + "FROM PhoneCountryCode pcc")
    List<GetAllCountryCodesResponse> findAllCodes();
}
