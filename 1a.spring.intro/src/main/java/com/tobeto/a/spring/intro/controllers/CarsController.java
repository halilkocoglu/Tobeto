package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.repositories.CarRepository;
import com.tobeto.a.spring.intro.services.abstracts.CarService;
import com.tobeto.a.spring.intro.services.dtos.car.requests.AddCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.responses.GetAllCarResponse;
import com.tobeto.a.spring.intro.services.dtos.car.responses.GetCarByIdResponse;
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
    public void add (@RequestBody AddCarRequest request) {
        carService.add(request);
    }
    @PutMapping("{id}")
    public void updateCar (@RequestBody UpdateCarRequest request) {
        carService.update(request);
    }
    @DeleteMapping("{id}")
    public void deleteCar (@PathVariable Integer id) {
        carService.delete(id);
    }
    @GetMapping("{id}")
    public GetCarByIdResponse getById (@PathVariable Integer id){
        return carService.getById(id);
    }
    @GetMapping
    public List<GetAllCarResponse> getAll () {
        return carService.getAll();
    }
}
