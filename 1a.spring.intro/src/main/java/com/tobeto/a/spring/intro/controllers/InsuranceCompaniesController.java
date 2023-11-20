package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.InsuranceCompany;
import com.tobeto.a.spring.intro.repositories.InsuranceCompanyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/insurance-companies")
public class InsuranceCompaniesController {
    private final InsuranceCompanyRepository insuranceCompanyRepository;

    public InsuranceCompaniesController(InsuranceCompanyRepository insuranceCompanyRepository) {
        this.insuranceCompanyRepository = insuranceCompanyRepository;
    }

    @GetMapping
    public List<InsuranceCompany> getAll() {
        return insuranceCompanyRepository.findAll();
    }
    @GetMapping("{id}")
    public InsuranceCompany getById (@PathVariable Integer id){
        return insuranceCompanyRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void addInsuranceCompany (@RequestBody InsuranceCompany insuranceCompany){
        insuranceCompanyRepository.save(insuranceCompany);
    }
    @DeleteMapping("{id}")
    public void deleteInsuranceCompany (@PathVariable Integer id) {
        InsuranceCompany insuranceCompanyToDelete = insuranceCompanyRepository.findById(id).orElseThrow();
        insuranceCompanyRepository.delete(insuranceCompanyToDelete);
    }
    @PutMapping("{id}")
    public void updateInsuranceCompany (@RequestBody InsuranceCompany insuranceCompany) {
        InsuranceCompany insuranceCompanyToUpdate = insuranceCompanyRepository.findById(insuranceCompany.getId()).orElseThrow();
        insuranceCompanyToUpdate.setName(insuranceCompany.getName());
        insuranceCompanyToUpdate.setCoverageRate(insuranceCompany.getCoverageRate());
        insuranceCompanyToUpdate.setPrice(insuranceCompany.getPrice());
        insuranceCompanyRepository.save(insuranceCompanyToUpdate);
    }
}
