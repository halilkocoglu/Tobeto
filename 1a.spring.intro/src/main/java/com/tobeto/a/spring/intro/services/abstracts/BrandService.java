package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.responses.GetBrandResponse;

import java.util.List;

public interface BrandService {
    void add(AddBrandRequest request);
    void update(UpdateBrandRequest request);
    void delete(Integer id);
    List<GetBrandResponse> getAll();
    GetBrandResponse getById(Integer id);
    List<GetBrandResponse> getByName(String name);

}
