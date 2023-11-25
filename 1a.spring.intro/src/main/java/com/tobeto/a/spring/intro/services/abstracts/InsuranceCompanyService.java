package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.insuranceCompany.requests.AddInsuranceCompanyRequest;
import com.tobeto.a.spring.intro.services.dtos.insuranceCompany.requests.UpdateInsuranceCompanyRequest;
import com.tobeto.a.spring.intro.services.dtos.insuranceCompany.responses.GetAllInsuranceCompaniesResponse;
import com.tobeto.a.spring.intro.services.dtos.insuranceCompany.responses.GetInsuranceCompanyByIdResponse;

import java.util.List;

public interface InsuranceCompanyService {
    void add(AddInsuranceCompanyRequest request);
    void update(UpdateInsuranceCompanyRequest request);
    void delete(Integer id);
    GetInsuranceCompanyByIdResponse getById(Integer id);
    List<GetAllInsuranceCompaniesResponse> getAll();
}
