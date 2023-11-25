package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.RentalCompany;
import com.tobeto.a.spring.intro.repositories.RentalCompanyRepository;
import com.tobeto.a.spring.intro.services.abstracts.RentalCompanyService;
import com.tobeto.a.spring.intro.services.dtos.rentalCompany.requests.AddRentalCompanyRequest;
import com.tobeto.a.spring.intro.services.dtos.rentalCompany.requests.UpdateRentalCompanyRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rental-companies")
public class RentalCompaniesController {
    private final RentalCompanyService rentalCompanyService;

    public RentalCompaniesController(RentalCompanyService rentalCompanyService) {
        this.rentalCompanyService = rentalCompanyService;
    }

    @PostMapping
    public void addRentalCompany(@RequestBody AddRentalCompanyRequest request){
        rentalCompanyService.add(request);
    }
    @PutMapping("{id}")
    public void updateRentalCompany (@RequestBody UpdateRentalCompanyRequest request){
        rentalCompanyService.update(request);
    }
    @DeleteMapping("{id}")
    public  void deleteRentalCompany (@PathVariable Integer id){
        rentalCompanyService.delete(id);
    }
}
