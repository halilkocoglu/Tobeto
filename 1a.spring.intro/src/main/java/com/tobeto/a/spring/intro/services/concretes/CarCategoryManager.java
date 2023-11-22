package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.CarCategory;
import com.tobeto.a.spring.intro.repositories.CarCategoryRepository;
import com.tobeto.a.spring.intro.services.abstracts.CarCategoryService;
import com.tobeto.a.spring.intro.services.dtos.carCategories.requests.AddCarCategoryRequest;
import com.tobeto.a.spring.intro.services.dtos.carCategories.requests.UpdateCarCategoryRequest;
import com.tobeto.a.spring.intro.services.dtos.carCategories.responses.GetAllCarCategoriesResponse;
import com.tobeto.a.spring.intro.services.dtos.carCategories.responses.GetCarCategoryByIdResponse;
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
    public GetCarCategoryByIdResponse getById(Integer id) {
        CarCategory carCategory = carCategoryRepository.findById(id).orElseThrow();
        GetCarCategoryByIdResponse response = new GetCarCategoryByIdResponse();
        response.setName(carCategory.getName());
        return response;
    }

    @Override
    public List<GetAllCarCategoriesResponse> getAll() {
        List<CarCategory> carCategoryList = carCategoryRepository.findAll();
        List<GetAllCarCategoriesResponse> responseList = new ArrayList<>();
        for (CarCategory category: carCategoryList) {
            GetAllCarCategoriesResponse response = new GetAllCarCategoriesResponse();
            response.setId(category.getId());
            response.setName(category.getName());
            responseList.add(response);
        }
        return responseList;
    }
}
