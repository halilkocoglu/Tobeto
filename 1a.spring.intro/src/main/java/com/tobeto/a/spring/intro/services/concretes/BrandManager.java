package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Brand;
import com.tobeto.a.spring.intro.repositories.BrandRepository;
import com.tobeto.a.spring.intro.services.abstracts.BrandService;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.responses.GetAllBrandResponse;
import com.tobeto.a.spring.intro.services.dtos.brand.responses.GetByIdBrandResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;

    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void add(AddBrandRequest request) {
        Brand brand = new Brand();
        brand.setName(request.getName());
        brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest request) {
        Brand brandToUpdate = brandRepository.findById(request.getId()).orElseThrow();

        brandToUpdate.setName(request.getName());
        brandRepository.save(brandToUpdate);


    }

    @Override
    public void delete(Integer id) {
        Brand brand = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brand);

    }

    @Override
    public List<GetAllBrandResponse> getAll() {
        List<Brand> brandList = brandRepository.findAll();
        List<GetAllBrandResponse> responseList = new ArrayList<>();
        for (Brand brand : brandList) {
            GetAllBrandResponse response = new GetAllBrandResponse();
            response.setId(brand.getId());
            response.setName(brand.getName());
            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public GetByIdBrandResponse getById(Integer id) {
        Brand brand = brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = new GetByIdBrandResponse();
        response.setName(brand.getName());
        return response;
    }


}
