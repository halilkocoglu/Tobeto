package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.InsuranceCompany;
import com.tobeto.a.spring.intro.repositories.InsuranceCompanyRepository;
import com.tobeto.a.spring.intro.services.abstracts.InsuranceCompanyService;
import com.tobeto.a.spring.intro.services.dtos.insuranceCompany.requests.AddInsuranceCompanyRequest;
import com.tobeto.a.spring.intro.services.dtos.insuranceCompany.requests.UpdateInsuranceCompanyRequest;
import com.tobeto.a.spring.intro.services.dtos.insuranceCompany.responses.GetAllInsuranceCompaniesResponse;
import com.tobeto.a.spring.intro.services.dtos.insuranceCompany.responses.GetInsuranceCompanyByIdResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsuranceCompanyManager implements InsuranceCompanyService {
    private final InsuranceCompanyRepository insuranceCompanyRepository;

    public InsuranceCompanyManager(InsuranceCompanyRepository insuranceCompanyRepository) {
        this.insuranceCompanyRepository = insuranceCompanyRepository;
    }

    @Override
    public void add(AddInsuranceCompanyRequest request) {
        InsuranceCompany insuranceCompany = new InsuranceCompany();
        insuranceCompany.setName(request.getName());
        insuranceCompany.setCoverageRate(request.getCoverageRate());
        insuranceCompany.setPrice(request.getPrice());
        insuranceCompanyRepository.save(insuranceCompany);
    }

    @Override
    public void update(UpdateInsuranceCompanyRequest request) {
        InsuranceCompany insuranceCompany = insuranceCompanyRepository.findById(request.getId()).orElseThrow();
        insuranceCompany.setName(request.getName());
        insuranceCompany.setCoverageRate(request.getCoverageRate());
        insuranceCompany.setPrice(request.getPrice());
        insuranceCompanyRepository.save(insuranceCompany);

    }

    @Override
    public void delete(Integer id) {
        InsuranceCompany insuranceCompany = insuranceCompanyRepository.findById(id).orElseThrow();
        insuranceCompanyRepository.delete(insuranceCompany);
    }

    @Override
    public GetInsuranceCompanyByIdResponse getById(Integer id) {
        InsuranceCompany insuranceCompany = insuranceCompanyRepository.findById(id).orElseThrow();
        GetInsuranceCompanyByIdResponse response = new GetInsuranceCompanyByIdResponse();
        response.setName(insuranceCompany.getName());
        response.setCoverageRate(insuranceCompany.getCoverageRate());
        response.setPrice(insuranceCompany.getPrice());
        return response;
    }

    @Override
    public List<GetAllInsuranceCompaniesResponse> getAll() {
        List<InsuranceCompany> insuranceCompanyList = insuranceCompanyRepository.findAll();
        List<GetAllInsuranceCompaniesResponse> responseList = new ArrayList<>();
        for (InsuranceCompany company : insuranceCompanyList) {
            GetAllInsuranceCompaniesResponse response = new GetAllInsuranceCompaniesResponse();
            response.setId(company.getId());
            response.setName(company.getName());
            response.setCoverageRate(company.getCoverageRate());
            response.setPrice(company.getPrice());
            responseList.add(response);
        }
        return responseList;
    }
}
