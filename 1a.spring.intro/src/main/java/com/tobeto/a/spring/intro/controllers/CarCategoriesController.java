package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.CarCategory;
import com.tobeto.a.spring.intro.repositories.CarCategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/car-categories")
public class CarCategoriesController {
    private final CarCategoryRepository carCategoryRepository;

    public CarCategoriesController(CarCategoryRepository carCategoryRepository) {
        this.carCategoryRepository = carCategoryRepository;
    }

    @GetMapping
    public List<CarCategory> getAll () {
        List<CarCategory> categories = carCategoryRepository.findAll();
        return  categories;
    }
    @GetMapping("{id}")
    public CarCategory getById (@PathVariable Integer id) {
        return carCategoryRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void addCategory (@RequestBody CarCategory carCategory){
        carCategoryRepository.save(carCategory);
    }
    @DeleteMapping("{id}")
    public void deleteCategory (@PathVariable Integer id) {
        CarCategory categoryToDelete = carCategoryRepository.findById(id).orElseThrow();
        carCategoryRepository.delete(categoryToDelete);
    }
    @PutMapping("{id}")
    public void updateCategory (@RequestBody CarCategory carCategory) {
        CarCategory categoryToUpdate  = carCategoryRepository.findById(carCategory.getId()).orElseThrow();
        categoryToUpdate.setName(carCategory.getName());
        carCategoryRepository.save(categoryToUpdate);
    }
}
