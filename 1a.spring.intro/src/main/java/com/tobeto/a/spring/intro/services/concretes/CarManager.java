package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.repositories.CarRepository;
import com.tobeto.a.spring.intro.services.abstracts.CarService;
import com.tobeto.a.spring.intro.services.dtos.car.requests.AddCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.responses.GetAllCarResponse;
import com.tobeto.a.spring.intro.services.dtos.car.responses.GetCarByIdResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CarManager implements CarService {
    private final CarRepository carRepository;

    public CarManager(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void add(AddCarRequest request) {
        Car car = new Car();
        car.setModelYear(request.getModelYear());
        car.setModelName(request.getModelName());
        car.setDailyPrice(request.getDaily_price());
        car.setBrand(request.getBrandId());
        car.setPlateNumber(request.getPlateNumber());
        car.setStatus(request.getStatus());
        car.setRentalCompany(request.getRentalCompanyId());
        car.setCarCategory(request.getCategoryId());
        carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest request) {
        Car car = carRepository.findById(request.getId()).orElseThrow();
        car.setModelYear(request.getModelYear());
        car.setModelName(request.getModelName());
        car.setDailyPrice(request.getDaily_price());
        car.setBrand(request.getBrandId());
        car.setPlateNumber(request.getPlateNumber());
        car.setStatus(request.getStatus());
        car.setRentalCompany(request.getRentalCompanyId());
        car.setCarCategory(request.getCategoryId());
        carRepository.save(car);
    }

    @Override
    public void delete(Integer id) {
        Car car = carRepository.findById(id).orElseThrow();
        carRepository.delete(car);
    }

    @Override
    public GetCarByIdResponse getById(Integer id) {
        Car car = carRepository.findById(id).orElseThrow();
        GetCarByIdResponse response = new GetCarByIdResponse();
        response.setStatus(car.getStatus());
        response.setModelYear(car.getModelYear());
        response.setModelName(car.getModelName());
        response.setPlateNumber(car.getPlateNumber());
        response.setBrandId(car.getBrand());
        response.setCategoryId(car.getCarCategory());
        response.setRentalCompanyId(car.getRentalCompany());
        response.setDaily_price(car.getDailyPrice());
        return response;
    }

    @Override
    public List<GetAllCarResponse> getAll() {
        List<Car> carList = carRepository.findAll();
        List<GetAllCarResponse> responseList = new ArrayList<>();
        for (Car car : carList) {
            GetAllCarResponse  response = new GetAllCarResponse();
            response.setId(car.getId());
            response.setStatus(car.getStatus());
            response.setModelYear(car.getModelYear());
            response.setModelName(car.getModelName());
            response.setPlateNumber(car.getPlateNumber());
            response.setBrandId(car.getBrand());
            response.setCategoryId(car.getCarCategory());
            response.setRentalCompanyId(car.getRentalCompany());
            response.setDaily_price(car.getDailyPrice());
            responseList.add(response);
        }
        return responseList;
    }
}
