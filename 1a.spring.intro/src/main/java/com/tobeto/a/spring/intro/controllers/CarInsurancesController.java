package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.CarInsurance;
import com.tobeto.a.spring.intro.repositories.CarInsuranceRepository;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("api/car-insurances")
public class CarInsurancesController {
    private final CarInsuranceRepository carInsuranceRepository;

    public CarInsurancesController(CarInsuranceRepository carInsuranceRepository) {
        this.carInsuranceRepository = carInsuranceRepository;
    }
    @GetMapping
    public List<CarInsurance> getAll() {
        return carInsuranceRepository.findAll();
    }
    @GetMapping("{id}")
    public CarInsurance getById (@PathVariable Integer id) {
        return carInsuranceRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void addCarInsurance (@RequestBody CarInsurance carInsurance) {
        carInsuranceRepository.save(carInsurance);
    }
    @DeleteMapping("{id}")
    public void deleteCarInsurance (@PathVariable Integer id) {
        CarInsurance insuranceToDelete = carInsuranceRepository.findById(id).orElseThrow();
        carInsuranceRepository.delete(insuranceToDelete);
    }
    @PutMapping("{id}")
    public void updateCarInsurance (@RequestBody CarInsurance carInsurance) {
        CarInsurance insuranceToUpdate = carInsuranceRepository.findById(carInsurance.getId()).orElseThrow();
        insuranceToUpdate.setInsuranceCompany(carInsurance.getInsuranceCompany());
        insuranceToUpdate.setExpirationDate(carInsurance.getExpirationDate());
        insuranceToUpdate.setCar(carInsurance.getCar());

        carInsuranceRepository.save(insuranceToUpdate);
    }
}
