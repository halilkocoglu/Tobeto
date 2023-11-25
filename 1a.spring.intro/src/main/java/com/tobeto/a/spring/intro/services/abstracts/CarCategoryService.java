package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.carCategories.requests.AddCarCategoryRequest;
import com.tobeto.a.spring.intro.services.dtos.carCategories.requests.UpdateCarCategoryRequest;
import com.tobeto.a.spring.intro.services.dtos.carCategories.responses.GetAllCarCategoriesResponse;
import com.tobeto.a.spring.intro.services.dtos.carCategories.responses.GetCarCategoryByIdResponse;

import java.util.List;

public interface CarCategoryService {
    void add(AddCarCategoryRequest request);
    void update(UpdateCarCategoryRequest request);
    void delete(Integer id);
    GetCarCategoryByIdResponse getById(Integer id);
    List<GetAllCarCategoriesResponse> getAll();

}
