package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Brand;
import com.tobeto.a.spring.intro.repositories.BrandRepository;
import com.tobeto.a.spring.intro.services.abstracts.BrandService;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.responses.GetBrandResponse;
import com.tobeto.a.spring.intro.services.dtos.car.responses.GetCarResponse;
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
    public List<GetBrandResponse> getAll() {
        List<Brand> brandList = brandRepository.findAll();
        List<GetBrandResponse> responseList = new ArrayList<>();
        for (Brand brand: brandList) {
            GetBrandResponse response = new GetBrandResponse();
            response.setId(brand.getId());
            response.setName(brand.getName());
            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public GetBrandResponse getById(Integer id) {
        return brandRepository.findByID(id);
    }

    @Override
    public List<GetBrandResponse> getByName(String name) {
        List<Brand> brandList = brandRepository.findByNameStartingWith(name);
        return brandList.stream().map((brand) ->new GetBrandResponse(brand.getId(), brand.getName()) ).toList();
       /* List<GetBrandResponse> responseList = new ArrayList<>();
        for (Brand brand: brandList) {
            GetBrandResponse response = new GetBrandResponse();
            response.setId(brand.getId());
            response.setName(brand.getName());
            responseList.add(response);
        }
        return responseList;*/
    }
    //(b1,b2) -> b1.getName().compareTo(b2.getName())
    // Comparator.comparing(Brand::getName).thenComparing(brand::getId)...


}
