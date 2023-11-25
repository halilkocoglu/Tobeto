package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.services.abstracts.CarInsuranceService;
import com.tobeto.a.spring.intro.services.dtos.carInsurances.requests.AddCarInsuranceRequest;
import com.tobeto.a.spring.intro.services.dtos.carInsurances.requests.UpdateCarInsuranceRequest;
import com.tobeto.a.spring.intro.services.dtos.carInsurances.responses.GetAllCarInsurancesResponse;
import com.tobeto.a.spring.intro.services.dtos.carInsurances.responses.GetCarInsuranceByIdResponse;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("api/car-insurances")
public class CarInsurancesController {
    private final CarInsuranceService carInsuranceService;

    public CarInsurancesController(CarInsuranceService carInsuranceService) {
        this.carInsuranceService = carInsuranceService;
    }

    @GetMapping
    public List<GetAllCarInsurancesResponse> getAll() {

        return carInsuranceService.getAll();
    }
    @GetMapping("{id}")
    public GetCarInsuranceByIdResponse getById (@PathVariable Integer id) {
        return carInsuranceService.getById(id);
    }
    @PostMapping
    public void addCarInsurance (@RequestBody AddCarInsuranceRequest request) {
        carInsuranceService.add(request);
    }
    @DeleteMapping("{id}")
    public void deleteCarInsurance (@PathVariable Integer id) {
        carInsuranceService.delete(id);
    }
    @PutMapping("{id}")
    public void updateCarInsurance (@RequestBody UpdateCarInsuranceRequest request) {
        carInsuranceService.update(request);
    }
}
