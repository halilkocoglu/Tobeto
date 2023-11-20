package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Brand;
import com.tobeto.a.spring.intro.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {
    private final BrandRepository brandRepository;
    //Spring IOC => DI Container
    public BrandsController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public List<Brand> getAll () {
        //Hazır bir jpa rep. fonksiyonu - Tüm verileri döner
        List<Brand> brands = brandRepository.findAll();
        return brands;
    }
    @GetMapping("{id}")
    public Brand getById(@PathVariable Integer id) {
        return brandRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody Brand brand ){
        brandRepository.save(brand);
    }
    @DeleteMapping("{id}")
    public void delete (@PathVariable int id) {
        Brand brandToDelete = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brandToDelete);
    }
    //Update
}
