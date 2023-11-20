package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.RentalCompany;
import com.tobeto.a.spring.intro.repositories.RentalCompanyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rental-companies")
public class RentalCompaniesController {
    private final RentalCompanyRepository rentalCompanyRepository;

    public RentalCompaniesController(RentalCompanyRepository rentalCompanyRepository) {
        this.rentalCompanyRepository = rentalCompanyRepository;
    }

    @GetMapping
    public List<RentalCompany> getAll () {
        return rentalCompanyRepository.findAll();
    }
    @GetMapping("{id}")
    public RentalCompany getById(@PathVariable Integer id) {
        return rentalCompanyRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void addRentalCompany(@RequestBody RentalCompany rentalCompany){
        rentalCompanyRepository.save(rentalCompany);
    }
    @DeleteMapping("{id}")
    public  void deleteRentalCompany (@PathVariable Integer id){
        RentalCompany rentalCompanyToDelete = rentalCompanyRepository.findById(id).orElseThrow();
        rentalCompanyRepository.delete(rentalCompanyToDelete);
    }
    @PutMapping("{id}")
    public void updateRentalCompany (@RequestBody RentalCompany rentalCompany){
        RentalCompany rentalCompanyToUpdate = rentalCompanyRepository.findById(rentalCompany.getId()).orElseThrow();
        rentalCompanyToUpdate.setName(rentalCompany.getName());
        rentalCompanyToUpdate.setLocation(rentalCompany.getLocation());
        rentalCompanyRepository.save(rentalCompanyToUpdate);
    }
}
