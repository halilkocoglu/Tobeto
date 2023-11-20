package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {
    private final CarRepository carRepository;

    public CarsController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> getAll () {
        List<Car> cars = carRepository.findAll();
        return cars;
    }
    @GetMapping("{id}")
    public Car getById (@PathVariable Integer id){
        return carRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add (@RequestBody Car car) {
        carRepository.save(car);
    }
    @DeleteMapping("{id}")
    public void deleteCar (@PathVariable Integer id) {
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);
    }
    @PutMapping("{id}")
    public void updateCar (@RequestBody Car car) {
        Car carToUpdate = carRepository.findById(car.getId()).orElseThrow();
        carToUpdate.setModelYear(car.getModelYear());
        carToUpdate.setModelName(car.getModelName());
        carToUpdate.setDailyPrice(car.getDailyPrice());
        carToUpdate.setPlateNumber(car.getPlateNumber());
        carToUpdate.setStatus(car.getStatus());
        carToUpdate.setCarCategory(car.getCarCategory());
        carToUpdate.setBrand(car.getBrand());

        carRepository.save(carToUpdate);

    }
}
