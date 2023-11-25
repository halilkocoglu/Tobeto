package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.services.abstracts.CarCategoryService;
import com.tobeto.a.spring.intro.services.dtos.carCategories.requests.AddCarCategoryRequest;
import com.tobeto.a.spring.intro.services.dtos.carCategories.requests.UpdateCarCategoryRequest;
import com.tobeto.a.spring.intro.services.dtos.carCategories.responses.GetAllCarCategoriesResponse;
import com.tobeto.a.spring.intro.services.dtos.carCategories.responses.GetCarCategoryByIdResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/car-categories")
public class CarCategoriesController {
    private final CarCategoryService carCategoryService;

    public CarCategoriesController(CarCategoryService carCategoryService) {
        this.carCategoryService = carCategoryService;
    }

    @GetMapping
    public List<GetAllCarCategoriesResponse> getAll() {
        return carCategoryService.getAll();
    }
    @GetMapping("{id}")
    public GetCarCategoryByIdResponse getById (@PathVariable Integer id) {

        return carCategoryService.getById(id);
    }
    @PostMapping
    public void addCategory (@RequestBody AddCarCategoryRequest request){
        carCategoryService.add(request);
    }
    @DeleteMapping("{id}")
    public void deleteCategory (@PathVariable Integer id) {
        carCategoryService.delete(id);
    }
    @PutMapping("{id}")
    public void updateCategory (@RequestBody UpdateCarCategoryRequest request) {
        carCategoryService.update(request);
    }
}
