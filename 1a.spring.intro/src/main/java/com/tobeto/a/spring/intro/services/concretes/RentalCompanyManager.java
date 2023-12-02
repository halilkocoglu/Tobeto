package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.RentalCompany;
import com.tobeto.a.spring.intro.repositories.RentalCompanyRepository;
import com.tobeto.a.spring.intro.services.abstracts.RentalCompanyService;
import com.tobeto.a.spring.intro.services.dtos.rentalCompany.requests.AddRentalCompanyRequest;
import com.tobeto.a.spring.intro.services.dtos.rentalCompany.requests.UpdateRentalCompanyRequest;
import com.tobeto.a.spring.intro.services.dtos.rentalCompany.responses.GetAllRentalCompaniesResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalCompanyManager implements RentalCompanyService {
    private final RentalCompanyRepository rentalCompanyRepository;

    public RentalCompanyManager(RentalCompanyRepository rentalCompanyRepository) {
        this.rentalCompanyRepository = rentalCompanyRepository;
    }

    @Override
    public void add(AddRentalCompanyRequest request) {
        RentalCompany company = new RentalCompany();
        company.setName(request.getName());
        company.setLocation(request.getLocation());
        rentalCompanyRepository.save(company);
    }

    @Override
    public void update(UpdateRentalCompanyRequest request) {
        RentalCompany rentalCompany = rentalCompanyRepository.findById(request.getId()).orElseThrow();
        rentalCompany.setName(request.getName());
        rentalCompany.setLocation(request.getLocation());
        rentalCompanyRepository.save(rentalCompany);
    }

    @Override
    public void delete(Integer id) {
        RentalCompany company = rentalCompanyRepository.findById(id).orElseThrow();
        rentalCompanyRepository.delete(company);
    }

    @Override
    public List<GetAllRentalCompaniesResponse> getAll() {
        return rentalCompanyRepository.findAllCompanies();
    }

    @Override
    public List<GetAllRentalCompaniesResponse> getByName(String name) {
        List<RentalCompany> companyList = rentalCompanyRepository.findByNameStartingWith(name);
        List<GetAllRentalCompaniesResponse> responseList = new ArrayList<>();
        for (RentalCompany company:companyList) {
            GetAllRentalCompaniesResponse response = new GetAllRentalCompaniesResponse();
            response.setId(company.getId());
            response.setName(company.getName());
            response.setLocation(company.getLocation());
            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public List<GetAllRentalCompaniesResponse> getByLocation(String location) {
        List<RentalCompany> companyList = rentalCompanyRepository.findByLocationStartingWith(location);
        List<GetAllRentalCompaniesResponse> responseList = new ArrayList<>();
        for (RentalCompany company : companyList){
            GetAllRentalCompaniesResponse response = new GetAllRentalCompaniesResponse();
            response.setId(company.getId());
            response.setName(company.getName());
            response.setLocation(company.getLocation());
            responseList.add(response);
        }
        return responseList;
    }
}
