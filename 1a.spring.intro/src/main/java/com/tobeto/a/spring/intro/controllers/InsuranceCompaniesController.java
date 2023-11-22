package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.services.abstracts.InsuranceCompanyService;
import com.tobeto.a.spring.intro.services.dtos.insuranceCompany.requests.AddInsuranceCompanyRequest;
import com.tobeto.a.spring.intro.services.dtos.insuranceCompany.requests.UpdateInsuranceCompanyRequest;
import com.tobeto.a.spring.intro.services.dtos.insuranceCompany.responses.GetAllInsuranceCompaniesResponse;
import com.tobeto.a.spring.intro.services.dtos.insuranceCompany.responses.GetInsuranceCompanyByIdResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/insurance-companies")
public class InsuranceCompaniesController {
    private final InsuranceCompanyService insuranceCompanyService;

    public InsuranceCompaniesController(InsuranceCompanyService insuranceCompanyService) {
        this.insuranceCompanyService = insuranceCompanyService;
    }

    @PostMapping
    public void addInsuranceCompany (@RequestBody AddInsuranceCompanyRequest request){
        insuranceCompanyService.add(request);
    }
    @PutMapping("{id}")
    public void updateInsuranceCompany (@RequestBody UpdateInsuranceCompanyRequest request) {
        insuranceCompanyService.update(request);
    }
    @DeleteMapping("{id}")
    public void deleteInsuranceCompany (@PathVariable Integer id) {
        insuranceCompanyService.delete(id);
    }
    @GetMapping("{id}")
    public GetInsuranceCompanyByIdResponse getById (@PathVariable Integer id){
        return insuranceCompanyService.getById(id);
    }
    @GetMapping
    public List<GetAllInsuranceCompaniesResponse> getAll() {
        return insuranceCompanyService.getAll();
    }
}
