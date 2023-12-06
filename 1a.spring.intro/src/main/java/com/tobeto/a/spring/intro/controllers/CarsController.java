package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.services.abstracts.CarService;
import com.tobeto.a.spring.intro.services.dtos.car.requests.AddCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.responses.GetCarResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {
    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public void add (@RequestBody @Valid AddCarRequest request) {
        carService.add(request);
    }
    @PutMapping("{id}")
    public void updateCar (@RequestBody @Valid UpdateCarRequest request) {
        carService.update(request);
    }
    @DeleteMapping("{id}")
    public void deleteCar (@PathVariable Integer id) {
        carService.delete(id);
    }

    @GetMapping
    public List<GetCarResponse> getAll () {
        return carService.getAll();
    }
    @GetMapping("dto-status")
    public List<GetCarResponse> getByStatus(){
        return  carService.findByStatus();
    }
    @GetMapping("dto-modelYear")
    public List<GetCarResponse> orderByModelYear(){
        return carService.orderByModelYear();
    }
    @GetMapping("dto-greater")
    public List<GetCarResponse> getGreaterThanPrice(@RequestParam Double price){
        return carService.greaterThanPrice(price);
    }
}
