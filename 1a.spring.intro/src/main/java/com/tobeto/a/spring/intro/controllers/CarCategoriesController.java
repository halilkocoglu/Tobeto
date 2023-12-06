package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.services.abstracts.CarCategoryService;
import com.tobeto.a.spring.intro.services.dtos.carCategories.requests.AddCarCategoryRequest;
import com.tobeto.a.spring.intro.services.dtos.carCategories.requests.UpdateCarCategoryRequest;
import com.tobeto.a.spring.intro.services.dtos.carCategories.responses.GetCarCategoriesResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/car-categories")
public class CarCategoriesController {
    private final CarCategoryService carCategoryService;

    public CarCategoriesController(CarCategoryService carCategoryService) {
        this.carCategoryService = carCategoryService;
    }

    @PostMapping
    public void addCategory (@RequestBody @Valid AddCarCategoryRequest request){
        carCategoryService.add(request);
    }
    @DeleteMapping("{id}")
    public void deleteCategory (@PathVariable  Integer id) {
        carCategoryService.delete(id);
    }
    @PutMapping("{id}")
    public void updateCategory (@RequestBody @Valid UpdateCarCategoryRequest request) {
        carCategoryService.update(request);
    }
    @GetMapping
    public List<GetCarCategoriesResponse> getAll() {
        return carCategoryService.getAll();
    }
    @GetMapping("{id}")
    public GetCarCategoriesResponse getById (@PathVariable Integer id) {
        return carCategoryService.getById(id);
    }
    @GetMapping("dto")
    public List<GetCarCategoriesResponse> getByName(@RequestParam String name) {
        return  carCategoryService.getByName(name);
    }
}
