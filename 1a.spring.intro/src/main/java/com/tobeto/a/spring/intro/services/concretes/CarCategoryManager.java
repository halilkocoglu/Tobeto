package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.CarCategory;
import com.tobeto.a.spring.intro.repositories.CarCategoryRepository;
import com.tobeto.a.spring.intro.services.abstracts.CarCategoryService;
import com.tobeto.a.spring.intro.services.dtos.carCategories.requests.AddCarCategoryRequest;
import com.tobeto.a.spring.intro.services.dtos.carCategories.requests.UpdateCarCategoryRequest;
import com.tobeto.a.spring.intro.services.dtos.carCategories.responses.GetCarCategoriesResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarCategoryManager implements CarCategoryService {
    private final CarCategoryRepository carCategoryRepository;
    private final String errMessage = "Kategori mevcut.";
    public CarCategoryManager(CarCategoryRepository carCategoryRepository) {
        this.carCategoryRepository = carCategoryRepository;
    }

    @Override
    public void add(AddCarCategoryRequest request) {
        if(carCategoryRepository.existsByName(request.getName())){
            throw new RuntimeException(errMessage);
        }
        CarCategory carCategory = new CarCategory();
        carCategory.setName(request.getName());
        carCategoryRepository.save(carCategory);
    }

    @Override
    public void update(UpdateCarCategoryRequest request) {
        if(!carCategoryRepository.existsById(request.getId())){
            throw new RuntimeException("Geçersiz Id");
        }
        CarCategory carCategory = carCategoryRepository.findById(request.getId()).orElseThrow();
        carCategory.setName(request.getName());
        carCategoryRepository.save(carCategory);


    }

    @Override
    public void delete(Integer id) {
        if(!carCategoryRepository.existsById(id)){
            throw new RuntimeException("Geçersiz Id");
        }
        CarCategory carCategory = carCategoryRepository.findById(id).orElseThrow();
        carCategoryRepository.delete(carCategory);
    }

    @Override
    public GetCarCategoriesResponse getById(Integer id) {
        if(!carCategoryRepository.existsById(id)){
            throw new RuntimeException("Geçersiz Id");
        }
        return carCategoryRepository.findByID(id);
    }

    @Override
    public List<GetCarCategoriesResponse> getAll() {
        List<CarCategory> carCategoryList = carCategoryRepository.findAll();
        List<GetCarCategoriesResponse> responseList = new ArrayList<>();
        for (CarCategory category: carCategoryList) {
            GetCarCategoriesResponse response = new GetCarCategoriesResponse();
            response.setId(category.getId());
            response.setName(category.getName());
            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public List<GetCarCategoriesResponse> getByName(String name) {
        if(!carCategoryRepository.existsByName(name)){
            throw new RuntimeException(errMessage);
        }
        return carCategoryRepository.findAll().stream().filter((carCategory)->carCategory.getName().equals(name))
                .map((carCategory)-> new GetCarCategoriesResponse(carCategory.getId(),carCategory.getName())).toList();
    }
}
