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

    public CarCategoryManager(CarCategoryRepository carCategoryRepository) {
        this.carCategoryRepository = carCategoryRepository;
    }

    @Override
    public void add(AddCarCategoryRequest request) {
        CarCategory carCategory = new CarCategory();
        carCategory.setName(request.getName());
        carCategoryRepository.save(carCategory);
    }

    @Override
    public void update(UpdateCarCategoryRequest request) {
        CarCategory carCategory = carCategoryRepository.findById(request.getId()).orElseThrow();
        carCategory.setName(request.getName());
        carCategoryRepository.save(carCategory);


    }

    @Override
    public void delete(Integer id) {
        CarCategory carCategory = carCategoryRepository.findById(id).orElseThrow();
        carCategoryRepository.delete(carCategory);
    }

    @Override
    public GetCarCategoriesResponse getById(Integer id) {
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
        /*List<CarCategory> carCategoryList = carCategoryRepository.findByNameStartingWith(name);*/
        return carCategoryRepository.findAll().stream().filter((carCategory)->carCategory.getName().equals(name))
                .map((carCategory)-> new GetCarCategoriesResponse(carCategory.getId(),carCategory.getName())).toList();
        /*List<GetCarCategoriesResponse> responseList = new ArrayList<>();
        for (CarCategory cat: carCategoryList) {
            GetCarCategoriesResponse response = new GetCarCategoriesResponse();
            response.setId(cat.getId());
            response.setName(cat.getName());
            responseList.add(response);
        }
        return responseList;*/
    }
}
