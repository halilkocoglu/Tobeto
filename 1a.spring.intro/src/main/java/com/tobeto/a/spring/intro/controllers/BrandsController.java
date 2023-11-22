package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.services.abstracts.BrandService;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.responses.GetAllBrandResponse;
import com.tobeto.a.spring.intro.services.dtos.brand.responses.GetByIdBrandResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {
    private final BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<GetAllBrandResponse> getAll () {
        //Hazır bir jpa rep. fonksiyonu - Tüm verileri döner
        return brandService.getAll();
    }
    @GetMapping("{id}")
    public GetByIdBrandResponse getById(@PathVariable Integer id) {
        return brandService.getById(id);
    }
    @DeleteMapping("{id}")
    public void delete (@PathVariable int id) {
        brandService.delete(id);
    }
    @PostMapping
    public void add(@RequestBody AddBrandRequest request ){
        brandService.add(request);
    }

    //Update
    @PutMapping("{id}")
    public void update (@RequestBody UpdateBrandRequest request) {

        brandService.update(request);

    }
}
