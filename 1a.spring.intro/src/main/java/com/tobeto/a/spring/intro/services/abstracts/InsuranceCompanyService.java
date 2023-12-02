package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.insuranceCompany.requests.AddInsuranceCompanyRequest;
import com.tobeto.a.spring.intro.services.dtos.insuranceCompany.requests.UpdateInsuranceCompanyRequest;
import com.tobeto.a.spring.intro.services.dtos.insuranceCompany.responses.GetAllInsuranceCompaniesResponse;

import java.util.List;

public interface InsuranceCompanyService {
    void add(AddInsuranceCompanyRequest request);
    void update(UpdateInsuranceCompanyRequest request);
    void delete(Integer id);
    GetAllInsuranceCompaniesResponse getById(Integer id);
    List<GetAllInsuranceCompaniesResponse> getAll();
    List<GetAllInsuranceCompaniesResponse> getByCoverageRateLessThan(Double rate);
    List<GetAllInsuranceCompaniesResponse> getByPriceGreaterThan(Double price);
}
