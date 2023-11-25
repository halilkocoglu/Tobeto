package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.rentalCompany.requests.AddRentalCompanyRequest;
import com.tobeto.a.spring.intro.services.dtos.rentalCompany.requests.UpdateRentalCompanyRequest;

public interface RentalCompanyService {
    void add(AddRentalCompanyRequest request);
    void update(UpdateRentalCompanyRequest request);
    void delete(Integer id);
}
