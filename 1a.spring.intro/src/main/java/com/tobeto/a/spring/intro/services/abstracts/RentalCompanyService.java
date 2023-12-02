package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.rentalCompany.requests.AddRentalCompanyRequest;
import com.tobeto.a.spring.intro.services.dtos.rentalCompany.requests.UpdateRentalCompanyRequest;
import com.tobeto.a.spring.intro.services.dtos.rentalCompany.responses.GetAllRentalCompaniesResponse;

import java.util.List;

public interface RentalCompanyService {
    void add(AddRentalCompanyRequest request);
    void update(UpdateRentalCompanyRequest request);
    void delete(Integer id);
    List<GetAllRentalCompaniesResponse> getAll();
    List<GetAllRentalCompaniesResponse> getByName(String name);
    List<GetAllRentalCompaniesResponse> getByLocation(String location);
}
