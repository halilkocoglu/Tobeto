package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.responses.GetAllBrandResponse;
import com.tobeto.a.spring.intro.services.dtos.brand.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    void add(AddBrandRequest request);
    void update(UpdateBrandRequest request);
    void delete(Integer id);
    List<GetAllBrandResponse> getAll ();
    GetByIdBrandResponse getById(Integer id);

}
