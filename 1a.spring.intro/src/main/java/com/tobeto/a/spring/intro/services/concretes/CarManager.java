package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.repositories.CarRepository;
import com.tobeto.a.spring.intro.services.abstracts.CarService;
import com.tobeto.a.spring.intro.services.dtos.car.requests.AddCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.responses.GetCarResponse;
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
    public GetCarResponse getById(Integer id) {
        Car car = carRepository.findById(id).orElseThrow();
        GetCarResponse response = new GetCarResponse();
        response.setStatus(car.getStatus());
        response.setModelYear(car.getModelYear());
        response.setModelName(car.getModelName());
        response.setPlateNumber(car.getPlateNumber());
        response.setBrand(car.getBrand());
        response.setCarCategory(car.getCarCategory());
        response.setRentalCompany(car.getRentalCompany());
        response.setDailyPrice(car.getDailyPrice());
        return response;
    }

    @Override
    public List<GetCarResponse> getAll() {
        List<Car> carList = carRepository.findAll();
        List<GetCarResponse> responseList = new ArrayList<>();
        for (Car car : carList) {
            GetCarResponse response = new GetCarResponse();
            response.setId(car.getId());
            response.setStatus(car.getStatus());
            response.setModelYear(car.getModelYear());
            response.setModelName(car.getModelName());
            response.setPlateNumber(car.getPlateNumber());
            response.setBrand(car.getBrand());
            response.setCarCategory(car.getCarCategory());
            response.setRentalCompany(car.getRentalCompany());
            response.setDailyPrice(car.getDailyPrice());
            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public List<GetCarResponse> findByStatus() {
        List<Car> carList = carRepository.findByStatusTrue();
        List<GetCarResponse> responseList = new ArrayList<>();
        for (Car car : carList) {
            GetCarResponse response = new GetCarResponse();
            response.setId(car.getId());
            response.setStatus(car.getStatus());
            response.setModelYear(car.getModelYear());
            response.setModelName(car.getModelName());
            response.setPlateNumber(car.getPlateNumber());
            response.setBrand(car.getBrand());
            response.setCarCategory(car.getCarCategory());
            response.setRentalCompany(car.getRentalCompany());
            response.setDailyPrice(car.getDailyPrice());
            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public List<GetCarResponse> orderByModelYear() {
        return carRepository.orderByModelYear();
    }

    @Override
    public List<GetCarResponse> greaterThanPrice(Double price) {
        return carRepository.graterThanPrice(price);
    }
}
