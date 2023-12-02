package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.carCategories.requests.AddCarCategoryRequest;
import com.tobeto.a.spring.intro.services.dtos.carCategories.requests.UpdateCarCategoryRequest;
import com.tobeto.a.spring.intro.services.dtos.carCategories.responses.GetCarCategoriesResponse;

import java.util.List;

public interface CarCategoryService {
    void add(AddCarCategoryRequest request);
    void update(UpdateCarCategoryRequest request);
    void delete(Integer id);
    GetCarCategoriesResponse getById(Integer id);
    List<GetCarCategoriesResponse> getAll();
    List<GetCarCategoriesResponse> getByName(String name);

}
