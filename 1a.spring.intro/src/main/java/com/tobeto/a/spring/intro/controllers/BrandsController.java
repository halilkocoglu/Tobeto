package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.services.abstracts.BrandService;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.responses.GetBrandResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {
    private final BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }



    @DeleteMapping("{id}")
    public void delete (@PathVariable int id) {
        brandService.delete(id);
    }
    @PostMapping
    public void add(@RequestBody @Valid AddBrandRequest request ){
        brandService.add(request);
    }

    //Update
    @PutMapping("{id}")
    public void update (@RequestBody @Valid UpdateBrandRequest request) {
        brandService.update(request);
    }
    @GetMapping
    public List<GetBrandResponse> getAll(){
        return brandService.getAll();
    }
    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable Integer id){
        return brandService.getById(id);
    }
    @GetMapping("dto")
    public List<GetBrandResponse> getByName(@RequestParam String name){
        return brandService.getByName(name);
    }
}
